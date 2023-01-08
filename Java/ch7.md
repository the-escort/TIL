# 객체지향개념 II

## 상속

상속이란, 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것이다. 상속을 통해서 클래스를 작성하면 보다 적은 양의 코드로 새로운 클래스를 작성할 수 있고 코드를 공통적으로 관리할 수 있기 때문에 코드의 추가 및 변경이 매우 용이하다.

이러한 특징은 코드의 재사용성을 높이고 코드의 중복을 제거하여 프로그램의 생산성과 유지보수에 크게 기여한다.

자바에서 상속을 구현하는 방법은 아주 간단하다. 새로 작성하고자 하는 클래스의 이름 뒤에 상속받고자 하는 클래스의 이름을 키워드 'extends'와 함께 써 주기만 하면 된다.

```java
class Parent { }

class Child extends Parent {
    // ...
}
```

- **자손 클래스는 조상 클래스의 모든 멤버를 상속받는다.**

	**(단, 생성자와 초기화 블럭은 상속되지 않는다.)**

- **자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.**

```java
class Tv {
	boolean power; // 전원상태(on/off)
	int channel; // 채널

	void power()       {   power = !power; }
	void channelUp()   {   ++channel;      }
	void channelDown() {   --channel;      }
}

class SmartTv extends Tv { // CaptionTv는 Tv에 캡션(자막)을 보여주는 기능을 추가
	boolean caption; // 캡션상태(on/off)
	void displayCaption(String text) {
		if (caption) { // 캡션 상태가 on(true)일 때만 text를 보여 준다.
			System.out.println(text);
		}
	}
}

class Ex7_1 {
	public static void main(String args[]) {
		SmartTv stv = new SmartTv();
		stv.channel = 10; // 조상 클래스로부터 상속받은 멤버
		stv.channelUp(); // 조상 클래스로부터 상속받은 멤버
		System.out.println(stv.channel);
		stv.displayCaption("Hello, World");
		stv.caption = true;	// 캡션(자막) 기능을 켠다.	       
		stv.displayCaption("Hello, World");
	}
}

// 11
// Hello, World
```

---

## 클래스 간의 관계 - 포함관계

클래스 간의 포함관계를 맺어 주는 것은 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.

```java
class Circle {
    int x; // 원점의 x좌표
    int y; // 원점의 y좌표
    int r; // 반지름(radius)
}

	=

class Circle {
    Point c = new Point(); // 원점
    int r;
}
```

```java
class Car {
    Engine e = new Engine(); // 엔진
    Door[] d = new Door[4]; // 문, 문의 개수를 넷으로 가정하고 배열로 처리했다.
}
```

---

## 클래스 간의 관계 결정하기

클래스를 작성하는데 있어서 상속관계를 맺어 줄 것인지 포함관계를 맺어 줄 것인지 결정하는 것은 때때로 혼돈스러울 수 있다.

- 원(Circle)은 점(Point)**이다.** - Circle **is a** Point.
- 원(Circle)은 점(Point)을 **가지고 있다.** - Circle **has a** Point.

원은 원점(Point)과 반지름으로 구성되므로 위의 두 문장을 비교해 보면 첫 번째 문장보다 두번째 문장이 더 옳다는 것을 알 수 있을 것이다.

이처럼 클래스를 가지고 문장을 만들었을 때 '~은 ~이다.'라는 문장이 성립한다면, 서로 상속관계를 맺어 주고, '~은 ~을 가지고 있다.'는 문장이 성립한다면 포함관계를 맺어 주면 된다.

- **상속관계** '~은 ~이다.(is-a)'
- **포함관계** '~은 ~을 가지고 있다.(has-a)'

---

## 단일상속(single inheritance)

다중상속을 허용하면 여러 클래스로부터 상속받을 수 있기 때문에 복합적인 기능을 가진 클래스를 쉽게 작성할 수 있다는 장점이 있지만, 클래스간의 관계가 매우 복잡해진다는 것과 서로 다른 클래스로부터 상속받은 멤버간의 이름이 같은 경우 구별할 수 있는 방법이 없다는 단점을 가지고 있다.

