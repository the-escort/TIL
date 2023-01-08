# 객체지향 프로그래밍 I

## 객체지향 언어

1. **코드의 재사용성이 높다.**
	
	새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.

2. **코드의 관리가 용이하다.**
	
	코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.

3. **신뢰성이 높은 프로그래밍을 가능하게 한다.**
	
	제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.

**객체지향개념을 학습할 때 재사용성과 유지보수 그리고 중복된 코드의 제거, 이 세 가지 관점에서 보면 보다 쉽게 이해할 수 있을 것이다.**

**너무 객체지향개념에 얽매여서 고민하기 보다는 일단 프로그램을 기능적으로 완성한 다음 어떻게 하면 보다 객체지향적으로 코드를 개선할 수 있을지를 고민하여 점차 개선해 나가는 것이 좋다.**

---

## 클래스와 객체

클래스란 '객체를 정의해놓은 것.' 또는 클래스는 '객체의 설계도 또는 틀'이라고 정의할 수 있다. 클래스는 객체를 생성하는데 사용되며, 객체는 클래스에 정의된 대로 생성된다.

- **클래스의 정의** 클래스란 객체를 정의해 놓은 것
- **클래스의 용도** 클래스는 객체를 생성하는데 사용

프로그래밍에서의 객체는 클래스에 정의된 내용대로 메모리에 생성된 것을 뜻한다.

- **객체의 정의** 실제로 존재하는 것. 사물 또는 개념
- **객체의 용도** 객체가 가지고 있는 기능과 속성에 따라 다름

- **유형의 객체** 책상, 의자, 자동차, TV와 같은 사물
- **무형의 객체** 수학공식, 프로그램 에러와 같은 논리나 개념

클래스와 객체의 관계를 우리가 살고 있는 실생활에서 예를 들면, 제품 설계도와 제품과의 관계라고 할 수 있다. 예를 들면, TV설계도(클래스)는 TV라는 제품(객체)을 정의한 것이며, TV(객체)를 만드는데 사용된다.

또한 클래스는 단지 객체를 생성하는데 사용될 뿐, 객체 그 자체는 아니다. 우리가 원하는 기능의 객체를 사용하기 위해서는 먼저 클래스로부터 객체를 생성하는 과정이 선행되어야 한다.

|클래스|객체|
|:---:|:---:|
|제품 설계도|제품|
|TV 설계도|TV|
|붕어빵 기계|붕어빵|

---

## 객체의 구성요소 - 속성과 기능

객체는 속성과 기능, 두 종류의 구성요소로 이루어져 있으며, 일반적으로 객체는 다수의 속성과 다수의 기능을 갖는다. 즉, 객체는 속성과 기능의 집합이라고 할 수 있다. 그리고 객체가 가지고 있는 속성과 기능을 그 객체의 멤버(구성원, member)라 한다.

클래스란 객체를 정의한 것이므로 클래스에는 객체의 모든 속성과 기능이 정의되어 있다. 클래스로부터 객체를 생성하면, 클래스에 정의 속성과 기능을 가진 객체가 만들어지는 것이다.

객체지향 프로그래밍에서는 속성과 기능을 각각 변수와 메서드로 표현한다.

속성(property) -> 멤버변수(variable)

기능(function) -> 메서드(method)

 ```java
class Tv {
    String color; // 색깔
    boolean power; // 전원상태
    int channel; // 채널
    // 속성 - 변수

    void power() {power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}
    // 기능 - 메서드
}
 ```

---

## 객체와 인스턴스

클래스로부터 객체를 만드는 과정을 클래스의 인스턴스화(instantiate)라고 하며, 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스(instance)라고 한다.

예를 들면, Tv클래스로부터 만들어진 객체를 Tv클래스의 인스턴스라고 한다. 결국 인스턴스는 객체와 같은 의미이지만, 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 갖고 있으며, 인스턴스는 어떤 클래스로부터 만들어진 것인지를 보다 강조하는 의미를 갖고 있다.

- **클래스 -> 인스턴스화 -> 인스턴스(객체)**

---

## 객체의 생성과 사용

Tv클래스를 선언한 것은 Tv설계도를 작성한 것에 불과하므로, Tv인스턴스를 생성해야 제품(Tv)을 사용할 수 있다.

