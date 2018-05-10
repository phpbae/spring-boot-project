package com.phpbae.toy.jasypt;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath:application-test.properties")
public class JasyptTest {

    @Ignore
    @Test
    public void 암호화복호화Test() throws Exception {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("m2"); //암호화 Key 정보.
        encryptor.setAlgorithm("PBEWithMD5AndDES"); //암호화 알고리즘
        encryptor.setStringOutputType("base64");

        String encryptedText = encryptor.encrypt("test");    //암호화
        String plainText = encryptor.decrypt(encryptedText);  //복호화

        System.out.println("encryptedText:  " + encryptedText); //암호화된 값
        System.out.println("plainText:  " + plainText);         //복호화된 값
    }

}
