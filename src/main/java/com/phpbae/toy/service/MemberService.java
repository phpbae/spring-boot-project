package com.phpbae.toy.service;

import com.phpbae.toy.domain.Member;
import com.phpbae.toy.domain.vo.MemberVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
public interface MemberService {
    public List<MemberVO> getMembers();

    public MemberVO getMember(int idx);

    public MemberVO setMember(MemberVO memberVO);

    public MemberVO modifyMember(int idx, MemberVO memberVO);

    public void deleteMember(int idx);

    public void testTransaction(List<Member> members);

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public void testTransactionMethodLevel(List<Member> members);
}