---

## Object클래스 - 모든 클래스의 조상

Object클래스는 모든 클래스 상속계층도의 최상위에 있는 조상클래스이다. 다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로 Object클래스로부터 상속받게 함으로써 이것을 가능하게 한다.

---

## 오버라이딩(overriding)

조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것을 오버라이딩이라고 한다. 상속받은 메서드를 그대로 사용하기도 하지만, 자손 클래스 자신에 맞게 변경해야하는 경우가 많다.

```java
class Point {
    int x;
    int y;
    
    String getLocation() {
        return "x :" + x + ", y :" + y
    }
}

class Point3D extends Point {
    int z;

    String getLocation() { // 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
    }
}
```

---

## 오버라이딩의 조건

오버라이딩은 메서드의 내용만을 새로 작성하는 것이므로 메서드의 선언부(메서드 이름, 매개변수, 반환타입)는 조상의 것과 완전히 일치해야 한다.

1. **접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 었다.**

	대부분의 경우 같은 범위의 접근 제어자를 사용한다

2. **조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.**

- 조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때
	1. **선언부가 조상 클래스의 메서드와 일치해야 한다.**
	2. **접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.**
	3. **예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.**

---

## 오버로딩 vs. 오버라이딩

오버로딩은 기존에 없는 새로운 메서드를 추가하는 것이고, 오버라이딩은 조상으로부터 상속받은 메서드의 내용을 변경하는 것이다.

- **오버로딩(overloading)** 기존에 없는 새로운 메서드를 정의하는 것(new)
- **오버라이딩(overriding)** 상속받은 메서드의 내용을 변경한는 것(change, modify)

```java
class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    void parentMethod() {} // 오버라이딩
    void parentMethod(int i) {} // 오버로딩

    void childMethod() {}
    void childMethod(int i) {} // 오버로딩
    void childMethod() {} // 에러. 중복정의 되었음
}
```

---

## 참조변수 super

super는 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수이다. 멤버변수와 지역변수의 이름이 같을 때 this를 붙여서 구별했듯이 상속받은 멤버와 자신의 멤버와 이름이 같을 때는 super를 붙여서 구별할 수 있다.

```java
class Ex7_2 {
	public static void main(String args[]) {
		Child c = new Child();
		c.method();
	}
}

class Parent { int x=10; // super.x }

class Child extends Parent {
	int x=20; // this.x

	void method() {
		System.out.println("x=" + x);
		System.out.println("this.x=" + this.x);
		System.out.println("super.x="+ super.x);
	}
}

// x=20
// this.x=20
// super.x=10
```

---

## super() - 조상의 생성자

this()처럼 super()도 생성자이다. this()는 같은 클래스의 다른 생성자를 호출하는데 사용되지만, super()는 조상의 생성자를 호출하는데 사용된다.

```java
public class Ex7_4 {
	public static void main(String[] args) {
		Point3D p = new Point3D(1, 2, 3);
		System.out.println("x=" + p.x + ",y=" + p.y + ",z=" + p.z);
	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point {
	int z;

	Point3D(int x, int y, int z) {
		super(x, y); // Point(int x, int y)를 호출
		this.z = z;
	}
}

// x=1,y=2,z=3
```

---

## 제어자(modifiers)

제어자(modifier)는 클래스, 변수 또는 메서드의 선언부에 함께 사용되어 부가적인 의미를 부여한다. 제어자의 종류는 크게 접근 제어자와 그 외의 제어자로 나눌 수 있다.


- **접근 제어자** public, protected, default, private

- **그 외** static, final, abstract, ...

---

## static - 클래스의, 공통적인

static은 '클래스의' 또는 '공통적인'의 의미를 가지고 있다. 인스턴스 변수는 하나의 클래스로부터 생성되었더라도 각기 다른 값을 유지하지만, 클래스 변수(static멤버변수)는 인스턴스에 관계없이 같은 값을 갖는다.

static이 붙은 멤버변수와 메서드, 그리고 초기화 블럭은 인스턴스가 아닌 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 않고도 사용할 수 있다.

