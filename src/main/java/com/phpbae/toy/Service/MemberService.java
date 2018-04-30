package com.phpbae.toy.Service;

import com.phpbae.toy.Domain.Member;
import com.phpbae.toy.Domain.VO.MemberVO;

import java.util.List;

public interface MemberService {
    public List<MemberVO> getMembers();

    public MemberVO getMember(int idx);

    //    @Transactional(propagation =  Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
    public void testTransaction(List<Member> members);
}
