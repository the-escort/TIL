# 조건문과 반복문

## if문

프로그램의 흐름(flow)을 바꾸는 역할을 하는 문장들을 '제어문(control statement)'이라고 한다. 제어문에는 '조건문과 반복문'이 있는데, 조건문은 조건에 따라 다른 문장이 수행되도록 하고, 반복문은 특정 문장들을 반복해서 수행한다.

if문은 가장 기본적인 조건문이며, 다음과 같이 '조건식'과 '괄호{}'로 이루어져 있다. 'if'의 뜻이 '만일 ~이라면...'이므로 **'만일(if) 조건식이 참(true)이면 괄호{} 안의 문장들을 수행하라.'** 라는 의미로 이해하면 된다.

---

## 조건식의 다양한 예

```java
90 <= x && x <= 100 // 정수 x가 90이상 100이하일 때

x < 0 || x > 100 // 정수 x가 0보다 작거나 100보다 클 때

x%3 == 0 && x%2 != 0 // 정수 x가 3의 배수지만, 2의 배수는 아닐 때

ch == 'y' || ch == 'Y' // 문자 ch가 'y' 또는 'Y'일 때

ch == ' ' || ch == '\t' || ch == '\n' // 문자 ch가 공백이거나 탭 또는 개행 문자일 때

'A' <= ch && ch <= 'Z' // 문자 ch가 대문자일 때

'a' <= ch && ch <= 'z' // 문자 ch가 소문자일 때

'0' <= ch && ch <= '9' // 문자 ch가 숫자일 때

str.equals("yes") // 문자열 str의 내용이 "yes"일 때(대소문자 구분)

str.equalsIgnoreCase("yes") // 문자열 str의 내용이 "yes"일 때(대소문자 구분안함)
```

---

## 블럭{}

괄호{}를 이용해서 여러 문장을 하나의 단위로 묶을 수 있는데, 이것을 '블럭(block)'이라고 한다.

블럭 안에는 보통 여러 문장을 넣지만, 한 문장만 넣거나 아무런 문장도 넣지 않을 수 있다. 만일 블럭 내의 문장이 하나뿐일 때는 아래와 같이 괄호{}를 생략할 수 있다.

```java
if (score > 60)
    System.out.println("합격입니다.");
```

---

## if-else문

'else'의 뜻이 '그 밖의 다른'이므로 조건식의 결과가 참이 아닐 때, 즉 거짓일 떄 else블럭의 문장을 수행하라는 뜻이다.

```java
import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가

class Ex4_3 {
	public static void main(String[] args) {  
		System.out.print("숫자를 하나 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt(); // 화면을 통해 입력받은 숫자를 input에 저장

		if(input==0) {
			System.out.println("입력하신 숫자는 0입니다.");	
		} else { // input!=0인 경우
			System.out.println("입력하신 숫자는 0이 아닙니다.");
		}
	} // main의 끝
}

// 숫자를 하나 입력하세요.>5
// 입력하신 숫자는 0이 아닙니다.

// 숫자를 하나 입력하세요.>0
// 입력하신 숫자는 0입니다.
```

---

## if-else if문

```java
import java.util.Scanner;

class Ex4_4 {
	public static void main(String[] args) { 
		int score  = 0;   // 점수를 저장하기 위한 변수
		char grade =' ';  // 학점을 저장하기 위한 변수. 공백으로 초기화한다.

		System.out.print("점수를 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt(); // 화면을 통해 입력받은 숫자를 score에 저장

		if (score >= 90) {         // score가 90점 보다 같거나 크면 A학점
			 grade = 'A';             
		} else if (score >=80) {   // score가 80점 보다 같거나 크면 B학점 
			 grade = 'B'; 
		} else if (score >=70) {   // score가 70점 보다 같거나 크면 C학점 
			 grade = 'C'; 
		} else {                   // 나머지는 D학점
			 grade = 'D'; 
		}
		System.out.println("당신의 학점은 "+ grade +"입니다.");
	}
}

// 점수를 입력하세요.>70
// 당신의 학점은 C입니다.

// 점수를 입력하세요.>63
// 당신의 학점은 D입니다.
```

---

## 중첩 if문

if문의 블럭 내에 또 다른 if문을 포함시키는 것이 가능한데 이것을 중첩 if문이라고 부르며 중첩의 횟수에는 거의 제한이 없다.