- **클래스명 변수명;** // 클래스의 객체를 참조하기 위한 참조변수를 선언
- **변수명 = new 클래스명();** // 클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장

- **Tv t;** // Tv클래스 타입의 참조변수 t를 선언
- **t = new Tv();** // Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장

```java
class Ex6_1 { 
	public static void main(String args[]) { 
		Tv t;                 // Tv인스턴스를 참조하기 위한 변수 t를 선언       
		t = new Tv();         // Tv인스턴스를 생성한다. 
		t.channel = 7;        // Tv인스턴스의 멤버변수 channel의 값을 7로 한다. 
		t.channelDown();      // Tv인스턴스의 메서드 channelDown()을 호출한다. 
		System.out.println("현재 채널은 " + t.channel + " 입니다."); 
	} 
}

class Tv { 
	// Tv의 속성(멤버변수)   
	String color;           // 색상 
	boolean power;         	// 전원상태(on/off) 
	int channel;           	// 채널 

	// Tv의 기능(메서드) 
	void power()   { power = !power; }  // TV를 켜거나 끄는 기능을 하는 메서드  
	void channelUp()   {  ++channel; }  // TV의 채널을 높이는 기능을 하는 메서드 
	void channelDown() { --channel; }   // TV의 채널을 낮추는 기능을 하는 메서드  
}

// 현재 채널은 6 입니다.
```

- **인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야 한다.**

같은 클래스로부터 생성되었을지라도 각 인스턴스의 속성(멤버변수)은 서로 다른 값을 유지할 수 있으며, 메서드의 내용은 모든 인스턴스에 대해 동일하다.

```java
class Ex6_2 {
	public static void main(String args[]) {
		Tv t1 = new Tv();  // Tv t1; t1 = new Tv();를 한 문장으로 가능
		Tv t2 = new Tv();
		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");

		t1.channel = 7;    // channel 값을 7으로 한다.
		System.out.println("t1의 channel값을 7로 변경하였습니다.");

		System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
	}
}

// t1의 channel값은 0입니다.
// t2의 channel값은 0입니다.
// t1의 channel값을 7로 변경하였습니다.
// t1의 channel값은 7입니다.
// t2의 channel값은 0입니다.
```

---

## 객체배열

```java
Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv타입의 참조변수 배열

tvArr = tvArr[0] tvArr[1]tvArr[2]
		null	null	null
```

위의 그림에서 알 수 있듯이 객체 배열을 생성하는 것은, 그저 객체를 다루기 위한 참조변수들이 만들어진 것일 뿐, 아직 객체가 저장되지 않았다. 객체를 생성해서 객체 배열의 각 요소에 저장하는 것을 잊으면 안 된다.

```java
Tv[] tvArr = new Tv[3]; // 참조변수 배열(객체 배열)을 생성

// 객체를 생성해서 배열의 각 요소에 저장
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();

    =

Tv[] tvArr = {new Tv(), new Tv(), new Tv()};

    =

Tv[] tvArr = new Tv[3];

for (int i = 0; i < tvArr.length; i++) {
    tvArr[i] = new Tv();
}
```

---

## 선언위치에 따른 변수의 종류

변수의 종류를 결정짓는 중요한 요소는 '변수의 선언 위치'이므로 변수의 종류를 파악하기 위해서는 변수가 어느 영역에 선언되었는지를 확인하는 것이 중요하다.

```java
class Variables { // 클래스 영역
    int iv; // 인스턴스 변수
    static int cv; // 클래스 변수(static변수, 공유변수)

    void method() { // 메서드 영역
        int lv = 0; // 지역변수
    }
}
```

|변수의 종류|선언위치|생성시기|
|:---:|:---:|:---:|
|클래스 변수|클래스 영역|클래스가 메모리에 올라갈 때|
|인스턴스 변수|클래스 영역|인스턴스가 생성되었을 때|
|지역변수|클래스 영역 이외의 영역<br>(메서드, 생성자, 초기화 블럭 내부)|변수 선언문이 수행되었을 때|

1. **인스턴스 변수(instance variable)** - 클래스 영역에 선언되며, 인스턴스를 생성할 때 만들어진다. 그래서 인스턴스 변수(iv)의 값을 읽어 오거나 저장하려면 먼저 인스턴스를 생성해야 한다. 인스턴스마다 고유한 상태를 유지해야한는 속성의 경우, 인스턴스 변수로 선언한다.

