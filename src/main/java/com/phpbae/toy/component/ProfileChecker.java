package com.phpbae.toy.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileChecker {

    @Autowired
    private Environment env;

    public String[] getActiveProfile(){
        return env.getActiveProfiles();
    }
}
