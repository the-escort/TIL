## WebDataBinder

### PropertyEditor

- 양방향 타입 변환(String -> 타입, 타입 -> String)
- 특정 타입이나 이름의 필드에 적용 가능

    - 디폴트 PropertyEditor - 스프링이 기본적으로 제공
    - 커스텀 PropertyEditor - 사용자가 직접 구현. PropertyEditorSupport를 상속하면 편리

    모든 컨트롤러 내에서의 변환 - WebBindingInitializer를 구현후 등록
    
    특정 컨트롤러 내에서의 변환 - 컨트롤러에 @InitBinder가 붙은 메서드를 작성

    ```java
    @InitBinder
    public void toDate (WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat ("yyyy/MM/dd");
        //스프링이 제공하는 CustomDateEditor를 이용해서 변환. String -> Date
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    ```

### Converter

- 단방향 타입 변환(타입A -> 타입B)
- PropertyEditor의 단점을 개선(stateful - stateless)

    ```java
    public class StringToStringArrayConverter implements Converter<String, String[]> {
        @Override
        public String[] convert(String source) {
            return source.split("#"); // String -> String[]
        }
    }
    ```

- ConversionService - 타입 변환 서비스를 제공. 여러 Converter를 등록 가능

    WebDataBinder에 DefaultFormattingConversionService이 기본 등록 

    모든 컨트롤러 내에서의 변환- ConfigurableWebBindingInitializer를 설정해서 사용 

    특정 컨트롤러 내에서의 변환 - 컨트롤러에 @InitBinder가 붙은 메서드를 작성

### Formatter

- 양방향 타입 변환(String -> 타입, 타입 - String)
- 바인딩할 필드에 적용 - @NumberFormat, @DateTimeFormat

---

### Validator

- 객체를 검증하기 위한 인터페이스. 객체 검증기(validator)구현에 사용

```java
public interface Validator {
    // 이 검증기로 검증가능한 객체인지 알려주는 메서드
    boolean supports(Class<?> clazz);
    // 객체를 검증하는 메서드 - target : 검증할 객체, errors : 검증시 발생한 에러저장소
    void validate(@Nullable Object target, Errors errors);
}
```

### Validator를 이용한 검증

- 자동

```java
@PostMappingg("/register/add")
public String save(Model model, User user, BindingResult result) {

    UserValidator userValidator = new UserValidator();
    userValidator.validate(user, result); // validator로 검증

    if (result.hasErrors()) { // 에러가 있으면,
        return "registerForm";
    }
}
```

- 수동

```java
@InitBinder
public void toDate (WebDataBinder binder) {
    SimpleDateFormat df = new SimpleDateFormat("уууу/MM/dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

    binder.setValidator(new UserValidator()); // validator를 WebDataBinder에 등록

    List<Validator> validators = binder.getValidators();
    System.out.println("validators = " + validators);
}

@PostMapping("/register/add") // 신규 회원 등록.
public String save(Model m, @Valid User user, BindingResult result) {

    if (result.hasErrors()) { // 에러가 있으면,
        return "registerForm";
    }
}
```

### 글로벌 Validator

- 하나의 Validator로 여러 객체를 검증할 때, 글로벌 Validator로 등록

```
<annotation-driven validator="globalValidator"/>
<beans:bean id="globalValidator" class="com.fastcampus.ch2.GlobalValidator"/>
```

- 글로벌 Validator와 로컬 Validator를 동시에 적용하는 방법

```java
@InitBinder
public void toDate(WebDataBinder binder) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));

// binder.setValidator(new UserValidator()); // validator를 WebDataBinder에 등록
    binder.addValidators(new UserValidator()); // validator를 WebDataBinder에 등록
}
```

### MessageSource

- 다양한 리소스에서 메시지를 읽기 위한 인터페이스

```java
public interface MessageSource {
    String getMessage(String code, Object[] args, String defaultMessage, Locale locale);
    String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException;
    String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException;
}
```

---