2. **클래스 변수(class variable)** - 인스턴스마다 독립적인 저장공간을 갖는 인스턴스 변수와는 달리, 클래스 변수는 모든 인스턴스가 공통된 저장공간(변수)을 공유하게 된다. 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우, 클래스 변수로 선언해야 한다.

   클래스 변수는 인스턴스 변수와 달리 인스턴스를 생성하지 않고 언제라도 바로 사용할 수 있다는 특징이 있으며, '클래스 이름.클래스 변수'와 같은 형식으로 사용한다.

3. **지역변수(local variable)** - 메서드 내에 선언되어 메서드 내에서만 사용 가능하며, 메서드가 종료되면 소멸되어 사용할 수 없게 된다. for문 또는 while문의 블럭 내에 선언된 지역 변수는, 지역변수가 선언된 블럭{} 내에서만 사용 가능하며, 블럭{}을 벗어나면 소멸되어 사용할 수 없게 된다.

---

## 클래스 변수와 인스턴스 변수

```java
class Card {
    String kind; // 무늬
    int number; // 숫자
    // 인스턴스 변수(개별 속성)

    static int width = 100; // 폭
    static int height = 250; // 높이
    // 클래스 변수(공통 속성)
}
```

- **인스턴스 변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.**

---

## 메서드란?

'메서드(method)'는 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것이다.

메서드는 크게 두 부분, '선언부(header, 머리)'와 '구현부(body, 몸통)'로 이루어져 있다.

```java
int add(int a, int b) // 선언부
{ // 구현부
    int result = a + b;
    return result; // 호출한 메서드로 결과를 반환한다.
}
```

---

## 메서드의 선언부

메서드 선언부는 '메서드의 이름'과 '매개변수 선언', 그리고 '반환타입'으로 구성되어 있으며, 메서드가 작업을 수행하기 위해 어떤 값들을 필요로 하고 작업의 결과로 어떤 타입의 값을 반환하는지에 대한 정보를 제공한다.

```java
int add(int x, int y) {
    int result = x + y;

    return result; // 결과를 반환
}
```

### 매개변수 선언(parameter declaration)

매개변수는 메서드가 작업을 수행하는데 필요한 값들(입력)을 제공받기 위한 것이며, 필요한 값의 개수만큼 변수를 선언하며 각 변수 간의 구분은 쉼표','를 사용한다. 한 가지 주의할 점은 일반적인 변수선언과 달리 두 변수의 타입이 같아도 **변수의 타입을 생략할 수 없다는 것이다.**

```java
int add(int x, int y) {...}; // OK.
int add(int x, y) {...}; // 에러. 매개변수 y의 타입이 없다.
```

만일 값을 전혀 입력받을 필요가 없다면 괄호() 안에 아무 것도 적지 않는다.

### 반환타입(return type)

메서드의 작업수행 결과(출력)인 '반환값(return value)'의 타입을 적는다. 단, 반환값이 없는 경우 반환타입으로 'void'를 적어야한다.

```java
void print99danAll() {
    for (int i = 1; i <= 9; i++) {
        for (int j = 2; j <= 9; j++) {
            System.out.print(j + "*" + i + "=" + (j+i) + " ");
        }
        System.out.println():
    }
}
```

---

## 메서드의 구현부

메서드의 선언부 다음에 오는 괄호{}를 '메서드의 구현부'라고 하는데, 여기에 메서드를 호출했을 때 수행될 문장들을 넣는다.

### return문

메서드의 반환타입이 'void'가 아닌 경우, 구현부{} 안에 'return 반환값;'이 반드시 포함되어 있어야 한다. 이 문장은 작업을 수행한 결과인 반환값을 호출한 메서드로 전달하는데, 이 값의 타입은 반환타입과 **일치하거나 적어도 자동 형변환이 가능한 것**이어야 한다.

```java
int add(int x, int y) {
    int result = x + y;
    return result; // 작업 결과(반환값)를 반환한다.
}
```

위의 코드에서 'return result;'는 변수 result에 저장된 값을 호출한 메서드로 반환한다. 변수 result의 타입이 int이므로 메서드 add의 반환타입이 일치하는 것을 알 수 있다.

### 지역변수(local variable)

메서드 내에 선언된 변수들은 그 메서드 내에서만 사용할 수 있으므로 서로 다른 메서드라면 같은 이름의 변수를 선언해도 된다. 이처럼 메서드 내에 선언된 변수를 '지역변수(local variable)라고 한다.'

