# java.lang 패키지와 유용한 클래스

## Object클래스

java.lang패키지는 자바프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있다. 그렇기 때문에 java.lang패키지의 클래스들은 import문 없이도 사용할 수 있게 되어 있다.

### Object클래스

Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 멤버들은 모든 클래스에서 바로 사용 가능하다.

Object클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있다.

---

## Object클래스의 메서드 - equals()

매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려 주는 역할을 한다. 아래의 코드는 Object클래스에 정의되어 있는 equals메서드의 실제 내용이다.

```java
public boolean equals(Object obj) {
	return (this == obj;)
}
```

위의 코드에서 알 수 있듯이 두 객체의 같고 다름을 참조변수의 값으로 판단한다. 그렇기 때문에 서로 다른 두 객체를 equals메서드로 비교하면 항상 false를 결과로 얻게 된다.

*객채를 생성할 때, 메모리의 비어있는 공간을 찾아 생성하므로 서로 다른 두 개의 객체가 같은 주소를 갖는 일은 있을 수 없다.

```java
class Ex9_1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);

		if (v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
	} // main
} 

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}

// v1과 v2는 다릅니다.
```

equals메서드는 주소값으로 비교를 하기 때문에, 두 Value인스턴스의 멤버변수 value의 값이 10으로 서로 같을지라도 equals메서드로 비교한 결과는 false일 수밖에 없는 것이다.

---

## equals()의 오버라이딩

Object클래스로부터 상속받은 equals메서드는 결국 두개의 참조변수가 같은 객체를 참조하고 있는지, 즉 두 참조변수에 저장된 값(주소값)이 같은지를 판단하는 기능밖에 할 수 없다는 것을 알 수 있다. equals메서드로 Value인스턴스가 가지고 있는 value값을 비교하도록 할 수는 없을까? Value클래스에서 equals메서드를 오버라이딩하여 주소가 아닌 객체에 저장된 내용을 비교하도록 변경하면 된다.
 
```java
class Person {
	long id;

	public boolean equals(Object obj) {
		if(obj instanceof Person)
			return id ==((Person)obj).id;
		else
			return false;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))
			return false;

		Person p = (Person)obj;
		
		return this.id == p.id;
	}

	Person(long id) {
		this.id = id;
	}
}

class Ex9_2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
	}
}

// p1과 p2는 같은 사람입니다.
```
---

## Object클래스의 메서드 - hashCode()

이 메서드는 해싱(hashing)기법에 사용되는 '해시함수(hash function)'를 구현한 것이다. 해싱은 데이터관리기법 중의 하나인데 다량의 데이터를 저장하고 검색하는 데 유용하다.

해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드(hashcode)를 반환한다.

```java
class Ex9_3 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
}

// true
// 96354
// 96354
// 1407343478
// 1940447180
```

---

## Obeject클래스의 메서드 - toString()

이 메서드는 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의한 것이다. 인스턴스의 정보를 제공한다는 것은 대부분의 경우 인스턴스 변수에 저장된 값들을 문자열로 표현한다는 뜻이다.

```java
public String toString() {
	return getClass().getName()+"@"+Integer.toHexString(hashCode());
}
```

클래스를 작성할 때 toString()을 오버라이딩하지 않는다면, 위와 같은 내용이 그대로 사용 될 것이다. 즉, toString()을 호출하면 클래스이름과 16진수의 해시코드를 얻게 될 것이다.

```java
class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}

class Ex9_4 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}

// Card@5fcfe4b2
// Card@ea30797
```

---

## toString()의 오버라이딩

String클래스의 toString()은 String인스턴스가 갖고 있는 문자열을 반환하도록 오버라이딩 되어 있고, Date클래스의 경우, Date인스턴스가 갖고 있는 날짜와 시간을 문자열로 변환하여 반환하도록 오버라이딩되어 있다.

이처럼 toString()은 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환하여 반환하도록 오버라이딩되는 것이 보통이다.

