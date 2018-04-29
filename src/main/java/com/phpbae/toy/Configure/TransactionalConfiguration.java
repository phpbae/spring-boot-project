package com.phpbae.toy.Configure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionalConfiguration {

    @Autowired
    private ApplicationContext context;

    @Bean(name = "transactionManager")
    @ConditionalOnClass(DataSource.class)
    public PlatformTransactionManager setTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        //jpaTransactionManager.setDataSource((DataSource) context.getBean("dataSource"));
        return jpaTransactionManager;
    }

}