*매개변수도 메서드 내에 선언된 것으로 간주되므로 지역변수이다.

```java
int add(int x, int y) {
    int result = x + y;
    return result;
}

int multiply(int x, int y) {
    int result = x + y;
    return result;
}
```

---

## 메서드의 호출

메서드를 정의했어도 호출되지 않으면 아무 일도 일어나지 않는다. 메서드를 호출해야만 구현부{}의 문장들이 수행된다.

### 인수(argument)와 매개변수(parameter)

메서드를 호출할 때 괄호() 안에 지정해준 값들을 '인수(argument)' 또는 '인자'라고 하는데, 인자의 개수와 순서는 호출된 메서드에 선언된 매개변수와 일치해야 한다.

그리고 인수는 메서드가 호출되면서 매개변수에 대입되므로, 인자의 타입은 매개변수의 타입과 일치하거나 자동 형변환이 가능한 것이어야 한다.

```java
public static void main(String[] args) {
		// 인수(argument, 원본)
    int result = add(3, 5); // 메서드 호출
}
```

```java
int add(int x, int y) { // 매개변수(parameter, 복사본)
    int result = x + y;
    return result;
}
```

---

## 메서드의 실행 흐름

메서드가 호출되면 지금까지 실행 중이던 메서드는 실행을 잠시 멈추고 호출된 메서드의 문장들이 실행된다. 호출된 메서드의 작업이 모두 끝나면, 다시 호출한 메서드로 돌아와 이후의 문장들을 실행한다.

```java
class Ex6_4 {
	public static void main(String args[]) {
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);

		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);
	}
 }

 class MyMath {
	long add(long a, long b) {
		long result = a + b;
		return result;
	//	return a + b;	// 위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있다.
	}
	long subtract(long a, long b) { return a - b; }
	long multiply(long a, long b) { return a * b; }
	double divide(double a, double b) {
		return a / b;
	}
 }

// add(5L, 3L) = 8
// subtract(5L, 3L) = 2
// multiply(5L, 3L) = 15
// divide(5L, 3L) = 1.6666666666666667
```

---

## return문

return문은 현재 실행중인 메서드를 종료하고 호출한 메서드로 되돌아간다. 지금까지 반환값이 있을 때만 return문을 썼지만, 원래는 반환값의 유무에 관계없이 모든 메서드에는 적어도 하나의 return문이 있어야 한다. 그런데도 반환타입이 void인 경우, return문 없이도 아무런 문제가 없었던 이유는 컴파일러가 메서드의 마지막에 'return;'을 자동적으로 추가해주었기 때문이다.

반환타입이 void가 아닌 경우, 즉 반환값이 있는 경우, 반드시 return문이 있어야 한다.

```java
int multiply(int x, int y) {
    int result = x * y;

    return result; // 반환 타입이 void가 아니므로 생략불가
}
```

```java
int max(int a, int b) {
    if (a > b)
        return a; // 조건식이 참일 때 실행된다.
    else
        return b; // 조건식이 거짓일 때 실행된다.
}
```

---

## 반환값

return문은 반환값으로 주로 변수가 오긴 하지만 항상 그런 것은 아니다.

```java
int add(int x, int y) {
    return x + y;
}
```

아래의 diff메서드는 두 개의 정수를 받아서 그 차이를 절대값으로 반환한다.

```java
int diff(int x, int y) {
    return abs(x - y);
}
```

메서드 abs는 입력받은 정수의 부호를 판단해서 음수일 경우 부호연산자(-)를 사용해서 양수로 반환한다.

```java
int abs(int x) {
    return x >= 0 ? x : -x;
}
```

---

## 호출스택(call stack)

- 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
- 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
- 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다.
- 아레에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다.

---

## 기본형 매개변수

매개변수의 타입이 기본형(primitive type)일 때는 기본형 값이 복사되겠지만, 참조형(reference type)이면 인스턴스의 주소가 복사된다. 메서드의 매개변수를 기본형으로 선언하면 단순히 저장된 값만 얻지만, 참조형으로 선언하면 값이 저장된 곳의 주소를 알 수 있기 때문에 값을 읽어 오는 것은 물론 값을 변경하는 것도 가능하다.