```java
import java.util.Scanner;

class Ex4_5 {
	public static void main(String[] args) { 
		int  score = 0;
		char grade = ' ', opt = '0';

		System.out.print("점수를 입력해주세요.>");

		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt(); // 화면을 통해 입력받은 점수를 score에 저장

		System.out.printf("당신의 점수는 %d입니다.%n", score);

		if (score >= 90) {           // score가 90점 보다 같거나 크면 A학점(grade)
			grade = 'A';
			if (score >= 98) {        // 90점 이상 중에서도 98점 이상은 A+
				opt = '+';	
			} else if (score < 94) {  // 90점 이상 94점 미만은 A-
				opt = '-';
			}
		} else if (score >= 80){     // score가 80점 보다 같거나 크면 B학점(grade)
			grade = 'B';
			if (score >= 88) {
				opt = '+';
			} else if (score < 84)	{
				opt = '-';
			}
		} else {                     // 나머지는 C학점(grade)
			grade = 'C';
		}	
		System.out.printf("당신의 학점은 %c%c입니다.%n", grade, opt);
	}
}

// 점수를 입력해주세요.>81
// 당신의 점수는 81입니다.
// 당신의 학점은 B-입니다.

// 점수를 입력해주세요.>85
// 당신의 점수는 85입니다.
// 당신의 학점은 B0입니다.

// 점수를 입력해주세요.>100
// 당신의 점수는 100입니다.
// 당신의 학점은 A+입니다.
```

---

## switch문

if문은 조건식의 결과가 참과 거짓, 두 가지 밖에 없기 때문에 경우의 수가 많아질수록 else-if를 계속 추가해야 하므로 조건식이 많아져서 복잡해지고, 여러 개의 조건식을 계산해야 하므로 처리시간도 많이 걸린다.

이러한 if문과 달리 switch문은 단 하나의 조건식으로 많은 경우의 수를 처리할 수 있고, 표현도 간결하므로 알아보기 쉽다. 그래서 처리할 경우의 수가 많은 경우에는 if문 보다 switch문으로 작성하는 것이 좋다. 다만 switch문은 제약조건이 있기 때문에, 경우의 수가 많아도 어쩔 수 없이 if문으로 작성해야 하는 경우가 있다.

switch문은 조건식을 먼저 계산한 다음, 그 결과와 일치하는 case문으로 이동한다. 이동한 case문 아래에 있는 문장들을 수행하며, break문을 만나면 전체 switch문을 빠져나가게 된다.

---

## switch문의 제약조건

switch문의 조건식은 결과값이 반드시 정수이어야 하며, 이 값과 일치하는 case문으로 이동하기 떄문에 case문의 값 역시 정수이어야 한다. 그리고 중복되지 않아야 한다.

게다가 case문의 값은 반드시 상수이어야 한다. 변수나 실수는 case문의 값으로 사용할 수 없다.

- **switch문의 제약조건**
  1. switch문의 조건식 결과는 정수 또는 문자열이어야 한다.
  2. case문의 값은 정수 상수(문자 포함), 문자열만 가능하며, 중복되지 않아야 한다.

```java
import java.util.Scanner;

class Ex4_6 {
	public static void main(String[] args) { 
		System.out.print("현재 월을 입력하세요.>");

		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();  // 화면을 통해 입력받은 숫자를 month에 저장

		switch(month) {
			case 3: 
			case 4:  // case문은 한 줄에 하나씩 쓰던, 한 줄에 붙여서 쓰던 상관없다.
			case 5:
				System.out.println("현재의 계절은 봄입니다.");
				break;
			case 6: case 7: case 8:
				System.out.println("현재의 계절은 여름입니다.");
				break;
			case 9: case 10: case 11:
				System.out.println("현재의 계절은 가을입니다.");
				break;
			default:
	//		case 12:	case 1: case 2:
				System.out.println("현재의 계절은 겨울입니다.");
		}
	} // main의 끝
}

// 현재 월을 입력하세요.>3
// 현재의 계절은 봄입니다.
```

---

## 임의의 정수만들기 Math.random()

난수(임의의 수)를 얻기 위해서는 Math.random()을 사용해야 하는데, 이 메서드는 0.0과 1.0사이의 범위에 속하는 하나의 double값을 반환한다. 0.0은 범위에 포함되고 1.0은 포함되지 않는다.

