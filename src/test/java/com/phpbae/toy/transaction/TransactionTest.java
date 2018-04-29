package com.phpbae.toy.transaction;

import com.phpbae.toy.Service.MemberServiceImpl;
import com.phpbae.toy.Domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @Test
    public void 트랜잭션Test() throws Exception {
        List<Member> memberList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setEmail("test@naver.com");
            member.setMemberInformation(null);
            member.setPassword("1234");
            memberList.add(member);
        }
        memberServiceImpl.testTransaction(memberList);
    }

}
