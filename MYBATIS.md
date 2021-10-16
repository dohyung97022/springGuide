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
  <details>
  <summary>
  DTO
  </summary>
  <br>
  
  data-transfer-object    
  
  데이터가 지속적으로 변경되며 전송될 경우 사용하는 클래스입니다.   
  
  데이터의 값들이 코드가 진행되면서 변경되며 조작되어야 할 때 사용합니다.   
  
  `@Getter`, `@Setter` 를 포함시켜 코드가 진행되는 중 setter 를 통해 변경시킵니다.    

  ```java
  @Getter
  @Setter
  public class TravelerDTO {
    private String name;
    private Integer age;
  }
  
  public class Travel {
    public void travelForYear(TravelerDTO travelerDTO){
        travelerDTO.setAge(travelerDTO.getAge() + 1);
    } 
  }
  ```
  
  @Setter 의 추가는 persistance 안에 들어가서 ORM 된 클래스에만 없어야 하는 것입니다.   
  
  ORM 된 이후에 변경이 되면 db 에도 변경되기에 혼선이 생기는 것을 방지하기 위해 orm 클래스의 @Setter 를 방지하는 것입니다.   
  </details>
  <br>
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
