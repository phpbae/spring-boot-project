package com.phpbae.toy.service;

import com.phpbae.toy.domain.Member;
import com.phpbae.toy.domain.MemberInformation;
import com.phpbae.toy.domain.vo.MemberVO;
import com.phpbae.toy.repository.MemberRepository;
import com.phpbae.toy.repository.MemberSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSalaryRepository memberSalaryRepository;

    public List<MemberVO> getMembers() {
        List<Member> memberList = memberRepository.getAllMembers();
        return memberList.stream()
                .map(member -> new MemberVO(member))
                .collect(Collectors.toList());
    }

    public MemberVO getMember(int idx) {
        return memberRepository.findById(idx)
                .map(member -> new MemberVO(member))
                .orElse(null);
    }

    @Override
    public MemberVO setMember(MemberVO memberVO) {

        Member member = new Member();
        member.setEmail(memberVO.getEmail());
        member.setPassword(memberVO.getPassword());

        MemberInformation memberInformation = new MemberInformation();
        memberInformation.setAge(memberVO.getAge());
        memberInformation.setName(memberVO.getName());
        memberInformation.setAdministratorRights(false);
        memberInformation.setRecentAccessDate(LocalDate.now());
        memberInformation.setRegistrationDate(LocalDate.now());
        member.setMemberInformation(memberInformation);

        Member insertedMember = memberRepository.save(member);

        return new MemberVO(insertedMember);
    }

    @Override
    public MemberVO modifyMember(int idx, MemberVO memberVO) {
        Member member = memberRepository.getOne(idx);

        member.setEmail(memberVO.getEmail());
        member.setPassword(memberVO.getPassword());
        member.getMemberInformation().setName(memberVO.getName());
        member.getMemberInformation().setAge(memberVO.getAge());
        member.getMemberInformation().setAdministratorRights(memberVO.getAdministratorRights());

        return new MemberVO(memberRepository.save(member));
    }

    @Override
    public void deleteMember(int idx) {
        memberSalaryRepository.deleteMemberSalaryByIdx(idx);
        memberRepository.deleteMemberByIdx(idx);
    }

    @Override
    public void testTransaction(List<Member> members) {
        memberRepository.saveAll(members);
        int error = 0 / 0; //error 발생
    }

    @Override
    public void testTransactionMethodLevel(List<Member> members) {
        //readOnly 이기 때문에, insert 시, 에러 발생.
        memberRepository.saveAll(members);
    }
}
