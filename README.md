# ud-springboot3-spring6
Jay's proj repo for Springboot 3 and Spring Framework 6 training (conducted by R.Karanam - udemy) (from latest). List below ARE NOT NOTES. They are topics covered as of latest. 

proj: restfulwebservices (dep: Spring Web, Spring Data JPA, H2 Database, SpringBoot DevTools | jdk17, mvn, springboot 3.2.2)
- setup for OPEN API/Swagger, generated API doc
- Added API Validation, @Valid, @Size, @Past; wrote custom ResponseEntity to handle invalid bean attributes (MethodArgumentNotValidException)
- implemented DELETE API (@DeleteMapping)
- implemented Custom exception handler, ErrorDetails - customize response body to display info on exception details
- implemented custom NotFoundException (RuntimeException), set @ResponseStatus
- modified POST api to return appropo resp status (201) along with Location; ResponseEntity, ServletUriComponentBuilder
- implemented POST API (@PostMapping): /users, updated dao
- wrote User @RestController, Bean, DAOService(@Component), implemented GET APIs: /users, /users/{id}
- wrote @RestController, get api (@RestController, @RequestMpping, @GetMapping), get api returning bean (JSON resp)

proj: todolist-webapp-demo (dep: Spring Web, SpringBoot DevTools | jdk17, mvn, springboot 3.2.2)
- migrated to MySQL/Docker from H2; modified dependencies, application.properties
- implemented all repo methods;
- implemented JpaRepository, autowired into controller; implemnted custom find method,
- mapped bean with H2 DB: @Entity, @Id, @GeneratedValue; used CURRENT_DATE(), prepopulated H2 DB via data.sql; spring.jpa.defer-datasource
- added Springboot data jpa and H@ DB dependencies; Updated SecurityConfiguration - SecurityFilterChain, HttpSecurity, authorizeHttpRequest();
- modified SpringSecurityConfiguration to add Users (UserDetails)
- Added SecurityContext for retrieval of session attrib (name)
- implemented spring-boot-starter-security; org.spring.security.core/crypto/provisioning APIs: User, UserDetails, BCryptPasswordEncoder, PasswordEncoder, InMemoryUserDetailsManager
- added jspf - navi, header, footer;
- added targetDate datepicker; bootstrap-datepicker; configured js component for targetDate
- added Update bean; shared bean details jsp with Add bean; added methods to service and controller to do update and, return bean by ID
- added Delete bean functionality via Id; used java predicate to evaluate bean id, removeIf(predicate)
- used @Size in Bean; BindingResult, @Valid, .hasErrors() in Controller; <form:errors>, cssClass="text-warning" in jsp 
- Added dependency spring-boot-starter-validation; added Spring Form Tag Library (form:form, form:input, etc.); wrote CommandBean/FormBackingObject
- created 'add todo'; used new bootstrap class values
- enabled bootstrap and jquery; added dep, modified jsp; class="container" | "table"
- used JSTL; added dependencies; c:forEach
- used @SessionAttributes; routed from jsp
- Wrote 'Todo' bean, @Service, @Controller, jsp; used map.addAttribute()
- Login page; used ModelMap, DispatcherServlet
- Logging(slf4j); Logger, LoggerFactory, getLogger(), .info(), .debug()
- capture Query Params (@RequestParam); used org.springframework.ui.ModelMap; used el in jsp to output model
- added jsp; controller, view resolvers in app.prop; tomcat-embed-jasper dependency
- used @Controller, @ResponseBody

proj: jpa-hibernate-demo (dep: Spring Web, Spring Data JDBC, Spring Data JPA, H2 Databse | jdk 17, mvn, springboot 3.2.2)
- created new demo proj for JPA, Hibernate concepts (Spring Web, Spring Data JDBC, Spring Data JPA, H2 Database)
- added static jdbc url via spring.datasource.url for H2 DB; added schema.sql; created schema and table
- created @Repository component w/ JdbcTemplate dependency (@Autowired), update(); created CommandLineRunner component with repository dependency to execute repo method inside run()
- modified @Repository SQL to accept parameters; created pojo; added INSERT (the pojo) and DELETE SQL
- added SELECT SQL to return pojo; used queryForObject() from JdbcTemplate and BeanPropertyRowMapper inside @Repository method
- used JPA; used @Entity, @Id, @Column on javabean; create new @Repository (also @Transactional) with dependency on EntityManager (@PersistenceContext); used em.find(), em.merge, em.remove()
- used SpringDataJPA - org.springframework.data.jpa.repository.JpaRepository; CRUD functionality automatically defined and autowired into instance
- custom findby() in JpaRepository interface; JpaRepository.count() 

proj: springboot-demo 
- created new project : springboot HWorld
- create SpringBoot REST API; used @RestController, @RequestMapping, pojo (Landlord)
- created profiles to simulate different environments; set active profile(spring.profiles.active); set logging according to profile
- implemented configuration properties; defined ConfigurationPropertiesBean (@ConfigurationProperties); controller to test (config instance field is @Autowired)
- packaged via mvn clean install; console execution
- enabled Springboot Actuator

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





