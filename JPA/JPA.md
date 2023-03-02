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
    |"memberA"|memberA|> memberA<br>스냅샷|
    |"memberB"|memberB|memberB<br>스냅샷|
3. UPDATE SQL 생성
4. flush
5. commit

---