```java
class Card2 {
	String kind;
	int number;

	Card2() {
		this("SPADE", 1);  // Card(String kind, int number)를 호출
	}

	Card2(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
}

class Ex9_5 {
	public static void main(String[] args) {
		Card2 c1 = new Card2();
		Card2 c2 = new Card2("HEART", 10);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}

// kind : SPADE, number : 1
// kind : HEART, number : 10
```

조상에 정의된 메서드를 자손에서 오버라이딩할 때는 조상에 정의된 접근범위보다 같거나 더 넓어야 하기 때문이다. Object클래스에서 toString()의 접근 제어자가 public이므로, 이를 오버라이딩하는 Card2클래스에서는 toString()의 접근 제어자를 public으로 해야 한다.

---

## String클래스

기존의 다른 언어에서는 문자열을 char형의 배열로 다루었으나 자바에서는 문자열을 위한 클래스를 제공한다. 그것이 바로 String클래스인데, String클래스는 문자열을 저장하고 이를 다루는데 필요한 메서드를 함께 제공한다.

### 변경 불가능한(immutable) 클래스

String클래스에는 문자열을 저장하기 위해서 문자형 배열 참조변수(char[]) value를 인스턴스 변수로 정의해놓고 있다. 인스턴스 생성 시 생성자의 매개변수로 입력받는 문자열은 이 인스턴스변수(value)에 문자형 배열(char[])로 저장되는 것이다.

```java
public final class String implements java.io.Serializable, Comparable {
	private char[] value;
}
```

한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경할 수는 없다.

---

## 문자열(String)의 비교

문자열을 만들 때는 두 가지 방법, 문자열 리터럴을 지정하는 방법과 String클래스의 생성자를 사용해서 만드는 방법이 있다.

```java
class Ex9_6 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("String str1 = \"abc\";");
		System.out.println("String str2 = \"abc\";");

		System.out.println("str1 == str2 ?  " + (str1 == str2));
		System.out.println("str1.equals(str2) ? " + str1.equals(str2));
		System.out.println();

		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println("String str3 = new String(\"abc\");");
		System.out.println("String str4 = new String(\"abc\");");

		System.out.println("str3 == str4 ? " + (str3 == str4));
		System.out.println("str3.equals(str4) ? " + str3.equals(str4));
	}
}

// String str1 = "abc";
// String str2 = "abc";
// str1 == str2 ?  true
// str1.equals(str2) ? true

// String str3 = new String("abc");
// String str4 = new String("abc");
// str3 == str4 ? false
// str3.equals(str4) ? true
```

---

## 문자열 리터럴(String리터럴)

자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된다. 이 때 같은 내용의 문자열 리터럴은 한번만 저장된다. 문자열 리터럴도 String인스턴스이고, 한번 생성하면 내용을 변경할 수 없으니 하나의 인스턴스를 공유하면 되기 때문이다.

클래스 파일이 클래스 로더에 의해 메모리에 올라갈 때, 클래스 파일의 리터럴들이 JVM내에 있는 '상수 저장소(constant pool)'에 저장된다.

---

## 빈 문자열(empty string)

'String s = "";'과 같은 문장이 있을 때, 참조변수 s가 참조하고 있는 String인스턴스는 내부에 'new char[0]'과 같이 길이가 0인 char형 배열을 저장하고 있는 것이다.

```java
class Ex9_8 {
	public static void main(String[] args) {
		// 길이가 0인 char배열을 생성한다.
		char[] cArr = new char[0];    // char[] cArr = {};와 같다.
		String s = new String(cArr);  // String s = new String("");와 같다.

		System.out.println("cArr.length="+cArr.length);
		System.out.println("@@@"+s +"@@@");
	}
}

// cArr.length=0
// @@@@@@
```

---

## String클래스의 생성자와 메서드

```java
String(char[] value) // 주어진 문자열(value)을 갖는 String인스턴스를 생성한다.

char[] c = {'H', 'e','l','l','o'};
String s = new String(c);

// s = "Hello"
```

