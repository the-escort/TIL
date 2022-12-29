# 배열

## 배열이란?

같은 타입의 여러 변수를 하나의 묶음으로 다루는 것을 '배열(array)이라고 한다.

- **"배열은 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것"**

---

## 배열의 선언과 생성

원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 대괄호[]를 붙이면 된다. 

### 배열의 생성

배열을 선언하는 것은 단지 생성된 배열을 다루기 위한 참조변수를 다루기 위한 참조변수를 위한 공간이 만들어질 뿐이고, 배열을 생성해야만 비로소 값을 저장할 수 잇는 공간이 만들어지는 것이다. 배열을 생성하기 위해서는 연산자 'new'와 함께 배열의 타입과 길이를 지정해 주어야 한다.

- **타입[] 변수이름;** // 배열을 선언(배열을 다루기 위한 참조변수 선언)
- **변수이름 = new 타입[길이];** // 배열을 생성(실제 저장공간을 생성)

---

## 배열의 인덱스

생성된 배열의 각 저장공간을 '배열의 요소(element)'라고 하며, '배열이름[인덱스]'의 형식으로 배열의 요소에 접근한다. **인덱스(index)는 배열의 요소마다 붙여진 일련번호**로 각 요소를 구별하는데 사용된다.

- **"인덱스(index)"의 범위는 0부터 '배열길이 -1'까지.**

---

## 배열의 길이(배열이름.length)

배열은 한번 생성하면 길이를 변경할 수 없기 때문에, 이미 생성된 배열의 길이는 변하지 않는다. 따라서 '배열이름.length'는 상수다. 즉, 값을 읽을 수만 있을 뿐 변경할 수 없다.

'배열이름.length'는 배열의 길이가 변경되면 자동적으로 변경된 배열의 길이를 값으로 갖기 때문에, 배열과 함께 사용되는 for문의 조건식을 일일이 변경해주지 않아도 된다.

---

## 배열의 초기화

q배열은 생성과 동시에 자동적으로 기본값(0)으로 초기화되므로 배열을 사용하기 전에 따로 초기화를 해주지 않아도 되지만, 원하는 값을 저장하려면 아래와 같이 각 요소마다 값을 지정해 줘야한다.

```java
int[] score = new int[] {50, 60, 70, 80, 90}; // 배열의 생성과 초기화를 동시에
```

```java
int[] score = new int[] {50, 60, 70, 80, 90};
int[] score = {50, 60, 70, 80, 90}; // new int[]를 생략할 수 있음
```

```java
int[] score;
score = {50, 60, 70, 80, 90} // 에러. new int[]를 생략할 수 없음
score = new int[] {50, 60, 70, 80, 90}; // OK
```

---

## 배열의 출력

```java
int[] iArr = {100, 95, 80, 70, 60};
System.our.println(Arrays.toString(iArr)); // 배열 iArr의 모든 요소를 출력한다. [100, 95, 80, 70, 60]이 출력된다.
```

예외적으로 char배열은 println메서드로 출력하면 각 요소가 구분자 없이 그대로 출력되는데, 이것은 println메서드가 char배열일 때만 이렇게 동작하도록 작성되었기 때문이다.

```java
char[] chArr = {'a', 'b', 'c', 'd'};
System.our.println(chArr); // abcd가 출력된다.
```

```java
import java.util.Arrays;  // Arrays.toString()을 사용하기 위해 추가

class Ex5_1 {
	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
//		int[] iArr3 = new int[]{100, 95, 80, 70, 60};
		int[] iArr3 = {100, 95, 80, 70, 60};
		char[] chArr = {'a', 'b', 'c', 'd'};

		for (int i=0; i < iArr1.length ; i++ ) {
			iArr1[i] = i + 1; // 1~10의 숫자를 순서대로 배열에 넣는다.
		}

		for (int i=0; i < iArr2.length ; i++ ) {
			iArr2[i] = (int)(Math.random()*10) + 1; // 1~10의 값을 배열에 저장
		}

		// 배열에 저장된 값들을 출력한다.
		for(int i=0; i < iArr1.length;i++) {
			System.out.print(iArr1[i]+",");	
		}
		System.out.println();

		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));
		System.out.println(iArr3);
		System.out.println(chArr);
	}
}

// 1,2,3,4,5,6,7,8,9,10,
// [6, 10, 2, 1, 3, 7, 9, 5, 8, 9]
// [100, 95, 80, 70, 60]
// [a, b, c, d]
// [I@6996db8
// abcd
```