- **기본형 매개변수** 변수의 값을 읽기만 할 수 있다.(read only)
- **참조형 매개변수** 변수의 값을 읽고 변경할 수 있다.(read & write)

```java
class Data { int x; }

class Ex6_6 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(int x) { // 기본형 매개변수
		x = 1000;
		System.out.println("change() : x = " + x);
	}
}

// main() : x = 10
// change() : x = 1000
// After change(d.x)
// main() : x = 10
```

'd.x'의 값이 변경된 것이 아니라, change메서드의 매개변수 x의 값이 변경된 것이다. 즉, 원본이 아닌 복사본이 변경된 것이라 원본에는 아무런 영향을 미치지 못한다.

---

## 참조형 매개변수

```java
class Data2 { int x; }

class Ex6_7 {
	public static void main(String[] args) {
		Data2 d = new Data2();
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d);
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(Data2 d) { // 참조형 매개변수
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}
}

// main() : x = 10
// change() : x = 1000
// After change(d)
// main() : x = 1000
```

change메서드의 매개변수가 참조형이라서 값이 아니라 '값이 저장된 주소'를 change메서드에게 넘겨주었기 때문에 값을 읽어오는 것뿐만 아니라 변경하는 것도 가능하다.
 
change메서드의 매개변수를 참조형으로 선언했기 때문에, x의 값이 아닌 변수 d의 주소가 매개변수 d에 복사되었다. 이제 main메서드의 참조변수 d와 change메서드의 참조변수 d는 같은 객체를 가리키게 된다.

---

## 참조형 반환타입

매개변수뿐만 아니라 반환타입도 참조형이 될 수 있다. 반환타입이 참조형이라는 것은 반환하는 값의 타입이 참조형이라는 얘긴데, 모든 참조형 타입의 값은 '객체의 주소'이므로 그저 정수값이 반환되는 것일 뿐 특별할 것이 없다.

```java
class Data3 { int x; }

class Ex6_8 {
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;

		Data3 d2 = copy(d); 
		System.out.println("d.x ="+d.x);
		System.out.println("d2.x="+d2.x);
	}

	static Data3 copy(Data3 d) {
		Data3 tmp = new Data3(); // 새로운 객체 tmp를 생성한다.

		tmp.x = d.x; // d.x의 값을 tmp.x에 복사한다.

		return tmp;  // 복사한 객체의 주소를 반환한다.
	}
}

// d.x =10
// d2.x=10
```
copy메서드는 새로운 객체를 생성한 다음에, 매개변수로 넘겨받은 객체에 저장된 값을 복사해서 반환한다. 반환하는 값이 Data객체의 주소이므로 반환 타입이 'Data'인 것이다.
 
---

## static 메서드와 인스턴스 메서드

클래스는 '데이터(변수)와 데이터에 관련된 메서드의 집합'이므로, 같은 클래스 내에 있는 메서드와 멤버변수는 아주 밀접한 관계가 있다.

```java
class MyMath2 {
	long a, b;

	// 인스턴스 변수 a, b만을 이용해서 작업하므로 매개변수가 필요없다.
	long add() { return a + b; }  // a, b는 인스턴스 변수
	long subtract() { return a - b; }
	long multiply() { return a * b; }
	double divide() { return a / b; }

	// 인스턴스 변수와 관계없이 매개변수만으로 작업이 가능하다.
	static long   add(long a, long b) { return a + b; }  // a, b는 지역변수
	static long   subtract(long a, long b) { return a - b; }
	static long   multiply(long a, long b) { return a * b; }
	static double divide(long a, long b) { return a / (double)b; }
	
}


class Ex6_9 {
	public static void main(String args[]) {
		// 클래스 메서드 호출. 인스턴스 생성없이 호출가능
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200L, 100L));

		MyMath2 mm = new MyMath2(); // 인스턴스를 생성
		mm.a = 200L;
		mm.b = 100L;
		// 인스턴스 메서드는 객체생성 후에만 호출이 가능함.
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
   }
}

// 300
// 100
// 20000
// 2.0
// 300
// 100
// 20000
// 2.0
```

---

## static을 언제 붙여야 할까?

1. **클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다.**
	- 생성된 각 인스턴스는 서로 독립적이기 때문에 각 인스턴스의 변수(iv)는 서로 다른 값을 유지한다. 그러나 모든 인스턴스에서 같은 값이 유지되어야 하는 변수는 static을 붙여서 클래스변수로 정의해야 한다.

