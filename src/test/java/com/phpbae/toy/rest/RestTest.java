package com.phpbae.toy.rest;


import com.phpbae.toy.Domain.VO.MemberVO;
import com.phpbae.toy.Service.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RestTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MemberServiceImpl memberService;

    @Test
    public void getMembersTest() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/members", String.class);
        List<MemberVO> memberVOList = Arrays.asList(testRestTemplate.getForObject("/api/members", MemberVO[].class));
        List<MemberVO> voList = memberService.getMembers();
        System.out.println(responseEntity.getBody());
        assertEquals("데이터 결과수는 동일한가 : ", true, voList.size() == memberVOList.size());
        assertEquals("데이터도 정확한가 : ", true, voList.get(2).getName().equals(memberVOList.get(2).getName()));
    }

    @Test
    public void getMemberTest() {
        final int idx = 1;
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/members/" + idx, String.class);
        MemberVO obj1 = testRestTemplate.getForObject("/api/members/" + idx, MemberVO.class);
        MemberVO obj2 = memberService.getMember(idx);
        System.out.println(responseEntity.getBody());

        assertEquals("조회 된 데이터는 동일한가(이름) : ", true, obj1.getName().equals(obj2.getName()));
        assertEquals("조회 된 데이터는 동일한가(이메일) : ", true, obj1.getEmail().equals(obj2.getEmail()));
        assertEquals("조회 된 데이터는 동일한가(나이) : ", true, obj1.getAge() == obj2.getAge());

        final int idx2 = 9999;
        ResponseEntity<String> responseEntity2 = testRestTemplate.getForEntity("/api/members/" + idx2, String.class);
        System.out.println(responseEntity2.getBody());
        MemberVO obj3 = testRestTemplate.getForObject("/api/members/" + idx2, MemberVO.class);
        assertEquals("9999 idx는 존재하지 않는다 : ", null, obj3);
    }

    @Test
    public void insertMemberTest() {

        MemberVO memberVO = new MemberVO();
        memberVO.setEmail("insertTest@naver.com");
        memberVO.setPassword("1111");
        memberVO.setAge(30);
        memberVO.setName("삽입테스트");

        MemberVO insertedVO = testRestTemplate.postForObject("/api/members/insert", memberVO, MemberVO.class);

        MemberVO vo = memberService.getMember(insertedVO.getMemberIdx());

        assertNotNull(insertedVO);
        assertNotNull(vo);
        assertEquals("idx : ", true, insertedVO.getMemberIdx() == vo.getMemberIdx());
        assertEquals("이름 : ", "삽입테스트", insertedVO.getName());
        assertEquals("이름값은 같은가 : ", true, insertedVO.getName().equals(vo.getName()));

        memberService.deleteMember(insertedVO.getMemberIdx());
    }

    @Test
    public void modifyMemberTest() {

        MemberVO memberVO = new MemberVO();
        memberVO.setEmail("insertTest@naver.com");
        memberVO.setPassword("1111");
        memberVO.setAge(30);
        memberVO.setName("삽입테스트");

        MemberVO insertedVO = testRestTemplate.postForObject("/api/members/insert", memberVO, MemberVO.class);

        MemberVO memberVO2 = new MemberVO();
        memberVO2.setEmail("insertTest@naver.com");
        memberVO2.setPassword("2222");
        memberVO2.setAge(50);
        memberVO2.setName("수정테스트");
        memberVO2.setAdministratorRights(false);

        testRestTemplate.put("/api/members/modify/" + insertedVO.getMemberIdx(), memberVO2);

        MemberVO modifyVO = memberService.getMember(insertedVO.getMemberIdx());

        assertEquals("비밀번호 변경 : ", "2222", modifyVO.getPassword());
        assertEquals("이름 변경 : ", "수정테스트", modifyVO.getName());

        memberService.deleteMember(insertedVO.getMemberIdx());

    }

    @Test
    public void deleteMemberTest() {
        List<MemberVO> memberVOList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MemberVO memberVO = new MemberVO();
            memberVO.setEmail("insertTest@naver.com");
            memberVO.setPassword("1111");
            memberVO.setAge(30);
            memberVO.setName("삽입테스트");
            memberVOList.add(memberVO);
        }

        List<MemberVO> insertedMemberVOList = new ArrayList<>();
        for(MemberVO memberVO : memberVOList) {
            insertedMemberVOList.add(testRestTemplate.postForObject("/api/members/insert", memberVO, MemberVO.class));
        }

        assertEquals("생성된 데이터 수 : ", 10, insertedMemberVOList.size());

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        for(MemberVO memberVO : insertedMemberVOList) {
            Map<String, String> map = new HashMap<>();
            map.put("idx", String.valueOf(memberVO.getMemberIdx()));
            testRestTemplate.exchange("/api/members/delete/{idx}", HttpMethod.DELETE, entity, String.class, map);
        }

        MemberVO deletedMemberVO = memberService.getMember(insertedMemberVOList.get(5).getMemberIdx());
        assertNull(deletedMemberVO);
    }

}
