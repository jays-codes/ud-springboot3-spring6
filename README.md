# ud-springboot3-spring6
Jay's proj repo for Springboot 3 and Spring Framework 6 training (conducted by R.Karanam - udemy) (from latest). List below ARE NOT NOTES. They are topics covered as of latest. 

pre-built proj: 02-rest-api-mysql
- setup MySQL in Amazon RDS, uploaded app to EBS
- SpringBoot REST API w/ MySQL DB on Docker
  
pre-built proj: hello-world-java (DOCKER demo)
- deployed SpringBoot HWorld to AWS Elastic BeanStalk (EBS)
- build docker image using mvn spring-boot plugin, spring-boot:build-image; used jdk 17
- enabled caching in Dockerfile to speed up build
- created Dockerfile; optimazed Dockerfile to run maven build (clean, package) as well as deploy
- used prebuilt project to demo Docker concepts

proj: spring-aop-demo (dep: <none> | jdk21, gradle, springboot 3.2.4)
- added spring-boot-starter-web; added gradle task and new run config
- created custom annotation to map to specific pointcut - @TrackTime
- created CommonPointcutConfig; used bean arg for pointcuts
- create PerformanceTrackingAspect; used @Around, ProceedingJoinPoint, proceed()
- @After, @AfterReturning / Object arg in Advice for results, @AfterThrowing, Exception arg in Advice
- setup @Service and @Repository components; implemented CommandLineRunner; created LoggingAspect, @Aspect, defined @Pointcut/execution point/JoinPoint, @Before
- created new demo proj for Spring AOP (SpringBoot 3.2.4, gradle, jdk 21

proj: spring-security-oauth-demo (dep: Spring Web, SpringBoot DevTools, Spring OAuth2 Client | jdk21, gradle, springboot 3.2.4)
- created OauthSecurityConfiguration; log on to springboot using google account; oauth2Login(); generated client id/secret from google cloud api
- created new demo proj for Spring Security - OAuth2 (SpringBoot 3.2.4, gradle, jdk 21, Spring Web, Spring OAuth2 client, SpringBoot DevTools

proj: spring-security-demo (dep: Spring Web, Spring Security | jdk21, gradle, springboot 3.2.3)
- explored Global & Method Authorization; @EnableMethodSecurity, @PreAuthorize, @PostAuthorize, hasRole @RolesAllowed, @Secured
- implemented JWT Authentication; create JWTSecurityConfiguration, JWTAuthenticationResource; uses Oauth2 resource server; JwtEncoder/Decoder; JwtClaimsSet; security.core.Authentication
- used BCryptPasswordEncoder to hash pwd in H2; .passwordEncode()
- moved credentials to H2 DB; added dataSource() to SecurityConfig; EmbeddedDatabaseBuilder, setType(), addScript(); modified userDetailsService to use dataSource arg, injected; JdbcUserDetailsManager
- User Credentials; in-memory; implemented UserDetailsService, UserDetails, InMemoryUserDetailsManager
- implemented CORS configuration, corsConfigurer(); local config, @CrossOrigin
- Disable CSRF; override default security filter chain; created custom Security configuration; .csrf()
- implemented demo for CSRF; api to retrieve csrf token (CsrfToken) from HttpServletRequest
- Form-based Authentication; implemented Basic Auth; added devtools dep
- created new demo proj for Spring Security (gradle, jdk 21, Spring Web, Spring Security)

proj: todolist-webapp-demo (dep: Spring Web, SpringBoot DevTools | jdk17, mvn, springboot 3.2.2)
- Mockito Annotations; @Mock, @ExtendWith, @InjectMocks; thenReturn() chain; Mockito.anyInt()
- created Mock for service; mock(), when(), thenReturn()
- implemented Mockito; dep: mockito-core; created stubs for Service
- implemented JWT Authentication
- implemented Basic Auth; new API (GET) to receive token generated from react
- setup basic auth; SecurityFilterChain; csrf.disable; sessionManagement(STATELESS); httpBasic(Customizer.withDefaults); authorizeHttpRequest()
- added REST API for updateTodo (PUT), createTodo(POST); @RequestBody
- implemented REST API for retrieveTodo(GET), deleteTodo(DELETE); ResponseEntity
- start converting app to REST API app to be called from react; implemented retrieveTodosByUser API
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

proj: restfulwebservices (dep: Spring Web, Spring Data JPA, H2 Database, SpringBoot DevTools | jdk17, mvn, springboot 3.2.2)
- prepared REST API to be called from react app; defined WebMvcConfigurer; @CrossOrigin
- added spring-boot-starter-security; spring.security.user.name/password to app.prop; SecuritySpringConfiguration @Configuration to define SecurityFilterChain (@Bean), HttpSecurity, authorizeHttpRequests(), httpBasic(), .csrf(), csrf.disable()
- moved from H2 DB to MySQL/Docker
- implemented APIs: GET getUserPost, POST save user post, GET getAllUserPosts
- Create 'Post' Entity to demo One-to-Many Entity relationship; @ManyToOne, @OneToMany, FetchType.LAZY, mappedBy
- modified API to connect to H2 via JpaRepository
- SpringBoot HAL Explorer; added dep: org.springframework.data:spring-data-rest-hal-explorer
- Customized REST API responses; Static/Dynamic Filtering - @JsonProperty; @JsonIgnore, @JsonIgnoreProperties; MappingJacksonValue, SimpleBeanPropertyFilter, FilterProvider, @JsonFilter; added Custom filtering method
- HATEOAS; added dependency: spring-boot-starter-hateoas; used EntityModel, WebMvcLinkBuilder, linkTo(), methodOn(), withRel()
- implemented versioning - Request Parameter, Custom Header, MediaType/Content Negotiation
- implemented vesioning - URI
- implemented i18n; messages.properties, MessageSource, getMessage(), Locale, getLocale()
- setup accept header for XML response
- setup for OPEN API/Swagger, generated API doc
- Added API Validation, @Valid, @Size, @Past; wrote custom ResponseEntity to handle invalid bean attributes (MethodArgumentNotValidException)
- implemented DELETE API (@DeleteMapping)
- implemented Custom exception handler, ErrorDetails - customize response body to display info on exception details
- implemented custom NotFoundException (RuntimeException), set @ResponseStatus
- modified POST api to return appropo resp status (201) along with Location; ResponseEntity, ServletUriComponentBuilder
- implemented POST API (@PostMapping): /users, updated dao
- wrote User @RestController, Bean, DAOService(@Component), implemented GET APIs: /users, /users/{id}
- wrote @RestController, get api (@RestController, @RequestMpping, @GetMapping), get api returning bean (JSON resp)

proj: jpa-hibernate-demo (dep: Spring Web, Spring Data JDBC, Spring Data JPA, H2 Databse | jdk 17, mvn, springboot 3.2.2)
- custom findby() in JpaRepository interface; JpaRepository.count() 
- used SpringDataJPA - org.springframework.data.jpa.repository.JpaRepository; CRUD functionality automatically defined and autowired into instance
- used JPA; used @Entity, @Id, @Column on javabean; create new @Repository (also @Transactional) with dependency on EntityManager (@PersistenceContext); used em.find(), em.merge, em.remove()
- added SELECT SQL to return pojo; used queryForObject() from JdbcTemplate and BeanPropertyRowMapper inside @Repository method
- modified @Repository SQL to accept parameters; created pojo; added INSERT (the pojo) and DELETE SQL
- created @Repository component w/ JdbcTemplate dependency (@Autowired), update(); created CommandLineRunner component with repository dependency to execute repo method inside run()
- added static jdbc url via spring.datasource.url for H2 DB; added schema.sql; created schema and table
- created new demo proj for JPA, Hibernate concepts (Spring Web, Spring Data JDBC, Spring Data JPA, H2 Database)

proj: springboot-demo 
- enabled Springboot Actuator
- packaged via mvn clean install; console execution
- implemented configuration properties; defined ConfigurationPropertiesBean (@ConfigurationProperties); controller to test (config instance field is @Autowired)
- created profiles to simulate different environments; set active profile(spring.profiles.active); set logging according to profile
- create SpringBoot REST API; used @RestController, @RequestMapping, pojo (Landlord)
- created new project : springboot HWorld

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