2. **클래스 변수(static변수)는 인스턴스를 생성하지 않아도 사용할 수 있다.**
	- static이 붙은 변수(클래스변수)는 클래스가 메모리에 올라갈 때 이미 자동적으로 생성되기 때문이다.

3. **클래스 메서드(static메서드)는 인스턴스 변수를 사용할 수 없다.**
	- 인스턴스변수는 인스턴스가 반드시 존재해야만 사용할 수 있는데, 클래스메서드(static이 붙은 메서드)는 인스턴스 생성 없이 호출가능하므로 클래스 메서드가 호출되었을 때 인스턴스가 존재하지 않을 수도 있다. 그래서 클래스 메서드에서 인스턴스변수의 사용을 금지한다.

		반면에 인스턴스변수나 인스턴스메서드에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능하다. 인스턴스 변수가 존재한다는 것은 static변수가 이미 메모리에 존재한다는 것을 의미하기 때문이다.

4. **메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.**
    - 메서드의 작업내용 중에서 인스턴스변수를 필요로 한다면, static을 붙일 수 없다. 반대로 인스턴스변수를 필요로 하지 않는다면 static을 붙이자. 메서드 호출시간이 짧아지므로 성능이 향상된다. static을 안 붙인 메서드(인스턴스메서드)는 실행 시 호출되어야할 메서드를 찾는 과정이 추가적으로 필요하기 때문에 시간이 더 걸린다.

- 클래스의 멤버변수 중 모든 인스턴스에 공통된 값을 유지해야하는 것이 있는지 살펴보고 있으면, static을 붙여준다.

- 작성한 메서드 중에서 인스턴스 변수나 인스턴스 메서드를 사용하지 않는 메서드에 static을 붙일 것을 고려한다.

---

## 메서드 간의 호출과 참조

같은 클래스에 속한 멤버들 간에는 별도의 인스턴스를 생성하지 않고도 서로 참조 또는 호출이 가능하다. 단, 클래스멤버가 인스턴스 멤버를 참조 또는 호출하고자 하는 경우에는 인스턴스를 생성해야 한다.

그 이유는 **인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재하지만, 클래스멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있기 때문이다.**

```java
class TestClass {
    void instanceMethod() {} // 인스턴스메서드
    static void staticMethod() {} // static메서드

    void instanceMethod2() { // 인스턴스메서드
        instanceMethod(); // 다른 인스턴스메서드를 호출한다.
        staticMethod(); // static메서드를 호출한다.
    }

    static void staticMethod2() { // static메서드
        instanceMethod(); // 에러!! 인스턴스메서드를 호출할 수 없다.
        staticMethod(); // static메서드는 호출 할 수 있다.
    }
}
```

```java
class TestClass2 {
    int iv; // 인스턴스 변수
    static int cv; // 클래스 변수

    void instanceMethod() { // 인스턴스메서드
        System.out.println(iv); // 인스턴스 변수를 사용할 수 있다.
        System.out.println(cv); // 클래스 변수를 사용할 수 있다.
    }

    static void staticMethod() { // static메서드
        System.out.println(iv); // 에러!! 인스턴스 변수를 사용할 수 없다.
        System.out.println(cv); // 클래스 변수는 사용할 수 있다.
    }
}
```

---

## 오버로딩(overloading)

메서드도 변수와 마찬가지로 같은 클래스 내에서 서로 구별될 수 있어야 하기 때문에 각기 다른 이름을 가져야 한다. 그러나 자바에서는 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메서드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메서드를 정의할 수 있다.

이처럼, 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것을 '메서드 오버로딩(method overloading)' 또는 간단히 '오버로딩(overloading)'이라 한다.

같은 이름의 메서드를 정의한다고 해서 무조건 오버로딩인 것은 아니다. 오버로딩이 성립하기 위해서는 다음과 같은 조건을 만족해야한다.

1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
3. 반환 타입은 관계없다.

**반환 타입은 오버로딩을 구현하는데 아무런 영향을 주지 못한다.**