- **static이 사용될 수 있는 곳 - 멤버변수, 메서드, 초기화 블럭**

- static
  - 멤버변수
    - 모든 인스턴스에 공통적으로 사용되는 클래스변수가 된다.
    - 클래스변수는 인스턴스를 생성하지 않고도 사용 가능하다.
    - 클래스가 메모리에 로드될 때 생성된다.
  - 메서드
    - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.
    - static메서드 내에서는 인스턴스멤버들을 직접 사용할 수 없다.

```java
class StaticTest {
    static int width = 200; // 클래스 변수(static변수)
    static int height = 120; // 클래스 변수(static변수)

    static { // 클래스 초기화 블럭
        // static변수의 복잡한 초기화 수행
    }

    static int max(int a, int b) { // 클래스 메서드(static메서드)
        return a > b ? a : b;
    }
}
```

---

## final - 마지막의, 변경될 수 없는

변수에 사용되면 값을 변경할 수 없는 상수가 되며, 메서드에 사용되면 오버라이딩을 할 수 없게 되고 클래스에 사용되면 자신을 확장하는 자손클래스를 정의하지 못하게 한다.

- **final이 사용될 수 있는 곳 - 클래스, 메서드, 멤버변수, 지역변수**

- final
  - 클래스
    - 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.
  - 메서드
    - 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다.
  - 멤버변수
  - 지역변수
    - 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.

*final클래스의 대표적인 예는 String과 Math이다.

---

## abstract - 추상의, 미완성의

abstract는 '미완성'의 의미를 가지고 있다. 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는데 사용된다.

- **abstract가 사용될 수 있는 곳 - 클래스, 메서드**

- abstract
  - 클래스
    - 클래스 내에 추상메서드가 선언되어 있음을 의미한다.
  - 메서드
    - 선언부만 작성하고 구현부는 작성하지 않은 추상메서드임을 알린다.

```java
abstract class AbstractTest { // 추상 클래스(추상 메서드를 포함한 클래스)
    abstract void move(); // 추상 메서드(구현부가 없는 메서드)
}
```

추상 클래스는 아직 완성되지 않은 메서드가 존재하는 '미완성 설계도'이므로 인스턴스를 생성할 수 없다.

---

## 접근 제어자(access modifier)

접근 제어자는 멤버 또는 클래스에 사용되어, 해당하는 멤버 또는 클래스를 외부에서 접근하지 못하도록 제한하는 역할을 한다.


- **접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자**

	**private** 같은 클래스 내에서만 접근이 가능하다.  
	**(default)** 같은 패키지 내에서만 접근이 가능하다.  
	**protected** 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.  
	**public** 접근 제한이 전혀 없다.	

---

## 캡슐화와 접근 제어자

클래스나 멤버, 주로 멤버에 접근 제어자를 사용하는 이유는 클래스의 내부에 선언된 데이터를 보호하기 위해서이다. 데이터가 유효한 값을 유지하도록, 또는 비밀번호와 같은 데이터를 외부에서 함부로 변경하지 못하도록 하기 위해서는 외부로부터의 접근을 제한하는 것이 필요하다.

이것을 데이터 감추기(data hiding)라고 하며, 객체지향개념의 캡슐화(encapsulation)에 해당하는 내용이다.

- **접근 제어자를 사용하는 이유**
	- **외부로부터 데이터를 보호하기 위해서**
	- **외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서**

```java
public class Time {
	private int hour;
	private int minute;
	private int second;

	public int getHour() { return hour; }
	public void setHour(int hour) {
		if (hour < 0 || hour > 23) return;
		this.hour = hour;
	}

	public int getMinute() { return minute; }
	public void setMinute(int minute) {
		if (minute < 0 || minute > 59) return;
		this.minute = minute;
	}

	public int getSecond() { return second; }
	public void setSecond(int second) {
		if (second < 0 || second > 59) return;
		this.second = second;
	}
}
```

---

## 다형성(polymorphism)

다형성이란 '여러 가지 형태를 가질 수 있는 능력'을 의마하며, 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을 프로그램적으로 구현하였다.