---

## 배열의 활용 - 총합과 평균

```java
class Ex5_2 {
	public static void main(String[] args) {
		int   sum = 0;      // 총점을 저장하기 위한 변수
		float average = 0f; // 평균을 저장하기 위한 변수

		int[] score = {100, 88, 100, 100, 90};

		for (int i=0; i < score.length ; i++ ) {
			sum += score[i];
		}
		average = sum / (float)score.length ; // 계산결과를 float로 얻기 위해서 형변환

		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);
	}
}

// 총점 : 478
// 평균 : 95.6
```

478 / 5 -> **95**

478 / (float)5 -> 478 / 5.0f -> 478.0f / 5.0f -> **95.6f**

---

## 배열의 활용 - 최대값과 최소값

```java
import java.util.Arrays;

class Ex5_3 { 
	public static void main(String[] args) { 
		int[] score = { 79, 88, 91, 33, 100, 55, 95 }; 
		
		System.out.println(Arrays.binarySearch(score, 33));

		int max = score[0]; // 배열의 첫 번째 값으로 최대값을 초기화 한다. 
		int min = score[0]; // 배열의 첫 번째 값으로 최소값을 초기화 한다. 

		for(int i=1; i < score.length;i++) {
			if(score[i] > max) { 
				max = score[i]; 
			} else if(score[i] < min) { 
				min = score[i]; 
			} 
		} // end of for 

		System.out.println("최대값 :" + max);       
		System.out.println("최소값 :" + min);       
	} // end of main 
} // end of class

// 3
// 최대값 :100
// 최소값 :33
```

---

## 배열의 활용 - 섞기(shuffle)

```java
import java.util.Arrays;

class Ex5_4 {
	public static void main(String[] args) {
		int[] numArr = {0,1,2,3,4,4,5,6,7,8,9};
		System.out.println(Arrays.toString(numArr));

		for (int i=0; i < 100; i++ ) {
			int n = (int)(Math.random() * 10);  // 0~9 중의 한 값을 임의로 얻는다.
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		System.out.println(Arrays.toString(numArr));
	} // main의 끝
}

// [0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9]
// [4, 2, 8, 1, 0, 5, 4, 7, 6, 3, 9]
```

---


## 배열의 활용 - 로또 번호 만들기

```java
class Ex5_5 { 
	public static void main(String[] args) { 
		int[] ball = new int[45];  // 45개의 정수값을 저장하기 위한 배열 생성.      

		// 배열의 각 요소에 1~45의 값을 저장한다. 
		for(int i=0; i < ball.length; i++)       
			ball[i] = i+1;    // ball[0]에 1이 저장된다.

		int tmp = 0;   // 두 값을 바꾸는데 사용할 임시변수 
		int j = 0;     // 임의의 값을 얻어서 저장할 변수 

		// 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다. 
		// 0번째 부터 5번째 요소까지 모두 6개만 바꾼다.
		for(int i=0; i < 6; i++) {       
			j = (int)(Math.random() * 45); // 0~44범위의 임의의 값을 얻는다. 
			tmp     = ball[i]; 
			ball[i] = ball[j]; 
			ball[j] = tmp; 
		} 

		// 배열 ball의 앞에서 부터 6개의 요소를 출력한다.
		for(int i=0; i < 6; i++) 
			System.out.printf("ball[%d]=%d%n", i, ball[i]); 
	} 
}

// ball[0]=15
// ball[1]=34
// ball[2]=42
// ball[3]=6
// ball[4]=27
// ball[5]=35
```

---

## String배열의 선언과 생성

```java
String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
```

참고로 변수의 타입에 따른 기본값은 다음과 같다.

|자료형|기본값|
|:---:|:---:|
|char|'\u000'|
|byte, short, int|0|
|long|0L|
|float|0.0f|
|double|0.0d 또는 0.0|
|참조형|null|

---

## String배열의 초기화

초기화 역시 int배열과 동일한 방법으로 한다.

```java
class Ex5_6 {
	public static void main(String[] args) {
		String[] names = {"Kim", "Park", "Yi"};

		for(int i=0; i < names.length;i++)
			System.out.println("names["+i+"]:"+names[i]);

		String tmp = names[2]; // 배열 names의 세 번째요소를 tmp에 저장
		System.out.println("tmp:"+tmp);
		names[0] = "Yu"; // 배열 names의 첫 번째 요소를 "Yu"로 변경

		for(int i=0; i < names.length;i++)
			System.out.println(names[i]);
	} // main
}

// names[0]:Kim
// names[1]:Park
// names[2]:Yi
// tmp:Yi
// Yu
// Park
// Yi
```

