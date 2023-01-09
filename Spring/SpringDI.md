## Bean

- JavaBeans - 재사용 가능한 컴포넌트, 상태(iv), getter&setter, no-args constructor

- Spring Bean - POJO Plain Old Java Object. 단순, 독립적, Spring container가 관리

---

## ApplicationContext

- Bean - Spring Container가 관리하는 객체

- Spring container = Bean 저장소, Bean을 저장, 관리(생성, 소멸, 연결)
  1. BeanFactory - Bean을 생성, 연결 등의 기본 기능을 정의
  2. ApplicationContext - BeanFactory를 확장해서 여러 기능을 추가 정의

다양한 종류의 ApplicationContext구현체를 제공

||XML|Java Config|
|:---:|:---:|:---:|
|non-Web|GenericXml**ApplicationContext**|AnnotationConfig**ApplicationContext**|
|Web|Xml**WebApplicationContext**|AnnotationConfig**WebApplicationContext**|

---

## IoC, DI

- 제어의 역전 IoC - 제어의 흐름을 전통적인 방식과 다르게 뒤바꾸는 것

- 의존성 주입 DI - 사용할 객체를 외부에서 주입받는 것

[전통적인 방식] 사용자 코드가 Framework 코드를 호출

```java
Car car = new Car();
car.turboDrive();

void turboDrive() {
    engine - new TurboEngine();
    engine.start();
}
```

[IoC] Framework 코드가 사용자 코드를 호출

```java
Car car = new Car();
car.drive(new SuperEngine());

void drive(Engine engine) {
    engine.start();
    ...
}
```

IoC(Inversion of Control)

DI(Dependency Injection)

*library는 단순히 기능만 제공하지만, framework은 기능뿐만 아니라 프로그래밍 패턴과 형식까지 제공

---

### @Autowired

- Spring container에서 **타입으로 빈을 검색**해서 참조 변수에 자동 주입(DI)

- 검색된 빈이 **n개**이면, 그 중에 참조변수와 **이름이 일치**하는 것을 주입.

### @Resource

- Spring container에서 **이름으로 빈을 검색**해서 참조 변수에 자동 주입(DI)

- 일치하는 이름의 빈이 없으면, 예외 발생

### @Component

- \<component-scan\>로 @Component가 클래스를 자동 검색해서 빈으로 등록
- @Controller, @Service, @Repository, @ControllerAdvice의 메타 애너테이션

### @Value, @PropertySource

---