```java
String(StringBuffer buf) // StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String인스턴스를 생성한다.

StringBuffer sb = new StringBuffer("Hello"); 
String s = new String(sb);

// s = "Hello"
```

```java
char charAt(int index) // 지정된 위치(index)에 있는 문자를 알려준다.(index는 0부터 시작)

String s = "Hello";
String n = "0123456";
char c = s.charAt(1);
char c2 = n.charAt(1);

// c = 'e'
// c2 = '1'
```

```java
int compareTo(String str) // 문자열(str)과 사전순서로 비교한다. 같으면 0을, 사전순으로 이전이면 음수를, 이후면 양수를 반환한다.

int i = "aaa".compareTo("aaa");
int i2 = "aaa".compareTo("bbb");
int i3 = "bbb".compareTo("aaa");

// i = 0 // 같으면
// i2 = -1 // 왼쪽이 작으면
// i3 = 1 // 오른쪽이 작으면
```

```java
String concat(String str) // 문자열(str)을 뒤에 덧붙인다.

String s = "Hello";
String s2 = s.concat(" world");

// s2 = "Hello World"
```

```java
boolean contains(CharSequence s) // 지정된 문자열(s)이 포함되었는지 검사한다.

String s = "abcdefg";
boolean b = s.contains("bc");

// b = true
```
 
```java
boolean endWith(String suffix) // 지정된 문자열(suffix)로 끝나는지 검사한다.

String file = "Hello.txt";
boolean b = file.endWith("txt");

// b = true
```

```java
boolean equals(Object obj) // 매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교한다. obj가 String이 아니거나 문자열이 다르면 false를 반환한다.

String s = "Hello";
boolean b = s.equals("Hello");
boolean b2 = s.equals("hello");

// b = true
// b2 = false
```

```java
boolean equalsIgnoreCase(String str) // 문자열과 String인스턴스의 문자열을 대소문자 구분없이 비교한다.

String s = "Hello";
boolean b = s.equalsIgnoreCase("HELLO");
boolean b2 = s.equalsIgnoreCase("heLLO");

// b = true
// b2 = true
```

```java
int indexOf(int ch) // 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.(index는 0부터 시작)

String s = "Hello";
int idx1 = s.indexOf('o');
int idx2 = s.indexOf('k');

// idx1 = 4
// idx2 = -1
```

```java
int indexOf(int ch, int pos) // 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다. (index는 0부터 시작)

String s = "Hello";
int idx1 = s.indexOf('e', 0);
int idx2 = s.indexOf('e', 2);

// idx1 = 1
// idx2 = -1
```

```java
int indexOf(String str) // 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다. 없으면 -1을 반환한다. (index는 0부터 시작)

String s = "ABCDEFG";
int idx = s.indexOf("CD");

// idx = 2
```

```java
int lastIndexOf(int ch) // 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.

String s = "java.lang.Object";
int idx1 = s.lastIndexOf('.');
int idx2 = s.IndexOf('.');

// idx1 = 9
// idx2 = 4
```

```java
int lastIndexOf(String str) // 지정된 문자열을 인스텅ㄴ스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.

String s = "java.lang.Object";
int idx1 = s.lastIndexOf('.');
int idx2 = s.indexOf('.');

// idx1 = 10
// idx2 = 0
```

```java
int length() // 문자열의 길이를 알려준다.

String s = "Hello";
int length = s.length();

// length = 5
```

```java
String[] split(String regex) // 문자열을 지정된 분지라(regex)로 나누어 문자열 배열에 담아 반환한다.

String animals = "dog,cat,bear";
String[] arr = animals.split(",");

// arr[0] = "dog"
// arr[1] = "cat"
// arr[2] = "bear"
```

```java
String[] split(String regex, int limit) // 문자열을 지정된 분리자(regex)로 나누어 문자열배열에 담아 반환하다. 단, 문자열 전체를 지정된 수(limit)로 자른다.

String animals = "dog,cat,bear";
String[] arr = animals.split(",", 2);

// arr[0] = "dog"
// arr[1] = "cat,bear"
```

