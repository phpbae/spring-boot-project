package com.phpbae.toy.Controller;

import com.phpbae.toy.Component.ProfileChecker;
import com.phpbae.toy.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getActiveProfile() {
        return new ResponseEntity(profileChecker.getActiveProfile(), HttpStatus.OK);
    }

}
