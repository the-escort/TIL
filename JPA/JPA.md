## JPA

### JPA?

- Java Persistence API
- 자바 진영의 ORM 기술 표준

### ORM?

- Object-relational mapping(객체 관계 매핑)
- 객체는 객체대로 설계
- 관계형 데이터베이슨느 관계형 데이터베이스대로 설계
- ORM 프레임워크가 중간에서 매핑
- 대중적인 언어에는 대부분 ORM 기술이 존재

---

## 영속성 관리 - 내부 동작 방식

### 영속성 컨텍스트

- JPA를 이해하는데 가장 중요한 용어
- "엔티티를 영구 저장하는 환경"이라는 뜻
- **EntityManager.persist(entity);**

### 엔티티 매니저? 영속성 컨텍스트?

- 영속성 컨텍스트는 논리적인 개념
- 눈에 보이지 않는다.
- 엔티티 매니저를 통해서 영속성 컨텍스트에 접근

### 엔티티의 생명주기

- **비영속(new/transient)**

    영속성 컨텍스트와 전혀 관계가 없는 **새로운** 상태

- **영속(managed)**

    영속성 컨테스트에 **관리**되는 상태

- **준영속(detached)**

    영속성 컨텍스트에 저장되었다가 **분리**된 상태

- **삭제(removed)**

    **삭제**된 상태

### 영속 엔티티의 동일성 보장

```java
Member a = em.fine(Member.class, "member1");
Member b = em.fine(Member.class, "member1");

System.out.pringln(a == b); // 동일성 비교 true
```

1차 캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 트랜잭션 격리 수준을 데이터베이스가 아닌 애플리케이션 차원에서 제공

### 엔티티 등록

- 트랜잭션을 지원하는 쓰기 지연

    ```java
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    // 엔티티 매니저는 데이터 변경시 트랙잭션을 시작해야 한다.
    transaction.begin(); // [트랜잭션] 시작

    em.persist(memberA);
    em.persist(memberB);
    // 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.

    // 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
    transaction.commit(); // [트랜잭션] 커밋
    ```

### 엔티티 수정

- 변경 감지(Dirty Checking)

    ```java
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    // 엔티티 매니저는 데이터 변경시 트랙잭션을 시작해야 한다.
    transaction.begin(); // [트랜잭션] 시작

    // 영속 엔티티 조회
    Member memberA = em.find(Member.class, "memberA");

    // 영속 엔티티 데이터 수정
    memberA.setUsername("hi");
    memberA.setAge(10);

    // em.update(member) ?

    transaction.commit(); // [트랜잭션] 커밋
    ```

1. flush()
2. 엔티티와 스냅샷 비교

    1차 캐시
    |@Id|Entitiy|스냅샷|
    |:---:|:---:|:---:|
    |"memberA"|memberA|memberA<br>스냅샷|
    |"memberB"|memberB|memberB<br>스냅샷|
3. UPDATE SQL 생성
4. flush
5. commit

### 플러시

- 영속성 컨텍스트의 변경내용을 데이터베이스에 반영

### 플러시 발생

- 변경 감지
- 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
- 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)

### 플러시는

- 영속성 컨텍스트를 비우지 않음
- 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
- 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨

### 준영속 상태

- 영속 -> 준영속
- 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
- 영속성 컨텍스트가 제공하는 기능을 사용 못함

### 준영속 상태로 만드는 방법

- em.detach(entity)

    특정 엔티티만 준영속 상태로 전환

- em.clear()

    영속성 컨텍스트를 완전히 초기화

- em.close()

    영속성 컨텍스트를 종료

---

## 엔티티 매핑

### 객체와 테이블 매핑

- @Entitiy
  - @Entitiy가 붙은 클래스는 JPA가 관리, 엔티티라 한다.
  - JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수
  - 주의
    - **기본 생성자 필수**(파라미터가 없는 public 또는 protected 생성자)
    - final 클래스, enun, interface, inner 클래스 사용 X
    - 저장할 필드에 final 사용 X

