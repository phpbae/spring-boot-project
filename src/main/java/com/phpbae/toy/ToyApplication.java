package com.phpbae.toy;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEncryptableProperties
@EnableJpaRepositories(basePackages = "com.phpbae.toy.Repository")
@EntityScan(basePackages = "com.phpbae.toy.Domain")
public class ToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyApplication.class, args);
    }
}
