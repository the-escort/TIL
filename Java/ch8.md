# 예외처리

## 프로그램 오류

- **컴파일 에러** 컴파일 시에 발생하는 에러
- **런타임 에러** 실행 시에 발생하는 에러
- **논리적 에러** 실행은 되지만, 의도와 다르게 동작하는 것

소스코드를 컴파일 하면 컴파일러가 소스코드(*.java)에 대해 오타나 잘못된 구문, 자료형 체크 등의 기본적인 검사를 수행하여 오류가 있는지를 알려 준다. 컴파일러가 알려 준 에러들을 모두 수정해서 컴파일을 성공적으로 마치고 나면, 클래스 파일(*.class)이 생성되고, 생성된 클래스 파일을 실행할 수 있다.

런타임 에러를 방지하기 위해서는 프로그램의 실행 도중 발생할 수 있는 모든 경우의 수를 고려하여 이에 대한 대비를 하는 것이 필요하다.

- **에러(error)** 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
- **예외(exception)** 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류

---

## 예외 클래스의 계층구조

자바에서는 실행 시 발생할 수 있는 오류(Exception과 Error)를 클래스로 정의하였다.

모든 예외의 최고 조상은 Exception클래스이며, 상속계층도를 Exception클래스부터 도식화하면 다음과 같다.

- Exception
	- IOException
	- ClassNotFoundException
	- ...
	---
	- RuntimeException 
    	- ArithmeticException
    	- ClassCastException
    	- NullPointerException
    	- ...
    	- IndexOutOfBoundsException

1. **Exception클래스와 그 자손들**
2. **RuntimeException클래스와 그 자손들**

---

## Exception과 RuntimeException

- **Exception클래스들** 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
- **RuntimeException클래스들** 프로그래머의 실수로 발생하는 예외

---

## 예외 처리하기 - try-catch문

프로그램의 실행도중에 발생하는 에러는 어쩔 수 없지만, 예외는 프로그래머가 이에 대한 처리를 미리 해주어야 한다.

예외처리(exception handling)란, 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것이며, 예외처리의 목적은 예외의 발생으로 인한 실행 중인 프로그램의 갑작스런 비정상 종료를 막고, 정상적인 실행상태를 유지할 수 있도록 하는 것이다.

- **예외처리(exception handling)의**
  - **정의** 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
  - **목적** 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것

---

## try-catch문에서의 흐름

try-catch문에서, 예외가 발생한 경우와 발생하지 않았을 때 흐름이 달라진다.

```java
class Ex8_1 {
	public static void main(String args[]) {
			System.out.println(1);			
			try {
				System.out.println(2);
				System.out.println(3);
			} catch (Exception e)    {
				System.out.println(4);  // 실행되지 않는다.
			} // try-catch의 끝
			System.out.println(5);
	}
}

// 1
// 2
// 3
// 5
```

```java
class Ex8_2 {
	public static void main(String args[]) {
			System.out.println(1);
			try {
				System.out.println(0/0);
				System.out.println(2); 	// 실행되지 않는다.
			} catch (ArithmeticException ae)	{
				System.out.println(3);
			}	// try-catch의 끝
			System.out.println(4);
	}	// main메서드의 끝
}

// 1
// 3
// 4
```

---

## 예외의 발생과 catch블럭

catch블럭은 괄호()와 블럭{} 두 부분으로 나눠져 있는데, 괄호()내에는 처리하고자 하는 예외와 같은 타입의 참조변수 하나를 선언해야한다.

모든 예외 클래스는 Exception클래스의 자손이므로, catch블럭의 괄호()에 Exception클래스 타입의 참조변수를 선언해 놓으면 어떤 종류의 예외가 발생하더라고 이 catch블럭에 의해서 처리된다.

```java
class Ex8_4 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // ArithmeticException
			System.out.println(4); 	// 실행되지 않는다.
		} catch (ArithmeticException ae)	{
			if (ae instanceof ArithmeticException) 
				System.out.println("true");	
			System.out.println("ArithmeticException");
		} catch (Exception e){
			System.out.println("Exception");
		}	// try-catch의 끝
		System.out.println(6);
	}	// main메서드의 끝
}

// 1
// 2
// 3
// true
// ArithmeticException
// 6
```

try블럭에서 ArithmeticException이 발생하였으므로 instaceof연산자로 catch블럭을 하나씩 차례대로 검사하게 되는데, 첫 번째 검사에서 일치하는 catch블럭을 찾았기 떄문에 두 번째 catch블럭은 검사하지 않게 된다.

