## AOP(Aspect Oriented Programming)

- 관점 지향 프로그래밍, 횡단 관심사(cross-cutting concerns)
- 부가 기능(advice)을 동적으로 추가해주는 기술
- 메서드의 시작 또는 끝에 자동으로 코드(advice)를 추가

|용어|설명|
|:---:|:---|
|target|advice가 추가될 객체|
|advice|target에 동적으로 추가될 부가 기능(코드)|
|join point|advice가 추가(join)될 대상(메서드)|
|pointcut|join point들을 정의한 패턴|
|proxy|target에 advice가 동적으로 추가되어 생성된 객체|
|weaving|target에 advice를 추가해서 proxy를 생성하는 것|

### Advice의 종류

- Advice의 설정은 XML과 애너테이션, 두 가지 방법으로 가능

|종류|애너테이션|설명|
|:---:|:---:|:---|
|around advice|@Around|메서드의 시작과 끝 부분에 추가되는 부가 기능|
|before advice|@Before|메서드의 시작 부분에 추가되는 부가 기능|
|after advice|@After|메서드의 끝 부분에 추가되는 부가 기능|
|after returning|@AfterReturning|예외가 발생하지 않았을 때, 실행되는 부가 기능|
|after throwing|@AfterThrowing|예외가 발생했을 때, 실행되는 부가 기능|

### pointcut expression

- advice가 추가될 메서드를 지정하기 위한 패턴

    execution(반환타입 패키지명. 클래스명.메서드명(매개변수 목록))

```java
@Around("execution(* com.escort.ch3.aop.*.*(..))")
```

---