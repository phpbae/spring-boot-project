# spring-boot-project
spring boot backend 프로젝트

- spring boot + JPA + RDS(MySQL)
- 실행 시키기 위해선, 복호화 Key 값 필요.
- EC2 인스턴스에 배포해서 해보기 위해, 제작한 프로젝트 이다.

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

@AutoConfigureAfter
@AutoConfigureBefore
어노테이션 이름과 동일하게 설정의 특정한 순서를 정할 수 있다. 
@AutoConfigureAfter 어노테이션 경우에는 설정한 클래스 다음에 선언한 해당 클래스를 설정하는 것이다. 
@AutoConfigureBefore 경우에는 그 반대.

```

---

```
Spring Boot는 애플리케이션을 테스트하기 위한 많은 기능을 제공합니다. 
Spring boot에서 테스트 모듈은 spring-boot-test와 spring-boot-test-autoconfigure가 존재.

spring-boot-test는 @SpringBootTest라는 어노테이션을 제공합니다. 
이 어노테이션을 사용하면 테스트에 사용할 ApplicationContext를 쉽게 생성하고 조작할 수 있습니다.

@SpringBootTest와 TestRestTemplate을 사용한다면 편리하게 웹 통합 테스트를 할 수 있다. 
TestRestTemplate은 이름에서 알 수 있듯이 RestTemplate의 테스트를 위한 버전입니다. 
@SpringBootTest에서 Web Environment 설정을 하였다면 TestRestTemplate은 그에 맞춰서 자동으로 설정되어 빈이 생성.

ApplicationContext 캐시
참고로 @SpringBootTest 기능으로 인해서 생성된 ApplicationContext를 캐시됩니다. 
만약에 @SpringBootTest의 설정이 동일하다면 동일한 ApplicationContext를 사용

```