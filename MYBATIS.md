# MYBATIS

### Studied from

[mybatis 강좌1](https://www.youtube.com/watch?v=4YOk7oLGTKI)   
[mybatis 공식 문서](https://mybatis.org/mybatis-3/sqlmap-xml.html)   

### TODO
[여기에서 .xml 설정들 추가하기](https://mybatis.org/mybatis-3/sqlmap-xml.html)   
.xml 조건문들 찾아보고 추가하기
* # A
* # B
* # C
* # D
* # E
* # F
* # G
* # H
* # I
* # J
* # K
* # L
* # M
  <details>
  <summary>
  @Mapper
  </summary>
  <br>
  
  ```java
  @Mapper
  public interface UserMapper{
    @Select("SELECT * FROM USER")
    List<User> getAll();    
  }
  ```
  
  mybatis 가 매핑을 해나아가기 위한 interface 를 지정하는 곳에 `@Mapper` 이라는 annotation 을 사용합니다.   
  
  <br>
  sql 을 정의하는 방법으로는   
  
  `@Mapper` 안에 들어가는 `@Select`, `@Insert`, `@Update`, `@Delete` 는 sql 의 전치사를 따릅니다.
  
  이 방식 외에도 `.xml` 파일을 통해 sql 문을 mapping 할 수도 있습니다.   
  자세한 정보는 `.xml` 을 통한 mapping 에서 확인하세요.   
  
  `@Options(userGenereatedKeys=true, keyProperty="키명")` 을 통해   
  `@Insert`, `@Update`, `@Delete` 된 값들을 int 가 아닌 해당 입력/삭제값 자체로 return 할 수 있습니다.    
  자세한 정보는 `@Options` 에서 확인하세요.
  
  <br>
  mapping 되는 클래스를 정의하는 방법으로는   
  
  `@Results` 를 통해 컬럼명이 실제 클래스의 parameter 명과 다르다면 이를 연결시킬 수 있습니다.   
  `@ResultMap`을 통해 이미 정의된 `@Results` 를 재사용할 수도 있습니다.   
  
  자세한 정보는 `@Results` 에서 확인하세요.   

  </details>
  <br>
* # N
* # O
* # P
* # Q
* # R
* # S
  <details>
  <summary>
  selectKey, insert 이후에 id 를 받는 방법
  </summary>
  <br>
  
  db 와 접근하는 코드를 작성하시다 보면 저장된 요소의 id 값에 접근하셔야 할 때가 많습니다.   
  
  SQL 구문을 통해 INSERT 할 때 그 id 값을 지정하거나, 사용할 때 활용됩니다.   
  
  |요소|의미|
  |:---:|:---:|
  |keyProperty|selectKey 구문의 결과가 들어갈 오브젝트의 변수명|
  |keyColumn|리턴되는 결과의 컬럼명|
  |resultType|결과의 타입, 생략 가능|
  |order|BEFORE / AFTER selectKey 가 실행되는 위치|
  <br>

  가장 많이 쓰이는 예시로는 INSERT 이후 id 값을 가져오는 방법입니다.    

  ```sql
  <insert id="add" userGeneratedKeys="true" keyProperty="userId" keyColumn="user_id" parameterType="...">
    INSERT INTO schema.user (name, age)
    VALUES (name, age)
    
    <selectKey keyProperty="userId" order="AFTER">
        SELECT LAST_INSERT_ID()
    </selectKey>
  </insert>
  ```
  <br>
  
  이렇게 작성하시면 `add()` 가 사용될 때 들어가는 parameterType 의 keyProperty 값이 id 로 지정됩니다.

  ```java
  User user = new User("김도형", 25);
  userDAO.add(user);
  user.getId(); // 641 과 같이 id 값이 지정되어 나옵니다. 
  ```
  <br>
  
  다만 이 경우 db 가 LAST_INSERT_ID() 를 지원해야 합니다.   
  
  <del>  ORACLE 은 너무 비싸서 어짜피 다들 MYSQL 쓰잖아요? ㅋㅋㅋㅋ </del>
  </details>
  <br>

* # T
* # U
* # V
* # W
* # X
  <details>
  <summary>
  .xml 을 통한 mapping
  </summary>
  <br>
  
  ### 설정
  사용을 위해 src/main/java/resources/mappers 안에 파일을 만들어 사용합니다.   
  직접 mybatis.config 안에 파일 위치를 추가하는 방법이 존재하지만   
  mapper.xml 을 추가할 때마다 손을 봐줘야 해서 비추입니다.   
  
  </details>
  <br>
* # Y
* # Z
