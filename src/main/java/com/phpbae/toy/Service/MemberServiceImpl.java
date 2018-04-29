package com.phpbae.toy.Service;

import com.phpbae.toy.Domain.Member;
import com.phpbae.toy.Domain.VO.MemberVO;
import com.phpbae.toy.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVO> getMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream()
                .map(member -> new MemberVO(member))
                .collect(Collectors.toList());
    }

    public MemberVO getMember(int idx) {
        return memberRepository.findById(idx)
                .map(member -> new MemberVO(member))
                .get();
    }

    public void testTransaction(List<Member> members) {
        memberRepository.saveAll(members);
//        int error = 0 / 0; //error 발생
    }
}
