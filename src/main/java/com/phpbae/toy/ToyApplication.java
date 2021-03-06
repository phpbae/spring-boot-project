package com.phpbae.toy;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableEncryptableProperties
@SpringBootApplication(exclude = {TransactionAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@EnableAspectJAutoProxy
public class ToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyApplication.class, args);
    }
}