```java
class Ex6_10 {
	public static void main(String args[]) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3, 3) 결과:"    + mm.add(3,3));
		System.out.println("mm.add(3L, 3) 결과: "  + mm.add(3L,3));
		System.out.println("mm.add(3, 3L) 결과: "  + mm.add(3,3L));
		System.out.println("mm.add(3L, 3L) 결과: " + mm.add(3L,3L));

		int[] a = {100, 200, 300};
		System.out.println("mm.add(a) 결과: " + mm.add(a));
   }
}

class MyMath3 {
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	
	long add(int a, long b) {
		System.out.print("long add(int a, long b) - ");
		return a+b;
	}
	
	long add(long a, int b) {
		System.out.print("long add(long a, int b) - ");
		return a+b;
	}

	long add(long a, long b) {
		System.out.print("long add(long a, long b) - ");
		return a+b;
	}

	int add(int[] a) { // 배열의 모든 요소의 합을 결과로 돌려준다.
		System.out.print("int add(int[] a) - ");
		int result = 0;  
		for(int i=0; i < a.length;i++) 
			result += a[i];
		
		return result;
	}
}

// int add(int a, int b) - mm.add(3, 3) 결과:6
// long add(long a, int b) - mm.add(3L, 3) 결과: 6
// long add(int a, long b) - mm.add(3, 3L) 결과: 6
// long add(long a, long b) - mm.add(3L, 3L) 결과: 6
// int add(int[] a) - mm.add(a) 결과: 600
```

---

## 생성자(constructor)

생성자는 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'이다.

생성자의 조건은 다음과 같다.

1. 생성자의 이름은 클래스의 이름과 같아야 한다.
2. 생성자는 리턴 값이 없다.

```java
클래스이름(타입 변수명, 타입 변수명, ...) {
    // 인스턴스 생성시 수행될 코드,
    // 주로 인스턴스 변수의 초기화 코드를 적는다.
}
```

```java
class Point () {
    Point() { // 매개변수가 없는 생성자.
        ...
    }
    Point(int x, int y) { // 매개변수가 있는 생성자.
        ...
    }
    ...
}
```

**연산자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것이 아니다.**

---

## 기본 생성자(default constructor)

```java
클래스이름() {} // 기본 생성자

Point() {} // Point클래스의 기본 생성자
```

- **기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.**

---

## 매개변수가 있는 생성자

생성자도 메서드처럼 매개변수를 선언하여 호출 시 값을 넘겨받아서 인스턴스의 초기화 작업에 사용할 수 있다. 인스턴스마다 각기 다른 값으로 초기화되어야 하는 경우가 많기 때문에 매개변수를 사용한 초기화는 매우 유용하다.

```java
class Car {
	String color; // 색상
	String gearType; // 변속기 종류 - auto(자동), manual(수동)
	int door; // 문의 개수

    Car() {} // 기본 생성자
	Car(String c, String g, int d) { // 생성자
		color = c;
		gearType = g;
		door = d;
	}
}
```

인스턴스를 생성한 다음에 인스턴스 변수의 값을 변경하는 것보다 매개변수를 갖는 생성자를 사용하는 것이 코드를 보다 간결하고 직관적으로 만든다.

```java
Car c = new Car("white", "auto", 4);
```

- **인스턴스를 생성할 때는 다음의 2가지 사항을 결정해야 한다.**
	1. **클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?**
    2. **생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?**

```java
class Car {
	String color;		// 색상
	String gearType;	// 변속기 종류 - auto(자동), manual(수동)
	int door;			// 문의 개수

	Car() {}

	Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}

class Ex6_12 {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;

		Car c2 = new Car("white", "auto", 4);

		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
	}
}

// c1의 color=white, gearType=auto, door=4
// c2의 color=white, gearType=auto, door=4
```

---

## 생성자에서 다른 생성자 호출하기 - this()

같은 클래스의 멤버들 간에 서로 호출할 수 있는 것처럼 생성자 간에도 서로 호출이 가능하다.

- **생성자의 이름으로 클래스이름 대신 this를 사용한다.**
- **한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.**

```java
class Car2 {
	String color; // 색상
	String gearType; // 변속기 종류 - auto(자동), manual(수동)
	int door; // 문의 개수

	Car2() {this("white", "auto", 4);
	}

	Car2(String color) {
		this(color, "auto", 4);
	}

	Car2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
class Ex6_13 {
	public static void main(String[] args) {
		Car2 c1 = new Car2();	
		Car2 c2 = new Car2("blue");

		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
	}
}

// c1의 color=white, gearType=auto, door=4
// c2의 color=blue, gearType=auto, door=4
```

