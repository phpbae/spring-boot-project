package com.phpbae.toy.Configure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfiguration {

    /**
     * Bean으로 올리는 경우, 복호화 암호Key가 노출되어서 보안 우려가 있음.
     * 이걸 따로 처리해주지 않으면, boot 자체에서 기본적으로 jasyptStringEncryptor Bean을 생성해서 올려줌.
     * 암호Key는 환경변수 또는 VM옵션으로 처리.
     * -Djasypt.encryptor.password=
     */

//    @Bean("jasyptStringEncryptor")
//    public StandardPBEStringEncryptor jasyptConfigure() {
//        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//        SimplePBEConfig config = new SimplePBEConfig();
//        config.setAlgorithm("PBEWithMD5AndDES");
//        config.setPoolSize(1);
//        encryptor.setConfig(config);
//
//        return encryptor;
//    }
}