- @Table
  - @Table은 엔티티와 매핑할 테이블 지정

### 필드와 컬럼 매핑

- @Column

    |속성|설명|기본값|
    |:---:|:---|:---|
    |name|필드와 매핑할 테이블의 컬럼 이름|객체의 필드 이름|
    |insertable<br>updatable|등록, 변경 가능 여부|TRUE|
    |nullable(DDL)|null값의 허용 여부를 설정한다. false로 설정하면 DDL 생성 시에 not null 제약조건이 붙는다.||
    |length(DDL)|문자 길이 제약조건, String 타입에만 사용한다.|255|

- @Enumerated
  - 자바 enum 타입을 매핑할 때 사용
  - 주의! ORDINAL 사용 X

    |속성|설명|기본값|
    |:---:|:---|:---|
    |value|- EnumType.ORDINAL: enum 순서를 데이터베이스에 저장<br>- EnumType.STRING: enum 이름을 데이터베이스에 저장|EnumType.ORDINAL|

- @Temporal
  - 날짜 타입(java.util.Date, java.util.Calendar)을 매핑할 때 사용
  - 참고: LocalDate, LocalDateTime을 사용할 때는 생략 가능(최신 하이버네이트 지원)

- @Lob
  - 데이터베이스 BLOB, CLOB 타입과 매핑
    - @Lob에는 지정할 수 있는 속성이 없다.
    - 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑

### 기본 키 매핑

```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
```

- IDENTITY 전략
  - 기본 키 생성을 데이터베이스에 위임
  - 주로 MySQL, PostgreSQL, SQL Server, DB2에서 사용

    (예: MySQL의 AUTO_ INCREMENT)

  - JPA는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행
  - AUTO_ INCREMENT는 데이터베이스에 INSERT SQL을 실행 한 이후에 ID 값을 알 수 있음
  - IDENTITY 전략은 em.persist() 시점에 즉시 INSERT SQL 실행하고 DB에서 식별자를 조회

    ```java
    @Entitiy
    public class Member {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    }
    ```

- SEQUENCE 전략
  - 데이터베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트(예: 오라클 시퀀스)
  - 오라클, PostgreSQL, DB2, H2 데이터베이스에서 사용

    ```java
    @Entity
    @SequenceGenerator(
        name = “MEMBER_SEQ_GENERATOR",
        sequenceName = “MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)

    public class Member {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
        private Long id;
    ```

---

## 연관관계 매핑 기초

- 객체를 테이블에 맞추어 데이터 중심으로 모델링하면, 협력 관계를 만들 수 없다.
  - **테이블은 외래 키로 조인**을 사용해서 연관된 테이블을 찾는다.
  - **객체는 참조**를 사용해서 연관된 객체를 찾는다.
  - 테이블과 객체 사이에는 이런 큰 간격이 있다.

### 단방향 연관관계

- 객체의 참조와 테이블의 외래 키를 매핑

    ```java
    @Entity
    public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

    // @Column(name = "TEAM_ID")
    // private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    ...
    ```

- 연관관계 저장

    ```java
    // 팀 저장
    Team team = new Team();
    team.setName("TeamA");
    em.persist(team);

    // 회원 저장
    Member member = new Member();
    member.setName("member1");
    member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
    em.persist(member);
    ```

- 참조로 연관관계 조회 - 객체 그래프 탐색

    ```java
    // 조회
    Member findMember = em.find(Member.class, member.getId());

    // 참조를 사용해서 연관관계 조회
    Team findTeam = findMember.getTeam();
    ```

- 연관관계 수정

    ```java
    // 새로운 팀B
    Team teamB = new Team();
    teamB.setName("TeamB");
    em.persist(teamB);

    // 회원1에 새로운 팀B 설정
    member.setTeam(teamB); 
    ```