```java
boolean startsWith(String prefix) // 주어진 문자열(prefix)로 시작하는지 검사한다.

String s = "java.lang.Object";
boolean b = s.startsWith("java");
boolean b2 = s.startsWith("lang");

// b = true
// b2 = false
```

```java
String substring(int begin)
String substring(int begin, int end) // 주어진 시작위치(begin)부터 끝 위치(end) 범위에 포함된 문자열을 얻는다. 이 때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다. (begin <= x < end)

String s = "java.lang.Object";
String c = s.substring(10);
String p = s.substring(5, 9);

// c = "Object"
// p = "lang"
```

```java
String toLowerCase() // String인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.

String s= "Hello";
String s1 = s.toLowerCase();

// s1 = "hello"
```

```java
String toUpperCase() // String인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.

String s = "Hello";
String s1 = s.toUpperCase();

// s1 = "HELLO"
```

```java
String trim() // 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다. 이 때 문자열 중간에 있는 공백은 제거되지 않는다.

String s = " Hello World ";
String s1 = s.trim();

// s1 = "Hello World"
```

---

## join()과 StringJoiner

join()은 여러 문자열 사이에 구분자를 넣어서 결합한다. 구분자로 문자열을 자르는 split()과 반대의 작업을 한다고 생각하면 이해하기 쉽다.

```java
String animals = "dog,cat,bear";
String[] arr = animals.split(","); // 문자열을 ','를 구분자로 나눠서 배열에 저장
String str = String.join("-", arr); // 배열의 문자열을 '-'로 구분해서 결합
System.out.println(str); // dog-cat-bear
```

java.util.StringJoiner클래스를 사용해서 문자열을 결합할 수도 있는데, 사용하는 방법은 간단하다.

```java
StringJoiner sj = new StringJoiner("," , "[" , "]");
String[] strArr = {"aaa", "bbb", "ccc"};

for (String s : strArr)
	sj.add(s.toUpperCase());

System.out.println(sj.toString()); // [AAA, BBB, CCC]
```

```java
import java.util.StringJoiner;

class Ex9_9 {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr   = animals.split(",");

		System.out.println(String.join("-", arr));

		StringJoiner sj = new StringJoiner("/","[","]");

		for(String s : arr)
			sj.add(s);

		System.out.println(sj.toString());
	}
}

// dog-cat-bear
// [dog/cat/bear]
```

---

## 문자열과 기본형 간의 변환

숫자에 빈 문자열""을 더해주기만 하면된다. 이 외에도 valueOf()를 사용하는 방법도 있다.

```java
int i = 100;
String str1 = i + ""; // 100을 "100"으로 변환하는 방법1
String str2 = String.valueOf(i); // 100을 "100"으로 변환하는 방법2
```

```java
int i  = Integer.parseInt("100"); // "100"을 100으로 변환하는 방법1
int i2 = Integer.valueOf("100"); // "100"을 100으로 변환하는 방법2
```

원래 valueOf()의 반환 타입은 int가 아니라 Integer인데, 곧 배울 오토박싱(auto-boxing)에 의해 Integer가 int로 자동 반환된다.

```java
Integer i2 = Integer.valueOf("100"); // 원래는 반환 타입이 Integer
```

```java
class Ex9_10 {
	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int를 String으로 변환한다.
		
		double dVal = 200.0;
		String strVal2 = dVal + "";	// int를 String으로 변화하는 또 다른 방법

		double sum  = Integer.parseInt(+strVal)
                                          + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		
		System.out.println(String.join("",strVal,"+",strVal2,"=")+sum);
		System.out.println(strVal+"+"+strVal2+"="+sum2);
	}
}

// 100+200.0=300.0
// 100+200.0=300.0
```
---

## StringBuffer클래스

String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만 StringBuffer클래스는 변경이 가능하다. 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있다.

```java
public finale class StringBuffer implements java.io.Serializable {
	private char[] value;
		...
}
```

---

