# ud-springboot3-spring6
Jay's proj repo for Springboot 3 and Spring Framework 6 training (conducted by R.Karanam - udemy)

proj: spring-framework-demo
- HWorld for:
  - tight coupling and loose coupling example
  - org.springframework.context.annotation.AnnotationConfigApplicationContext
  - org.springframework.context.annotation.Configuration
  - org.springframework.context.annotation.Bean
  - accessed bean via context.getBean()
- added beans using java record
- used custom name in bean via 'name' attribute
- access bean in getBean() via type
- parameterized bean passing in existing beans to create a new bean
- used: getBeanDefinitionNames(), getBeanDefinitionCount(), @Primary, @Qualifier
- used java streams, method reference
- used try-w/-resources to clear out warning on context; modified game package to manage Game on GameRunner in spring

proj: spring-framework-demo2
- merged Configuration with main entrypoint class
- Got Spring to create objects via:
  - @Component
  - @ComponentScan
- moved @Primary and @Qualifier to component
- moved all obj creation to Component; moved resolving of @Qualifier from @Bean to @Component; added @Qualifier to all grouped components with specific names
- demoed field DI via @Autowired
- demoed setter and constructor DI
- did exercise 07, inside jayslabs.springframeworkdemo.exercise
- demo for Lazy Initialization (@Lazy), Bean Scopes - @Scope; ConfigurableBeanFactory.SCOPE_PROTOTYPE
- demo for @PostConstruct, @PreDestroy (jakarta.annotation)
- demo for CDI; @Named, @Inject
- using Spring XML Configuration; ClassPathXmlApplicationContext; <beans>, <bean>, <context:component-scan>, <constructor-arg>
- replace @Component with more specific annotations: @Service, @Repository

proj: springboot-demo
- created new project : springboot HWorld
- create SpringBoot REST API; used @RestController, @RequestMapping, pojo (Landlord)
- created profiles to simulate different environments; set active profile(spring.profiles.active); set logging according to profile
- implemented configuration properties; defined ConfigurationPropertiesBean (@ConfigurationProperties); controller to test (config instance field is @Autowired)
- packaged via mvn clean install; console execution
- enabled Springboot Actuator

proj: jpa-hibernate-demo
- created new demo proj for JPA, Hibernate concepts (Spring Web, Spring Data JDBC, Spring Data JPA, H2 Database)