```java
class Tv {
	boolean power; // 전원상태(on/off)
	int channel; // 채널

	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

class SmartTv extends Tv {
	String text; // 캡션(자막)을 보여 주기 위한 문자열
	void caption() { /* 내용생략 */}
}

SmartTv s = new SmartTv(); // 참조 변수와 인스턴스의 타입이 일치
Tv t = new SmartTv(); // 조상 타입 참조변수로 자손 타입 인스턴스 참조
```

**둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버의 개수가 달라진다.**

- **조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있다.**
- **반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수는 없다.**

---

## 참조변수의 형변환

기본형 변수처럼 참조변수도 형변환이 가능하다. 단, 서로 상속관계에 있는 클래스 사이에서만 가능하기 때문에 자손타입의 참조변수를 조상타입의 참조변수로, 조상타입의 참조변수를 자손타입의 참조변수로의 형변환만 가능하다.

- 서로 상속관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행될 수 있으나, **참조변수가 가리키는 인스턴스의 자손타입으로 형변환은 허용되지 않는다.**  
**그래서 참조변수가 가리키는 인스턴스의 타입이 무엇인지 먼저 확인하는 것이 중요하다.**

```java
class Ex7_7 {
	public static void main(String args[]) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;    // car = (Car)fe;에서 형변환이 생략됨
//		car.water();
		fe2 = (FireEngine)car; // 자손타입 ← 조상타입. 형변환 생략 불가
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { 	// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() {  	// 멈추는 기능	
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	// 소방차
	void water() {	// 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}

// water!!!
// water!!!
```

---

## instanceof 연산자

참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자를 사용한다. 주로 조건문에 사용되며, instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치한다. 그리고 연산의 결과로 boolean값인 true와 false 중의 하나를 반환한다.

```java
void doWork(Car c) {
	if (c instanceof FireEngine) { // 1. 형변환이 가능한지 확인
		FireEngine fe = (FireEngine)c; // 2. 형변환
		fe.water();
		...
	}
}
```

- **어떤 타입에 대한 instanceof 연산의 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.**

---

## 매개변수의 다형성

참조변수의 다형적인 특징은 메서드의 매개변수에도 적용된다.

```java
class Product {
	int price; // 제품의 가격
	int bonusPoint;	// 제품구매 시 제공하는 보너스점수

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);	// 보너스점수는 제품가격의 10%
	}
}

class Tv1 extends Product {
	Tv1() {
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);	// Tv의 가격을 100만원으로 한다.
	}

	// Object클래스의 toString()을 오버라이딩한다.
	public String toString() { return "Tv"; }
}

class Computer extends Product {
	Computer() { super(200); }

	public String toString() { return "Computer"; }
}

class Buyer { // 고객, 물건을 사는 사람
	int money = 1000; // 소유금액
	int bonusPoint = 0; // 보너스점수

	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}

class Ex7_8 {
	public static void main(String args[]) {
		Buyer b = new Buyer();

		b.buy(new Tv1());
		b.buy(new Computer());

		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
	}
}

// Tv을/를 구입하셨습니다.
// Computer을/를 구입하셨습니다.
// 현재 남은 돈은 700만원입니다.
// 현재 보너스점수는 30점입니다.
```

---

## 여러 종류의 객체를 배열로 다루기

조상타입의 참조변수 배열을 사용하면, 공통의 조상을 가진 서로 다른 종류의 객체를 배열로 묶어서 다룰 수 있다. 또는 묶어서 다루고싶은 객체들의 상속관계를 따져서 가장 가까운 공통조상 클래스 타입의 참조변수 배열을 생성해서 객체들을 저장하면 된다.

```java
Product p1 = new Tv();
Product p2 = new Computer();
Product p3 = new Audio();

    =

Product p[] = new Product[3];
p[0] = new Tv();
p[1] = new Computer();
p[2] = new Audio();
```