## StringBuffer 생성자

StringBuffer클래스의 인스턴스를 생성할 떄, 적절한 길이의 char형 배열이 생성되고, 이 배열은 문자열을 저장하고 편집하기 위한 공간(buffer)으로 사용된다.

String 

```java
public StringBuffer(int length) {
	value = new char[length];
	shared = false;
}

public StringBuffer() {
	this(16);
}

public StringBuffer(String str) {
	this(str.length() + 16);
	append(str);
}

```

---

## StringBuffer의 변경

String과 달리 StringBuffer는 내용을 변경할 수 있다. 예를 들러 아래와 같이 StringBuffer를 생성하였다고 가정하자.

```java
StringBuffer sb = new StringBuffer("abc");

sb.append("123"); // sb의 내용 뒤에 "123"을 추가한다.

StringBuffer sb2 = sb.append("ZZ"); // sb의 내용뒤에 "ZZ"를 추가한다.
System.our.println(sb); // abc123ZZ
System.our.println(sb2); // abc123ZZ
```

```java
StringBuffer sb = new StringBuffer("abc");
sb.append("123").append("ZZ");
```
---

## StringBuffer의 비교

String클래스에서는 equals메서드를 오버라이딩해서 문자열의 내용을 비교하도록 구현되어 있지만, StringBuffer클래스는 equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도 등가비교연산자(==)로 비교한 것과 같은 결과를 얻는다.

toString()은 오버라이딩되어 있어서 StringBuffer인스턴스에 toString()을 호출하면, 담고있는 문자열을 String으로 반환한다.

StringBuffer인스턴스에 담긴 문자열을 비교하기 위해서는 StringBuffer인스턴스에 toString()을 호출해서 String인스턴스를 얻은 다음, 여기에 equals메서드를 사용해서 비교해야한다.

```java
class Ex9_11 {
	public static void main(String[] args) {
		StringBuffer sb  = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));
		
		// StringBuffer의 내용을 String으로 변환한다.
		String s  = sb.toString();	// String s = new String(sb);와 같다.
		String s2 = sb2.toString();

		System.out.println("s.equals(s2) ? " + s.equals(s2));
	}
}

// sb == sb2 ? false
// sb.equals(sb2) ? false
// s.equals(s2) ? true
```

---

## StringBuffer의 생성자와 메서드

```java
StringBuffer(int length) // 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer인스턴스를 생성한다.

String sb = new StringBuffer(10);
```

```java
int capacity() // StringBuffer인스턴스의 버퍼크기를 알려준다. length()는 버퍼에 담긴 문자열의 길이를 알려준다.

StringBuffer sb = new StringBuffer(100);
sb.append("abcd");
int bufferSize = sb.capacity();
int stringSize = sb.length();

// bufferSize = 100
// stringSize = 4(sb에 담긴 문자열이 "abcd"이므로)
```

```java
char charAt(int index) // 지정된 위치(index)에 있는 문자를 반환한다.

StringBuffer sb = new StringBuffer("abc");
char c = sb.charAt(2);

// c = 'c'
```

```java
StringBuffer delete(int start, int end) // 시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다. 단, 끝 위치의 문자는 제외.
StringBuffer sb = new StringBuffer("0123456");
StringBuffer sb2 = sb.delete(3, 6);

// sb = "0126"
// sb2 = "0126"
```

```java
StringBuffer deleteCharAt(int index) // 지정된 위치(index)의 문자를 제기한다.
StringBuffer sb = new StringBuffer("0123456");
sb.deleteCharAt(3);

// sb = "012456"
```

```java
int length() // StringBuffer인스턴스에 저장되어 있는 문자열의 길이를 반환한다.

String sb = new StringBuffer("0123456");
int length = sb.length();

// length = 7
```

```java
StringBuffer replace(int start, int end, String str); // 지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾼다. end위치의 문자는 범위에 포함 되지 않음.(start <= x < end)

StringBuffer sb = new StringBuffer("0123456");
sb.replace(3, 6, "AB");

// sb = "012AB6"
```

