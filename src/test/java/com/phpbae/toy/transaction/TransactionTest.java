package com.phpbae.toy.transaction;

import com.phpbae.toy.Domain.Member;
import com.phpbae.toy.Service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Autowired
    private MemberService memberServiceImpl;

    @Test(expected = ArithmeticException.class)
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

    @Test(expected = Exception.class)
    public void 읽기전용트랜잭션Test() throws Exception {
        List<Member> memberList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setEmail("test@naver.com");
            member.setMemberInformation(null);
            member.setPassword("1234");
            memberList.add(member);
        }
        memberServiceImpl.testTransactionMethodLevel(memberList);
    }

}
