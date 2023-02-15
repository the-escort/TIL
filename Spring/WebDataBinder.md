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