```java
class Product2 {
	int price; // 제품의 가격
	int bonusPoint;	// 제품구매 시 제공하는 보너스점수

	Product2(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}

	Product2() {} // 기본 생성자
}

class Tv2 extends Product2 {
	Tv2() {  super(100);	 }

	public String toString() { return "Tv"; }
}

class Computer2 extends Product2 {
	Computer2() { super(200); }
	public String toString() { return "Computer"; }
}

class Audio2 extends Product2 {
	Audio2() { super(50); }
	public String toString() { return "Audio"; }
}

class Buyer2 { // 고객, 물건을 사는 사람
	int money = 1000; // 소유금액
	int bonusPoint = 0; // 보너스점수
	Product2[] cart = new Product2[10];   // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product배열에 사용될 카운터

	void buy(Product2 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
		cart[i++] = p; // 제품을 Product[] cart에 저장한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}

	void summary() { // 구매한 물품에 대한 정보를 요약해서 보여 준다.
		int sum = 0; // 구입한 물품의 가격합계
		String itemList = ""; // 구입한 물품목록

		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0; i<cart.length;i++) {
			if(cart[i]==null) break;
			sum += cart[i].price;
			itemList += cart[i] + ", ";
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}

class Ex7_9 {
	public static void main(String args[]) {
		Buyer2 b = new Buyer2();

		b.buy(new Tv2());
		b.buy(new Computer2());
		b.buy(new Audio2());
		b.summary();
	}
}

// Tv을/를 구입하셨습니다.
// Computer을/를 구입하셨습니다.
// Audio을/를 구입하셨습니다.
// 구입하신 물품의 총금액은 350만원입니다.
// 구입하신 제품은 Tv, Computer, Audio, 입니다.
```

---

## 추상클래스(abstract class)

클래스를 설계도에 비유한다면, 추상 클래스는 미완성 설계도에 비유할 수 있다.

클래스가 미완성이라는 것은 멤버의 개수에 관계된 것이 아니라, 단지 미완성 메서드(추상 메서드)를 포함하고 있다는 의미이다.

- **추상 클래스** 
	- 미완성 설계도. 인스턴스 생성불가.
	- 미완성 메서드(추상 메서드)를 포함하고 있는 클래스

```java
abstract class 클래스이름 {
	...
}
```
추상 클래스는 추상 메서드를 포함하고 있다는 것을 제외하고는 일반 클래스와 전혀 다르지 않다. 추상 클래스에도 생성자가 있으며, 멤버변수와 메서드도 가질 수 있다.

---

## 추상 메서드(abstract method)

선언부만 작성하고 구현부는 작성하지 않은 채로 남겨 둔 것이 추상메서드이다.

메서드를 이와 같이 미완성 상태로 남겨 놓는 이유는 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문에 조상 클래스에서는 선언부만을 작성하고, 주석을 덧붙여 어떤 기능을 수행할 목적으로 작성되었는지 알려 주고, 실제 내용은 상속받는 클래스에서 구현하도록 비워 두는 것이다. 그래서 추상클래스를 상속받는 자손 클래스는 조상의 추상메서드를 상황에 맞게 적절히 구현해주어야 한다.

```java
/* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
abstract 리턴타입 메서드이름();
```

추상클래스로부터 상속받는 자손클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 모두 구현해주어야 한다. 만일 조상으로부터 상속받은 추상메서드 중 하나라도 구현하지 않는다면, 자손클래스 역시 추상클래스로 지정해 주어야 한다.

```java
abstract class Player { // 추상클래스
    abstract void play(int pos); // 추상메서드
    abstract void stop(); // 추상메서드
}

class AudioPlayer extends Player {
    void play(int pos) { // } // 추상메서드를 구현
    void stop() { // } // 추상메서드를 구현
}

abstract class AbstractPlayer extends Player {
    void play(int pos) { // }
}
```

---

## 추상클래스의 작성

여러 클래스에 공통적으로 사용될 수 있는 클래스를 바로 작성하기도 하고, 기존의 클래스의 공통적인 부분을 뽑아서 추상클래스로 만들어 상속하도록 하는 경우가 있다.

상속이 자손 클래스를 만드는데 조상 클래스를 사용하는 것이라면, 이와 반대로 추상화는 기존의 클래스의 공통부분을 뽑아내서 조상 클래스를 만드는 것이라고 할 수 있다.

