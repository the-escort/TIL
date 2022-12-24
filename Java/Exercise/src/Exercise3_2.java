
public class Exercise3_2 {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		
		System.out.println(y >= 5 || x < 0 && x > 2); // true
		System.out.println(y += 10 - x++); // y = y + 10 - 2 = 13
		System.out.println(x += 2); // x = 3 + 2 = 5;
		System.out.println(!('A' <= c && c <= 'Z')); // !(65 <= 65 && 65 <= 90) = false
		System.out.println('C' - c); // 67 - 65 = 2;
		System.out.println('5' - '0'); // 53 - 48 = 5
		System.out.println(c + 1); // 65 + 1 = 66
		System.out.println(++c); // B
		System.out.println(c++); // B
		System.out.println(c); // C
		
	}

}
