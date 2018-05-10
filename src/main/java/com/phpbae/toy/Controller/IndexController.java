package com.phpbae.toy.Controller;

import com.phpbae.toy.Component.ProfileChecker;
import com.phpbae.toy.Domain.VO.MemberVO;
import com.phpbae.toy.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private MemberService memberServiceImpl;

    @Autowired
    private ProfileChecker profileChecker;

    @GetMapping(value = "/members", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getMembers() {
        return new ResponseEntity(memberServiceImpl.getMembers(), HttpStatus.OK);
    }

    @GetMapping(value = "/members/{idx}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getMember(@PathVariable(name = "idx") int idx) {
        return new ResponseEntity(memberServiceImpl.getMember(idx), HttpStatus.OK);
    }

    @PostMapping(value = "members/insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity insertMember(@ModelAttribute MemberVO memberVO) {
        return new ResponseEntity(memberServiceImpl.setMember(memberVO), HttpStatus.OK);
    }

    @PutMapping(value = "members/modify/{idx}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity modifyMember(@PathVariable(name = "idx") int idx, @ModelAttribute MemberVO memberVO) {
        return null;
    }

    @DeleteMapping(value = "members/delete/{idx}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteMember(@PathVariable(name = "idx") int idx) {
        return null;
    }

    @GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getActiveProfile() {
        return new ResponseEntity(profileChecker.getActiveProfile(), HttpStatus.OK);
    }

}