```java
StringBuffer reverse() // StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.

StrinfBuffer sb = new StringBuffer("0123456");
sb.reverse();

//sb = "6543210"
```

```java
void setCharAt(int index, char ch) // 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.

StringBuffer sb = new StringBuffer("0123456");
sb. setCharAt(5, '0');

// sb = "01234o6"
```

```java
void setLength(int newLength) // 지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우에 나머지 빈공간을 널문자 '\u0000'로 채운다.

StringBuffer sb = new StringBuffer("0123456");
sb.setLength(5);

StringBuffer sb2 = new StringBuffer("0123456");
sb2.setLength(10);
String str = sb2.toString().trim();

// sb = "01234"
// sb2 = "012345     "
// str = "0123456"
```

```java
String toString() // StringBuffer인스턴스의 문자열을 String으로 반환

StringBuffer sb = new StringBuffer("0123456");
String str = sb.toString();

// str = "0123456"
```

```java
String substring(int start)
String substring(int start, int end) // 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다. 시작위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아서 반환한다.

StringBuffer sb = new StringBuffer("0123456");
String str = sb.substring(3);
String str2 = sb.substring(3, 5);

// str = "3456"
// str2 = "34"
```

```java
class Ex9_12 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);			
		sb3.append(9.0);

		System.out.println("sb ="+sb);
		System.out.println("sb2="+sb2);
		System.out.println("sb3="+sb3);

		System.out.println("sb ="+sb.deleteCharAt(10));
		System.out.println("sb ="+sb.delete(3,6));
		System.out.println("sb ="+sb.insert(3,"abc"));
		System.out.println("sb ="+sb.replace(6, sb.length(), "END"));

		System.out.println("capacity="+sb.capacity());
		System.out.println("length="+sb.length());
	}
}

// sb =0123456789.0
// sb2=0123456789.0
// sb3=0123456789.0
// sb =01234567890
// sb =01267890
// sb =012abc67890
// sb =012abcEND
// capacity=18
// length=9
```

---

## StringBuilder

StringBuilder는 StringBuffer와 완전히 똑같은 기능으로 작성되어 있어서, 소스코드에서 StringBuffer 대신 StringBuilder를 사용하도록 바꾸기만 하면 된다.

---

## Math클래스

Math클래스는 기본적인 수학계산에 유용한 메서드로 구성되어 있다.

Math클래스의 생성자는 접근 제어자가 private이기 때문에 다른 클래스에서 Math인스턴스를 생성할 수 없도록 되어있다. 그 이유는 클래스 내에 인스턴스변수가 하나도 없어서 인스턴스를 생성할 필요가 없기 때문이다.

### 올림, 버림, 반올림

1. 원래 값에 10을 곱한다.

	90.7552 * 100 -> 9075.52

2. 위의 결과에 Math.round()를 사용한다.

	Math.round(9075.52) -> 90.76
3. 위의 결과를 다시 100.0으로 나눈다.

	9076 / 100.0 -> 90.76
	9076 / 100 -> 90

---

## Math의 클래스

```java
static double abs(double a)
static float abs(float f)
static int abs(int f)
static long abs(long f) // 주어진 값을 절대값을 반환한다.

int i = Math.abs(-10);
doublie d = Math.abs(-10.0);

// i = 10
// d = 10.0
```

```java
static double ceil(double a) // 주어진 값을 올림하여 반환하다.

double d = Math.ceil(10.1);
double d2 = Math.ceil(-10.1);
double d3 = Math.ceil(10.000015);

// d = 11.0
// d2 = -10.0
// d3 = 11.0
```

```java
static double floor(double a) // 주어진 값을 버림하여 반환한다.

double d = Math.floor(10.8);
double d2 = Math.floor(-10.8);

// d = 10.0
// d2 = -11.0
```

```java
static double max(double a, double b)
static float max(float a, float b)
static int max(int a, int b)
static long max(long a, long b) // 주어진 두 값을 비교하여 큰 쪽을 반환한다.

double d = Math.max(9.5, 9.50001);
int 1 = Math.max(O, -1);

// d = 9.50001
// i = 0
```