---

## printStackTrace()와 getMessage()

- **printStackTrace()** 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
- **getMessage()** 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

```java
java.lang.ArithmeticException: / by zero // printStackTrace()
	at Ex8_5.main(Ex8_5.java:8)
/ by zero // getMessage()
```

---

## 멀티 catch블럭

JDK1.7부터 여러 catch블럭을 '|'기호를 이용해서, 하나의 catch블럭으로 합칠 수 있게 되었으며, 이를 '멀티 catch블럭'이라 한다.

```java
try {
    ...
} catch (ExceptionA | ExceptionB e) {
    e.printStachTrace();
}
```

```java
try {
	...
} catch (ExceptionA | ExceptionB e) {
	e.methodA(); // 에러. ExceptionA에 선언된 methodA()는 호출불가

	if (e instanceof ExceptionA) {
		ExceptionA e1 = (ExceptionA)e;
		e1.methodA(); // OK. ExceptionA에 선언된 메서드 호출가능
	} else { // if(e instanceof ExceptionB)
		...
}
```

---

## 예외 발생시키기

키워드 throw를 사용해서 프로그래머가 고의로 예외를 발생시킬 수 있으며, 방법은 아래의 순서를 따르면 된다.

1. **연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음**

	Exception e = new Exception("고의로 발생시켰음");

2. **키워드 throw를 이용해서 예외를 발생시킨다.**

	throw e;

```java
class Ex8_6 {
	public static void main(String args[]) {
		try {
			Exception e = new Exception("고의로 발생시켰음.");
			throw e;	 // 예외를 발생시킴
		//  throw new Exception("고의로 발생시켰음.");

		} catch (Exception e)	{
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}
}
```

---

## checked예외, unchecked예외

```java
class Ex8_7 {
	public static void main(String[] args) {
		throw new Exception();		// Exception을 고의로 발생시킨다.
	}
}
```

```java
class Ex8_8 {
	public static void main(String[] args) {
		throw new RuntimeException();	// RuntimeException을 고의로 발생시킨다.
	}
}
```

---

## 메서드에 예외 선언하기

메서드에 예외를 선언하려면, 메서드의 선언부에 키워드 throws를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어주기만 하면 된다.

```java
void method() throws Exception1, Exception2, ... ExceptionN {
	// 메서드의 내용
}
```

*예외를 발생시키는 키워드 throw와 예외를 메서드에 선언할 때 쓰이는 throws를 잘 구별하자.

```java
class Ex8_9 {
	public static void main(String[] args) throws Exception {
		method1();	 // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
  	}	// main메서드의 끝

	static void method1() throws Exception {
		method2();
	}	// method1의 끝

	static void method2() throws Exception {
		throw new Exception();
	}	// method2의 끝
}

// Exception in thread "main" java.lang.Exception
// 	at Ex8_9.method2(Ex8_9.java:11)
// 	at Ex8_9.method1(Ex8_9.java:7)
// 	at Ex8_9.main(Ex8_9.java:3)
```

```java
import java.io.*;

class Ex8_10 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println( f.getName()+"파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage()+" 다시 입력해 주시기 바랍니다.");
		}
	}	// main메서드의 끝

	static File createFile(String fileName) throws Exception {
		if (fileName==null || fileName.equals(""))
			throw new Exception("파일이름이 유효하지 않습니다.");
		File f = new File(fileName);		//  File클래스의 객체를 만든다.
     	// File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
		f.createNewFile();
		return f;		// 생성된 객체의 참조를 반환한다.
	}	// createFile메서드의 끝
}	// 클래스의 끝
```

---

## finally블럭

finally블럭은 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용된다.

예외가 발생한 경우에는 'try -> catch -> finally'의 순으로 실행되고, 예외가 발생하지 않은 경우에는 'try -> finally'의 순으로 실행된다.

```java
try {
	starInstall(); // 프로그램 설치에 필요한 준비를 한다.
	copyFiles(); // 파일들을 복사한다.
} catch (Exception e) {
	e.printStackTrace();
} finally {
	deleteTempfiles(); // 프로그램 설치에 사용된 임시파일들을 삭제한다.
}
```

*try블럭 안에 return문이 있어서 try블럭을 벗어나갈 때도 finally블럭이 실행된다.

---