```java
class Ex4_7 {
	public static void main(String args[]) {
		int num = 0;

		// 괄호{} 안의 내용을 5번 반복한다.
		for (int i = 1; i <= 5; i++) {
			num = (int) (Math.random() * 6) + 1;
			System.out.println(num);
		}
	}
}
```

---

## for문

반복문은 어떤 작업이 반복적으로 수행되도록 할 때 사용되며, 반복문의 종류로는 for문과 while문, 그리고 while문의 변형인 do-while문이 있다.

for문과 while문은 구조와 기능이 유사하여 어느 경우에나 서로 변환이 가능하며, 반복 횟수를 알고 있을 때는 for문을, 그렇치 않을 때는 while문을 사용한다.

### for문의 구조와 수행순서
for문은 아래와 같이 '초기화', '조건식', '증감식', '블럭{}'. 모두 4부분으로 이루어져 있으며, 조건식이 참인 동안 블럭{} 내의 문장들을 반복하다 거짓이 되면 반복문을 벗어난다.

```java
for (초기화; 조건식; 증감식) {
    // 조건식이 참(true)인 동안 수행될 문장들을 적는다.
}
```

```java
class Ex4_10 {
	public static void main(String[] args) { 
		int sum = 0;	// 합계를 저장하기 위한 변수.

		for(int i=1; i <= 5; i++) {
			sum += i ;	// sum = sum + i;
			System.out.printf("1부터 %2d 까지의 합: %2d%n", i, sum);
		}
	} // main의 끝
}

// 1부터  1 까지의 합:  1
// 1부터  2 까지의 합:  3
// 1부터  3 까지의 합:  6
// 1부터  4 까지의 합: 10
// 1부터  5 까지의 합: 15
```

---

## 중첩 for문

for문 안에 또 다른 for문을 포함시키는 것이 가능하며, 중첩 for문이라고 한다. 중첩 횟수는 거의 제한이 없다.

```java
import java.util.*;

class Ex4_11 {
	public static void main(String[] args) { 

		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} // main의 끝
}

// *
// **
// ***
// ****
// *****
```

---

## while문

for문에 비해 while문은 구조가 간단하다. if문처럼 조건식과 블럭{}만으로 이루어져 있다. 다만 if문과 달리 while문은 조건식이 '참(true)인 동안', 즉 조건식이 거짓이 될 때까지 블럭{} 내의 문장을 반복한다.

### for문과 while문의 비교

1부터 10까지의 정수를 순서대로 출력하는 for을 while문으로 변경하면 아래 오른쪽과 같다.

```java
// 초기롸, 조건식, 증감식
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

    =

int i = 1; // 초기화

while(i <= 10) { // 조건식
    System.out.println(i);
    i++; // 증감식
}
```

```java
class Ex4_13 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		// i를 1씩 증가시켜서 sum에 계속 더해나간다.
		while (sum <= 100) {
			System.out.printf("%d - %d%n", i, sum);
			sum += ++i;
		}
	} // main의 끝
}

// 0 - 0
// 1 - 1
// 2 - 3
// 3 - 6
// 4 - 10
// 5 - 15
// 6 - 21
// 7 - 28
// 8 - 36
// 9 - 45
// 10 - 55
// 11 - 66
// 12 - 78
// 13 - 91
```

```java
class Ex4_14 {
	public static void main(String[] args) { 
		int num = 0, sum = 0;
		System.out.print("숫자를 입력하세요.(예:12345)>");

		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();  // 화면을 통해 입력받은 내용을 tmp에 저장
		num = Integer.parseInt(tmp);      // 입력받은 문자열(tmp)을 숫자로 변환

		while(num!=0) {    
			// num을 10으로 나눈 나머지를 sum에 더함
			sum += num%10; 	// sum = sum + num%10;
			System.out.printf("sum=%3d num=%d%n", sum, num);

			num /= 10;   // num = num / 10;  num을 10으로 나눈 값을 다시 num에 저장
		}

		System.out.println("각 자리수의 합:"+sum);
	}
}

// 숫자를 입력하세요.(예:12345)>12345
// sum=  5 num=12345
// sum=  9 num=1234
// sum= 12 num=123
// sum= 14 num=12
// sum= 15 num=1
// 각 자리수의 합:15
```

어떤 수를 10으로 나머지 연산하면 마지막 자리를 얻을 수 있다. 그리고 10으로 나누면 마지막 한자리가 제거된다.

```java
12345 % 10 -> 5
12345 / 10 -> 1234
```