---

## 객체 자신을 가리키는 참조변수 - this

```java
Car(String color, String gearType, int door) { // this.color는 iv, color는 lv
	this.color = color;
	this.gearType = gearType;
	this.door = door;
}
```

- **this** 인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다.

	모든 인스턴스메서드에 지역변수로 숨겨진 채로 존재한다.

- **this(), this(매개변수)** 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.

  *this와 this()는 비슷하게 생겼을 뿐 완전히 다른 것이다. this는 '참조 변수'이고, this()는 '생성자'이다.

---

## 변수의 초기화

변수를 선언하고 처음으로 값을 저장하는 것을 '변수의 초기화'라고 한다.

멤버변수는 초기화를 하지 않아도 자동적으로 변수의 자료형에 맞는 기본값으로 초기화가 이루어지므로 초기화하지 않고 사용해도 되지만, **지역변수는 사용하기 전에 반드시 초기화해야 한다.**

```java
class InitTest {
    int x; // 인스턴스 변수
    int y = x; // 인스턴스 변수

    void method1() {
        int i; // 지역변수
        int j = i; // 에러. 지역변수를 초기화하지 않고 사용
}
```

- **멤버변수(클래스 변수와 인스턴스 변수)와 배열의 초기화는 선택이지만, 지역변수의 초기화는 필수이다.**

---

## 멤버변수의 초기화

지역변수와 달리 멤버변수는 각 타입의 기본값으로 자동 초기화 된다. 그 다음에 명시적 초기화, 초기화 블럭, 생성자의 순서로 초기화 된다. 그리고 클래스 변수(cv)가 인스턴스 변수(iv)보다 먼저 초기화 된다.

1. **클래스 변수(cv) 초기화 -> 인스턴스 변수(iv) 초기화**
2. **자동 초기화 -> 명시적 초기화(간단) -> 초기화 블럭, 생성자(복잡)**

### 명시적 초기화(explicit initialization)

변수를 선언과 동시에 초기화하는 것을 명시적 초기화라고 한다.

```java
class Car {
    int door = 4; // 기본형(primitive type) 변수의 초기화
    Engine e = new Engine(); // 참조형(reference type) 변수의 초기화

    // ...
}
```

### 초기화 블럭(initialization block)

초기화 블럭에는 '클래스 초기화 블럭'과 '인스턴스 초기화 블럭' 두 가지 종류가 있다.

- **클래스 초기화 블럭** 클래스 변수의 복잡한 초기화에 사용된다.
- **인스턴스 초기화 블럭** 인스턴스변수의 복잡한 초기화에 사용된다.

초기화 블럭을 작성하려면, 인스턴스 초기화 블럭은 단순히 클래스 내에 블럭{} 만들고 그 안에 코드를 작성하기만 하면 된다. 그리고 클래스 초기화 블럭은 인스턴스 초기화 블럭 앞에 단순히 static을 덧붙이기만 하면 된다.

```java
class Ex6_14 {
	static {
		System.out.println("static { }");
	}

	{
		System.out.println("{ }");
	}

	public Ex6_14() {
		System.out.println("생성자");
	}

	public static void main(String args[]) {
		System.out.println("Ex6_14 bt = new Ex6_14(); ");
		Ex6_14 bt = new Ex6_14();

		System.out.println("Ex6_14 bt2 = new Ex6_14(); ");
		Ex6_14 bt2 = new Ex6_14();
	}
}

// static { }
// Ex6_14 bt = new Ex6_14(); 
// { }
// 생성자
// Ex6_14 bt2 = new Ex6_14(); 
// { }
// 생성자
```

```java
class Ex6_15 {
	static int[] arr = new int[10];

	static {
		for(int i=0;i<arr.length;i++) {
			// 1과 10사이의 임의의 값을 배열 arr에 저장한다.
			arr[i] = (int)(Math.random()*10) + 1;
		}
	}

	public static void main(String args[]) {
		for(int i=0; i<arr.length;i++)
			System.out.println("arr["+i+"] :" + arr[i]);
	}
}

// arr[0] :3
// arr[1] :7
// arr[2] :4
// arr[3] :7
// arr[4] :2
// arr[5] :8
// arr[6] :2
// arr[7] :9
// arr[8] :1
// arr[9] :9
```

---