```java
static double min (double a, double b)
static float min (float a, float b)
static int min(int a, int b)
static long min(long a, long b) // 주어진 두 값을 비교하여 작은 쪽을 반환한다.

double d = Math.min(9.5, 9.50001);
int 1 = Math.min(O, -1);

// d = 9.5
// i = -1
```

```java
static double rint(double a) // 주어진 double값과 가장 가까운 정수값을 double형으로 반환한다. 단, 두 정수의 정가운데 있는 값(1.5, 2.5, 3.5 등)은 짝수를 반환

double d = Math.rint(1.2);
double d2 = Math.rint(2.6);
double d3 = Math.rint(3.5);
double d4 = Math.rint(4.5);

// d = 1.0
// d2 = 3.0
// d3 = 4.0
// d4 = 4.0
```

```java
static long round(double a)
static long round(float a) // 소수점 첫째자리에서 반올림한 정수값(long)을 반환한다. 두 정수의 정가운데 있는 값은 항상 큰 정수를 반환.(rint()의 결과와 비교)

long l = Math.round(1.2);
long l2 = Math.round(2.6);
long l3 = Math.round(3.5);
long l4 = Math.round(4.5);
double d = 90.7552;
double d2 = Math.round(d*100)/100.0;

// l = 1
// l2 = 3
// l3 = 4
// l4 = 5
// d = 90.7552
// d2 = 90.76
```

```java
import static java.lang.Math.*;
import static java.lang.System.*;

class Ex9_13 {
	public static void main(String args[]) {
		double val = 90.7552;
		out.println("round("+ val +")="+round(val));// 반올림

		val *= 100;
		out.println("round("+ val +")="+round(val));// 반올림

		out.println("round("+ val +")/100  =" + round(val)/100);   // 반올림
		out.println("round("+ val +")/100.0=" + round(val)/100.0); // 반올림
		out.println();
		out.printf("ceil(%3.1f)=%3.1f%n",  1.1, ceil(1.1));    // 올림
		out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.5));   // 버림	
		out.printf("round(%3.1f)=%d%n",    1.1, round(1.1));   // 반올림
		out.printf("round(%3.1f)=%d%n",    1.5, round(1.5));   // 반올림
		out.printf("rint(%3.1f)=%f%n",     1.5, rint(1.5));    // 반올림
		out.printf("round(%3.1f)=%d%n",   -1.5, round(-1.5));  // 반올림
		out.printf("rint(%3.1f)=%f%n",    -1.5, rint(-1.5));   // 반올림
		out.printf("ceil(%3.1f)=%f%n",    -1.5, ceil(-1.5));   // 올림
		out.printf("floor(%3.1f)=%f%n",   -1.5, floor(-1.5));  // 버림
	}
}

// round(90.7552)=91
// round(9075.52)=9076
// round(9075.52)/100  =90
// round(9075.52)/100.0=90.76

// ceil(1.1)=2.0
// floor(1.5)=1.0
// round(1.1)=1
// round(1.5)=2
// rint(1.5)=2.000000
// round(-1.5)=-1
// rint(-1.5)=-2.000000
// ceil(-1.5)=-1.000000
// floor(-1.5)=-2.000000
```

---

## 래퍼(wrapper) 클래스

객체지향 개념에서 모든 것은 객체로 다루어져야 한다. 그러나 자바에서는 8개의 기본형을 객체로 다루지 않는데 이것이 바로 자바가 완전한 객체지향 언어가 아니라는 얘기를 듣는 이유다. 그 대신 보다 높은 성능을 얻을 수 있었다.

때로는 기본형(primitive type) 변수도 어쩔 수 없이 객체로 다뤄야 하는 경우가 있다.

```java
public final class Integer extends Number implements Comparable {
		...
	private in value;
		...
}
```