```java
public class Ex7_10 {
	public static void main(String[] args) {
		Unit[] group = { new Marine(), new Tank(), new Dropship() };

		for (int i = 0; i < group.length; i++)
			group[i].move(100, 200);
	}
}

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() { /* 현재 위치에 정지 */ }
}

class Marine extends Unit { // 보병
	void move(int x, int y) {
		System.out.println("Marine[x=" + x + ",y=" + y + "]");
	}
	void stimPack() { /* 스팀팩을 사용한다. */ }
}

class Tank extends Unit { // 탱크
	void move(int x, int y) {
		System.out.println("Tank[x=" + x + ",y=" + y + "]");
	}
	void changeMode() { /* 공격모드를 변환한다. */ }
}

class Dropship extends Unit { // 수송선
	void move(int x, int y) {
		System.out.println("Dropship[x=" + x + ",y=" + y + "]");
	}
	void load()   { /* 선택된 대상을 태운다. */ }
	void unload() { /* 선택된 대상을 내린다. */ }
}

// Marine[x=100,y=200]
// Tank[x=100,y=200]
// Dropship[x=100,y=200]
```

---

## 인터페이스(interface)
 
인터페이스는 일종의 추상클래스이다.

추상클래스를 부분적으로만 완성된 '미완성 설계도'라고 한다면, 인터페이스는 구현된 것은 아무 것도 없고 밑그림만 그려져 있는 '기본 설계도'라 할 수 있다.

인터페이스도 추상클래스처럼 완성되지 않은 불완전한 것이기 때문에 그 자체만으로 사용되기 보다는 다른 클래스를 작성하는데 도움 줄 목적으로 작성된다.

```java
interface 인터페이스이름 {
	public static final 타입 상수이름 = 값;
	public abstract 메서드이름(매개변수목록);
}
```

- **모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.**
- **모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다.**

```java
interface PlayingCard {
    public static final int SPADE = 4;
    final int DIAMOND = 3; // public static final int DIAMOND = 3;
    static int HEART = 2; // public static final int HEART = 2;
    int CLOVER = 1; // public static final int CLOVER = 1;

    public abstract String getCardNumber();
    String getCardKind(); // public abstract String getCardKind();
}
```

---

## 인터페이스의 상속

인터페이스는 인터페이스로부터만 상속받을 수 있으며, 클래스와는 달리 다중상속, 즉 여러개의 인터페이스로부터 상속을 받는 것이 가능하다.

```java
interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable {}
```

---

## 인터페이스의 구현

인터페이스도 추상클래스처럼 그 자체로는 인스턴스를 생성할 수 없으며, 추상클래스가 상속을 통해 추상메서드를 완성하는 것처럼, 인터페이스도 자신에 정의된 추상메서드의 몸통을 만들어주는 클래스를 작성해야 하는데, 그 방법은 추상클래스가 자신을 상속받는 클래스를 정의하는 것과 다르지 않다. 다만 클래스는 확장한다는 의미의 키워드 'extends'를 사용하지만 인터페이스는 구현한다는 의미의 키워드 'implements'를 사용할 뿐이다.

```java
class 클래스이름 implements 인터페이스이름 {
	// 인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
}
```

---

## 인터페이스를 이용한 다형성

인터페이스 역시 이를 구현한 클래스의 조상이라 할 수 있으므로 해당 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있으며, 인터페이스 타입으로의 형변환도 가능하다.

**리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다. 이 문장은 외울 때까지 반복해서 읽어야 한다.**

---

## 인터페이스의 장점

- **개발시간을 단축시킬 수 있다.**
- **표준화가 가능하다.**
- **서로 관계업슨 클래스들에게 관계를 맺어 줄 수 있다.**
- **독립적인 프로그래밍이 가능하다.**

---

## 디폴트 메서드와 static메서드

디폴트 메서드는 추상 메서드의 기본적인 구현을 제공하는 메서드로, 추상 메서드가 아니기 때문에 디폴트 메서드가 새로 추가되어도 해당 인터페이스를 구현한 클래스를 변경하지 않아도 된다.

