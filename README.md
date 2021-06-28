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
* # E
* # F
* # G
* # H
  <details>
  <summary>
  H2   

  로컬에서 간편하게 연결하는 임시 데이터베이스이다.
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
* # O
* # P
* # Q
* # R
* # S
  <details>
  <summary>
  spring-boot-devtools      
  
  html 의 캐싱설정이나 .class 파일들의 변경을 감지해서 개발을 편리하게 하는 모듈
  </summary>
  <br>
  
  * 설치방법   
    build.gradle 파일의 dependencies 에   
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
  thymeleaf   
  
  ssr과 라우팅을 편리하게 하는 하는 모듈   
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
* # U
* # V
* # W
* # X
* # Y
* # Z

<details>
<summary>드랍다운</summary>
<br>

드랍다운 내용
</details>