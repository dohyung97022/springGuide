# springGuide

### 이 Repository는

스프링을 공부하고 정리하고자 남겼습니다.   
기억이 애매하면 ctrl+f 하기 위해 남깁니다.

### Studied from

[인프런 김영한님 완전 정복 로드맵](https://www.inflearn.com/roadmaps/149)   
[스파르타 웹개발의 봄, Spring](https://spartacodingclub.kr/)

* # A
* # B
* # C
* # D
  <details>
  <summary>
  ddl-auto : 데이터베이스 스키마 생성 방침
  </summary>
  <br>
  
  application properties 에 `spring.jpa.hibernate.ddl-auto=` 형태로 존재한다.   
  
  create : 기존 태이블 삭제 후 다시 생성   
  create-drop : create 와 같지만 종료 시점에 삭제   
  update : 변경분만 반영   
  validate : 엔티티와 테이블이 매핑되었는지 확인   
  none : 사용안함   
  
  개발 초기 단계 : create, update    
  테스트 서버 : update, validate      
  운영 서버 : validate, none   
  </details>
* # E
  <details><summary>
  @Entity 에서는 setter 를 열지 말자
  </summary>
  <br>

  @Setter 가 열려 있어 너무 많은 변경 포인트가 있다면 유지보수가 어렵다   
  @Setter 는 그 의도를 파악하기 어렵다.    
  또한 객체의 일관성을 보장하기 어렵다.     
  Constructor, builder 를 최대한 활용하자.    
  가령 사용하더라도 정해진 비즈니스 로직을 짜서 규정하고 사용하자.
  </details>
  <br>
  
  <details>
  <summary>
  @Embeddable, @Embedded 를 활용하자
  </summary>
  <br>

  Entity 내부 Class 를 관계형 연결(일 대 다, 일 대 일...etc) 없이 나타낼 수 있다         
  Java 내에서만 적용된다   
  @Embeddable   
  
  ```java
  @Embeddable
  @Getter
  public class Address {
  private  String city;
  private String street;
  private String zipcode;
  }
  ``` 
  
  @Embedded
  ```java
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Getter
  @Entity
  public class Member {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "member_id")
      private Long id;
  
      @Column
      private String name;
  
      @Embedded
      private Address address;
  }
  ``` 
  
  Java 내에서만 적용되며 database 에 관계형으로 정의되지 않는다.   
  ![](../../../../../../images/@embedded.PNG)
  </details>
  <br>

  <details>
  <summary>
  @Enumerated(EnumType.STRING) 로 enum column 을 만들자
  </summary>
  <br>

  반드시 EnumType.STRING 을 사용하자    
  Integer 는 enum 이 삭제/변경되었을 때 같은 숫자가 중복되어 사용된다   
  
  ```java
  enum OrderStatus {
    ORDER, CANCEL;
  }
  ```  
  
  ```java
  @Getter
  @Entity
  public class Order {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
    
      @Enumerated(EnumType.STRING)
      private OrderStatus status;
  }
  ```
  </details>

* # F
  <details>
  <summary>
  Fetchtype 은 반드시 Lazy 로 지정한다
  </summary>
  <br>

  모든 연관된 테이블들이 딸려 나와서 n+1 폭탄을 맞고 싶지 않다면 lazy 로 사용하자      
  쿼리는 본인이 customize 하여 최적화 할 수 있게끔 만들어야 한다   
  
  fetchtype 을 지정하지 않은 경우   
  @ManyToOne 의 경우 FetchType 은 eager 이며   
  @OneToMany 의 경우 FetchType 은 lazy 이다.   
  
  @ManyToOne 에 주의하자.    
  
  lazy 가 설정된 이후 getter 를 사용하면 query 가 나간다.   
  
  n+1 문제는 여기에도 정리되어 있으니 확인하자.
  </details>
  <br>
  
  <details>
  <summary>
  Foreign key 를 사용한다면 반드시 name 을 지정한다
  </summary>
  <br>

  연관 관계 중 foreign key 가 생성된다면 spring 에서 임의로 이름을 만든다      
  임의로 지정된 이름은 JJ9J21D82 같은 gibberish 이기 때문에 user_account_fk 처럼 정의하자   
  
  ```java
  @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "user_account_fk"))
  ``` 
  
  반드시 fk를 사용하지 않아도 된다.   
  조금 더 유연한 시스템을 운영하고 싶다면 fk를 사용하지 않고 연결관계를 정의만 하는 것 또한 하나의 방법이다.   
  </details>
* # G
* # H
  <details>
  <summary>
  H2 : 로컬에서 간편하게 연결하는 임시 데이터베이스

  </summary>
  <br>

    * 설치   
      우선 spring initializr 에서 h2 가 추가됬는지 확인한다.   
      [h2 설치 링크](https://www.h2database.com/html/main.html)   
      설치된 경로에서 \H2\bin 을 들어간다.   
      h2.sh 또는 bat 을 실행한다.   
      localhost:8082 를 들어간다.   
      JDBC url 을 jdbc:h2:file:~/testDB 로 바꾼다.   
      :mem 의 경우 메모리 :file 의 경우 파일 저장이다.   
      ~/의 경로는 user 에서 시작된다.   
      저장된 파일 경로 예시 : C:\Users\doe\testDB.mv.db   
      jdbc:h2:file:D:\Program Files (x86)\H2\saved\testDB 로 특정 경로를 지정해도 된다.         
      <br>

    * 연결  
      스프링과 h2의 연결은 application.properties 에서
      ```
      spring.datasource.url=jdbc:h2:tcp://localhost/~/testDB
      spring.datasource.driverClassName=org.h2.Driver
      spring.datasource.username=sa
      spring.datasource.password=
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
      ``` 
      testDB는 사용자가 지정한 명칭으로 바꿔도 된다.      
      그 이외에 추가하면 좋은 properties 도 잊지 말자
      ```
      # 테이블이 없다면 자동으로 생성한다.
      spring.jpa.hibernate.ddl-auto=create
      # sql 을 로깅으로 표시한다.
      # spring.jpa.show-sql=true
      logging.level.org.hibernate.sql = debug
      ``` 
  </details>
* # I
* # J
* # K
* # L
* # M
* # N
  <details>
  <summary>
  n+1 문제 : SELECT * query 이후 나온 n 만큼 SELECT 하는 쿼리 폭탄
  </summary>
  <br>

  ![](images/n+1.PNG)
  이런 쿼리문이 보인다면 n + 1 문제입니다.   
  Spring 에서 n + 1 이 생긴다면 fetchtype.eager 를 하였는지 확인합시다.   
  For each 문에서도 n + 1 이 발생할 수 있습니다.   
  
  해결법은 크게 2가지 있습니다.   
  
  Join fetch
  ```java
  @Query("select a from books a join fetch a.users")
  List<books> findAllJoinFetchUsers();
  ```
  2중 join fetch   
  ```java
  @Query("select a from books a join fetch a.users u join fetch u.account")
  List<books> findAllJoinFetchUsersWithAccount();
  ``` 
  join fetch 는 inner join 입니다.   
  <br>
  
  Entity graph   
  ```java
  @EntityGraph(attributePaths = "users")
  @Query("select a from book a")
  List<Academy> findAllEntityGraphUsers();
  ``` 
  2중 entity graph
  ```java
  @EntityGraph(attributePaths = {"users", "users.account"})
  @Query("select a from book a")
  List<Academy> findAllEntityGraphUsersWithAccount();
  ``` 
  entity graph 는 left outer join 입니다.   
  
  [join 을 밴다이어그램으로 설명](https://joins.spathon.com/)   
  
  </details>
* # O
* # P
  <details>
  <summary>
  Persistance.xml : 설정용 파일
  </summary>
  <br>
  application.properties 의 구 버전이다.   
  
  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <persistence version="2.2"
  xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
  <persistence-unit name="hello">
  <properties>
  <!-- 필수 속성 -->
  <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
  <property name="javax.persistence.jdbc.user" value="sa"/>
  <property name="javax.persistence.jdbc.password" value=""/>
  <property name="javax.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/testDB"/>
  <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
  
              <!-- 옵션 -->
              <property name="hibernate.show_sql" value="true"/>
              <property name="hibernate.format_sql" value="true"/>
              <property name="hibernate.use_sql_comments" value="true"/>
              <!--<property name="hibernate.hbm2ddl.auto" value="create" />-->
          </properties>
      </persistence-unit>
  </persistence>
  ``` 
  
  `<persistence-unit name="hello">` 에서 name 을 지정해 주면   
  ```java
  Persistence.createEntityManagerFactory("hello");   
  EntityManager em = emf.createEntityManager();
  ```
  으로 연결된다.   
  
  `<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>`의 dialect 는 방언인데 
  다양한 데이터베이스를 사투리로서 이해하고 있다. `H2Dialect` 로 주어진 사투리를 표준말로 변경하겠다는 의미이다.

  필요에 따라 추가적으로 옵션을 넣을 수 있다.
  </details>
* # Q
* # R
* # S
  <details>
  <summary>
  spring-boot-devtools : html 의 캐싱이나 .class 변경을 감지해서 개발을 편리하게 하는 도구
  </summary>
  <br>

    * 설치방법   
      <br>
      gradle 의 경우   
      `compileOnly ('org.springframework.boot:spring-boot-devtools')`   
      <br>
      maven 경우
      ```
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-devtools</artifactId>
          <optional>true</optional>
      </dependency>
      ```

      compileOnly 의 이유   
      [링크](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)      
      <br>
    * 활용   
      파일이 변경된 경우   
      ctrl+shift+F9 (build->recompile)    
      을 눌려 프로젝트에 바로 적용한다.   
      <br>
      .html 의 경우 캐쉬 없이 바로 적용되고   
      .class 의 경우 프로젝트가 rerun 된다.

  </details>
* # T
  <details>
  <summary>
  thymeleaf : ssr과 라우팅을 편리하게 하는 하는 모듈
  </summary>
  <br>

    * 보내고 받는 법
      ```java
      @RequiredArgsConstructor
      @Controller
      public class MemberController {
      @GetMapping("/hello")
      public String hello(Model model){
          model.addAttribute("name","김도형");
          return "hello";
          }
      }
      ```   
      보면 `@RestController` 가 아니라 `@Controller` 를 사용한다는 것을 알 수 있다.    
      rest 는 rest api, 그냥 controller 는 페이지의 전환을 위해서 주로 사용된다.   
      return "hello" 는 resources/templates/hello.html 을 반환한다.   
      `model.addAttribute("name","김도형");`로 변수를 전달하면   
      hello.html 에서   
      `<p th:text="'안녕하세요~' + ${data} + '님'" ></p>`   
      처럼 사용할 수 있다.   
      <br>
    * 문법   
      [여기](https://eblo.tistory.com/55) 를 참조

  </details>
  <br>

  <details>
  <summary>
  데이터베이스 적용을 원치 않는 변수는 @Transient로 만들자
  
  </summary>
  <br>
  
  드랍다운 내용
  </details>
  
* # U
* # V
* # W
* # X
* # Y
* # Z

* # ㄱ
* # ㄴ
* # ㄷ
  <details>
  <summary>
  다 대 다 관계는 절대 사용하지 말자
  </summary>
  <br>
  
  many to many 사이의 테이블은 entity 로 정의되지 않는다.      
  Relation 으로 자동 생성되어서 변경에 용의하지 않다.      
  </details>
* # ㄹ
* # ㅁ
* # ㅂ
* # ㅅ
* # ㅇ
  <details>
  <summary>
  연관관계 편의 메소드를 사용하자
  </summary>
  <br>

  관계가 있는 entity 를 저장할 때 양측의 객체를 변경해야 한다.   
  이를 method 로 묶자.
  
  ```java
    // many to one 관계 (Child to Parent)
    public void setParent(Parent parent){
        this.parent = parent;
        parent.getChildren().add(this);
    }

    // one to many 관계 (Parent to Child)
    public void addChild(Child child){
        children.add(child);
        child.setParent(this);
    }
  
    // one to one 관계 (Husband to Wife)
    public void setWife(Wife wife){
        this.wife = wife;
        wife.setHusband(this);
    }
    // many to many 는 사용하지 말자
  ``` 
  
  주의할 점이 있는데   
  연관 관계 메소드가 정의된 곳을 규정해야 한다.   
  Child 에 정의될지 Parent 에 정의될지 일관성이 필요하다.   
  예를 들어 foreign key 가 단일 방향으로 설계되었다면   
  Foreign key 가 규정된 entity 에 정의한다던지 원칙을 정해야 한다.   
  </details>
* # ㅈ
* # ㅊ
* # ㅋ
* # ㅌ
* # ㅍ
* # ㅎ

<details>
<summary>드랍다운</summary>
<br>

드랍다운 내용
</details>