디폴트 메서드는 앞에 키워드 default를 붙이며, 추상 메서드와 달리 일반 메서드처럼 몸통{}이 있어야 한다. 디폴트 메서드 역시 접근 제어자가 public이며, 생략가능하다.

1. **여러 인터페이스의 디폴트 메서드 간의 충돌**
	- 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩해야 한다.
2. **디폴트 메서드와 조상 클래스의 메서드 간의 충돌**
	- 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.

```java
class Ex7_11 {
	public static void main(String[] args) {
		Child3 c = new Child3();
		c.method1();
		c.method2();
		MyInterface.staticMethod(); 
		MyInterface2.staticMethod();
	}
}

class Child3 extends Parent3 implements MyInterface, MyInterface2 {
	public void method1() {	
		System.out.println("method1() in Child3"); // 오버라이딩
	}			
}

class Parent3 {
	public void method2() {	
		System.out.println("method2() in Parent3");
	}
}

interface MyInterface {
	default void method1() { 
		System.out.println("method1() in MyInterface");
	}

	default void method2() { 
		System.out.println("method2() in MyInterface");
	}

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface");
	}
}

interface MyInterface2 {
	default void method1() { 
		System.out.println("method1() in MyInterface2");
	}

	static void staticMethod() { 
		System.out.println("staticMethod() in MyInterface2");
	}
}

// method1() in Child3
// method2() in Parent3
// staticMethod() in MyInterface
// staticMethod() in MyInterface2
```

---

## 내부 클래스(inner class)

내부 클래스는 클래스 내에 선언된 클래스이다. 클래스에 다른 클래스를 선언하는 이유는 간단하다. 두 클래스가 서로 긴밀한 관계에 있기 때문이다.
한 클래스를 다른 클래스의 내부 클래스로 선언하면 두 클래스의 멤버들 간에 서로 쉽게 접근할 수 있다는 장점과 외부에는 불필요한 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다는 장점을 얻을 수 있다.

- **내부 클래스의 장점**
  - **내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.**
  - **코드의 복잡성을 줄일 수 있다.(캡슐화)**

```java
class A { // 외부 클래스
	...
	class B { // 내부 클래스
		...
	}
	...
}
```

---

## 내부 클래스의 종류와 특징

내부 클래스의 종류는 변수의 선언위치에 따른 종류와 같다.

|내부 클래스|특징|
|:---:|:---:|
|인스턴스 클래스|외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 인스턴스멤버처럼 다루어진다. 주로 외부 클래스의 인스턴스멤버들과 관련된 작업에 사용될 목적으로 선언된다.|
|스태틱 클래스|외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 static멤버처럼 다루어진다. 주로 외부 클래스의 static멤버, 특히 static메서드에서 사용될 목적으로 선언된다.|
|지역 클래스|외부 클래스의 메서드나 초기화블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있다.|
|익명 클래스|클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용)|

---

## 내부 클래스의 선언

변수가 선언된 위치에 따라 인스턴스 변수, 클래스 변수(static변수), 지역변수로 나뉘듯이 내부 클래스도 이와 마찬가지로 선언된 위치에 따라 나뉜다. 그리고, 각 내부 클래스의 선언위치에 따라 같은 선언위치의 변수와 동일한 유효범위(scope)와 접근성(accessibility)을 갖는다.

```java
class Outer {
	class InstanceInner {}
	static class StaticInner {}

	void myMethod() {
		class LocalInner {}
	}
}
```

---

## 내부 클래스의 제어자와 접근성

인스턴스클래스(InstanceInner)와 스태틱 클래스(StaticInner)는 외부 클래스(Outer)의 멤버변수(인스턴스 변수와 클래스 변수)와 같은 위치에 선언되며, 또한 멤버변수와 같은 성질을 갖는다. 따라서 내부 클래스가 외부 클래스의 멤버와 같이 간주되고, 인스턴스멤버와 static멤버 간의 규칙이 내부 클래스에도 똑같이 적용된다.

```java
class Outer {
	private class InstanceInner {}
	protected static class StaticInner {}

	void myMethod() {
		class LocalInner {}
	}
}
```

---