---

## do-while문

do-while문은 while문의 변형으로 기본적인 구조는 while문과 같으나 조건식과 블럭{}의 순서를 바꿔놓은 것이다. 그래서 while문과 반대로 블럭{}을 먼저 수행한 후에 조건식을 평가한다.

```java
import java.util.*;

class Ex4_15 {
	public static void main(String[] args) { 
		int input  = 0, answer = 0;

		answer = (int)(Math.random() * 100) + 1; // 1~100 사이의 임의의 수를 저장
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("1과 100사이의 정수를 입력하세요.>");
			input = scanner.nextInt();

			if(input > answer) {
				System.out.println("더 작은 수로 다시 시도해보세요.");	
			} else if(input < answer) {
				System.out.println("더 큰 수로 다시 시도해보세요.");			
			}
		} while(input!=answer);

		System.out.println("정답입니다.");
	}
}
```

---

## break문

반복문에서도 break문을 사용할 수 있는데, switch문에서 그랬던 것처럼, break문은 자신이 포함된 가장 가까운 반복문을 벗어난다. 주로 if문과 함께 사용되어 특정 조건을 만족할 때 반복문을 벗어나게 한다.

```java
class Ex4_16 {
	public static void main(String[] args) { 
		int sum = 0;
		int i   = 0;

		while(true) {
			if(sum > 100)
				break;
			++i;
			sum += i;
		} // end of while

		System.out.println("i=" + i);
		System.out.println("sum=" + sum);
	}   
}

// i=14
// sum=105
```

---

## continue문

continue문은 반복문 내에서만 사용될 수 있으며, 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다. for문의 경우 증감식으로 이동하며, while문과 do-while문의 경우 조건식으로 이동한다.

continue문은 반복문 전체를 벗어나지 않고 다음 반복을 계속 수행한다는 점이 break문과 다르다. 주로 if문과 함께 사용되어 특정 조건을 만족하는 경우에 continue문 이후의 문장들을 수행하지 않고 다음 반복으로 넘어가서 계속 진행하도록 한다.

전체 반복 중에 특정조건을 만족하는 경우를 제외하고자 할 때 유용하다.

```java
class Ex4_17 {
	public static void main(String[] args) {
		for(int i=0;i <= 10;i++) {
			if (i%3==0)
				continue; // 조건식이 참이 되어 continue문이 수행되면 블럭의 끝으로 이동하다. break문과 달리 반복문을 벗어나지 않는다.
			System.out.println(i);
		}
	}
}

// 1
// 2
// 4
// 5
// 7
// 8
// 10
```

---

## 이름 붙은 반복문

break문은 근접한 단 하나의 반복문만 벗어날 수 있기 때문에, 여러 개의 반복문이 중첩된 경우에는 break문으로 중첩 반복문을 완전히 벗어날 수 없다. 이떄는 중첩 반복문 앞에 이름을 붙이고 break문과 continue문에 이름을 지정해 줌으로써 하나 이상의 반복문을 벗어나거나 반복을 건너뛸 수 있다.

```java
class Ex4_20 {
	public static void main(String[] args) { 
		int menu = 0, num  = 0;
		Scanner scanner = new Scanner(System.in);

		outer:   // while문에 outer라는 이름을 붙인다. 
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0)>");

			String tmp = scanner.nextLine(); // 화면에서 입력받은 내용을 tmp에 저장
			menu = Integer.parseInt(tmp);    // 입력받은 문자열(tmp)을 숫자로 변환

			if(menu==0) {  
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1<= menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다.(종료는 0)");
				continue;		
			}

			for(;;) {
		      System.out.print("계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>");
				tmp = scanner.nextLine();    // 화면에서 입력받은 내용을 tmp에 저장
				num = Integer.parseInt(tmp); // 입력받은 문자열(tmp)을 숫자로 변환

				if(num==0)  
					break;        // 계산 종료. for문을 벗어난다.

				if(num==99) 
					break outer;  // 전체 종료. for문과 while문을 모두 벗어난다.

				switch(menu) {
					case 1: 
						System.out.println("result="+ num*num);		
						break;
					case 2: 
						System.out.println("result="+ Math.sqrt(num)); 
						break;
					case 3: 
						System.out.println("result="+ Math.log(num));  
						break;
				} 
			} // for(;;)
		} // while의 끝
	} // main의 끝
}
```

---
