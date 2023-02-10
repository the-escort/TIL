### JSON

**J**ava **S**cript **O**bject **N**otation - 자바스크립트 객체 표기법

```json
[{name : value}, {name : value}] // 객체 배열
```

```json
{key1 : {name : value, ...}, key2 : {name : value, ...}, ...} // Map
```

### stringify(), parse()

- JS객체를 서버로 전송하려면, 직렬화(문자열로 변화)가 필요
- 서버가 보낸 데이터(JSON 문자열)를 JS객체로 변환할 때, 역직렬화가 필요

JSON.stringify() - **객체**를 JSON **문자열**로 변환(직렬화, JS객체 -> 문자열)

JSON.parse() - JSON **문자열**을 **객체**로 변환(역직렬화, 문자열 -> JS객체)

```json
{name : "John", age : 30}

JSON.stringify()
---->
<----
JSON.parse()

'{"name" : "John", "age" : 30}'
```

### Ajax

- **A**synchronous **j**avascript **a**nd **X**ML - 요즘은 JSON을 주로 사용
- 비동기 통신으로 데이터를 주고 받기 위한 기술
- 웹페이지 전체(data+UI)가 아닌 일부(data)만 업테이트 가능

```java
@PostMapping("/send")
@ResponseBody
public Person test(@RequestBody Person p) {
    System.out.println("p = " + p);
    p.setName("ABC");
    p.setAge(p.getAge() + 10);

    return p;
}
```

### RestController

- @ResponseBody 대신, 클래스에 @RestController 사용 가능

```java
@RestController
public Person SimpleRestController {

   @PostMapping("/send")
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p; // 객체 반환
    }

}
```

### REST

- Roy Fielding이 제안한 웹서비스 디자인 아키텍쳐 접근 방식
- 프로토콜에 독립적이며, 주로 HTTP를 사용해서 구현
- 리소스 중심의 API 디자인 - HTTP메서드로 수행할 작업을 정의

## REST API

- **Re**presentational **s**tate **T**ransfer API- REST규약을 준수하는 API

- **REST** is a set of **architectural constraints**, not a protocol or a standard.

    API developers can implement REST in a variety of ways.

- API(Application Programming Interface)

---