---

## String클래스

- **String클래스는 char배열에 기능(메서드)을 추가한 것이다.**

char배열과 String클래스의 한 가지 중요한 차이가 있는데, String객체(문자열)는 읽을 수만 있을 뿐 내용을 변경할 수 없다는 것이다.

```java
String str = "Java";
str = str + "8"; // "Java8"이라는 새로운 문자열이 str에 저장된다.
System.out.println(str); "Java8"
```

---

## String클래스의 주요 메서드

```java
char charAt(int index)
// 문자열에서 해당 위치(index)에 있는 문자를 반환한다.

int length()
// 문자열의 길이를 반환한다.

String substring(int from, int to)
// 문자열에서 해당 범위(from~to)의 문자열을 반환한다.(to는 포함 안 됨)

boolean equals(Object obj)
// 문자열의 내용이 같은지 확인한다. 같으면 결과는 true. 다르면 false

char[] toCharArray()
// 문자열을 문자배열(char[])로 변환해서 반환한다.
```

---

## 2차원 배열의 선언

2차원 배열을 선언하는 방법은 1차원 배열과 같다. 다만 대괄호[]가 하나 더 들어갈 뿐이다.

|선언 방법|선언 예|
|:---:|:---:|
|타입[][] 변수이름;|int[][] score;|
|타입 변수이름[][];|int score[][];|
|타입[] 변수이름[];|int[] score[];|

---

## 2차원 배열의 인덱스

2차원 배열을 행(row)과 열(column)로 구성되어 있기 때문에 index도 행과 열에 각각 하나씩 존재한다. '행index'의 범위는 '0 ~ 행의 길이 -1'이고 '열index'의 범위는 '0 ~ 열의 길이 -1'이다. 그리고 2차원 배열의 각 요소에 접근하는 방법은 '배열이름[행index][열index]'이다.

---

## 2차원 배열의 초기화

```java
class Ex5_9 {
	public static void main(String[] args) {
		 int[][] score = {
							  { 100, 100, 100}
							, { 20, 20, 20}
							, { 30, 30, 30}
							, { 40, 40, 40}
							, { 50, 50, 50}
						};
		// 과목별 총점
		int korTotal = 0, engTotal = 0, mathTotal = 0;

	    System.out.println("번호  국어  영어  수학  총점  평균 ");
	    System.out.println("=============================");

		for(int i=0;i < score.length;i++) {
			int  sum = 0;      // 개인별 총점
			float avg = 0.0f;  // 개인별 평균

			korTotal  += score[i][0];
			engTotal  += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%3d", i+1);

			for(int j=0;j < score[i].length;j++) {
				sum += score[i][j]; 
				System.out.printf("%5d", score[i][j]);
			}

			avg = sum/(float)score[i].length;  // 평균계산
			System.out.printf("%5d %5.1f%n", sum, avg);
		}

		System.out.println("=============================");
     	System.out.printf("총점:%3d %4d %4d%n", korTotal, engTotal, mathTotal);
	}
}

// =============================
//   1  100  100  100  300 100.0
//   2   20   20   20   60  20.0
//   3   30   30   30   90  30.0
//   4   40   40   40  120  40.0
//   5   50   50   50  150  50.0
// =============================
// 총점:240  240  240
```

```java
import java.util.Scanner;

class Ex5_10{
	public static void main(String[] args) {
		String[][] words = {
			{"chair","의자"},      	// words[0][0], words[0][1]
			{"computer","컴퓨터"}, 	// words[1][0], words[1][1]
			{"integer","정수"}     	// words[2][0], words[2][1]
		};

		Scanner scanner = new Scanner(System.in);

		for(int i=0;i<words.length;i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);

			String tmp = scanner.nextLine();

			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
			} else {
			   System.out.printf("틀렸습니다. 정답은 %s입니다.%n%n",words[i][1]);
			}
		} // for
	} // main의 끝
}

// Q1. chair의 뜻은? dmlwk
// 틀렸습니다. 정답은 의자입니다.

// Q2. computer의 뜻은?컴퓨터
// 정답입니다.

// Q3. integer의 뜻은?정수
// 정답입니다.
```

---