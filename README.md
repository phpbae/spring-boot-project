# spring-boot-project
spring boot backend 프로젝트

- spring boot + JPA + RDS(MySQL)
- 실행 시키기 위해선, 복호화 Key 값 필요.

---

```
@SpringBootApplication 의 의미는
@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan

@Configuration : 현재 클래스가 Spring의 설정 클래스임을 알려주는 어노테이션
@EnableAutoConfiguration : Spring boot 클래스패스 세팅 및 다양한 Bean 추가 등을 시켜주는 어노테이션
@ComponetScan : 다른 컴포넌트, 서비스, 설정 등을 찾을 수 있게 도와주는 어노테이션

@EnableJpaRepositories 
basePackages 속성에 정의된 패키지 하위에서 Spring Data Repository 들을 스캔.

@EntityScan 
basePackages 속성에 정의된 패키지 하위에서 JPA 엔티티들(@Entity 어노테이션 설정된 도메인 클래스)을 스캔.

```