```java
class Ex9_14 {
	public static void main(String[] args) {
		Integer i  = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println("i==i2 ? "+(i==i2));
		System.out.println("i.equals(i2) ? "+i.equals(i2));
		System.out.println("i.compareTo(i2)="+i.compareTo(i2));
		System.out.println("i.toString()="+i.toString());

		System.out.println("MAX_VALUE="+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE="+Integer.MIN_VALUE);
		System.out.println("SIZE="+Integer.SIZE+" bits");
		System.out.println("BYTES="+Integer.BYTES+" bytes");
		System.out.println("TYPE="+Integer.TYPE);
	}
}

// i.compareTo(i2)=0
// i.toString()=100
// MAX_VALUE=2147483647
// MIN_VALUE=-2147483648
// SIZE=32 bits
// BYTES=4 bytes
// TYPE=int
```

---

## Number클래스

이 클래스는 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스들의 조상이다.

- Object
  - Boolean
  - Character
  - Number
    - Byte
    - Short
    - Integer
    - Long
    - Float
    - Double
    - Biginteger
    - BigDecimal

---

## 문자열을 숫자로 변환하기

```java
int i = new Integer("100").intValue();
int i2 = Integer.parseInt("100"); // 주로 이 방법을 많이 사용.
int i3 = Integer.valueOf("100");
```

```java
class Ex9_15 {
	public static void main(String[] args) {
		int		i  = new Integer("100").intValue();
		int		i2 = Integer.parseInt("100");
		Integer  i3 = Integer.valueOf("100");

		int i4 = Integer.parseInt("100",2);
		int i5 = Integer.parseInt("100",8);
		int i6 = Integer.parseInt("100",16);
		int i7 = Integer.parseInt("FF", 16);
//		int i8 = Integer.parseInt("FF");     // NumberFormatException발생

		Integer i9 = Integer.valueOf("100",2);
		Integer i10 = Integer.valueOf("100",8);
		Integer i11 = Integer.valueOf("100",16);
		Integer i12 = Integer.valueOf("FF",16);
//		Integer i13 = Integer.valueOf("FF"); // NumberFormatException발생

		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println("100(2) -> "+i4);
		System.out.println("100(8) -> "+i5);
		System.out.println("100(16)-> "+i6);
		System.out.println("FF(16) -> "+i7);

		System.out.println("100(2) -> "+i9);
		System.out.println("100(8) -> "+i10);
		System.out.println("100(16)-> "+i11);
		System.out.println("FF(16) -> "+i12);
	}
}

// 100
// 100
// 100
// 100(2) -> 4
// 100(8) -> 64
// 100(16)-> 256
// FF(16) -> 255
// 100(2) -> 4
// 100(8) -> 64
// 100(16)-> 256
// FF(16) -> 255
```

---

## 오토박싱 & 언박싱

```java
class Ex9_16 {
	public static void main(String[] args) {
		int i = 10;

		// 기본형을 참조형으로 형변환(형변환 생략가능)
		Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);
		Object obj = (Object)i;    // Object obj = (Object)Integer.valueOf(i);

		Long     lng = 100L;  // Long lng = new Long(100L);

		int i2 = intg + 10;   // 참조형과 기본형간의 연산 가능
		long l = intg + lng;  // 참조형 간의 덧셈도 가능

		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;  // 참조형을 기본형으로 형변환도 가능(형변환 생략가능)

		Integer intg3 = intg2 + i3; 

		System.out.println("i     ="+i);
		System.out.println("intg  ="+intg);
		System.out.println("obj   ="+obj);
		System.out.println("lng   ="+lng);
		System.out.println("intg + 10  ="+i2);
		System.out.println("intg + lng ="+l);
		System.out.println("intg2 ="+intg2);
		System.out.println("i3    ="+i3);
		System.out.println("intg2 + i3 ="+intg3);
	}
}

// i     =10
// intg  =10
// obj   =10
// lng   =100
// intg + 10  =20
// intg + lng =110
// intg2 =20
// i3    =20
// intg2 + i3 =40
```

---