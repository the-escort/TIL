
public class Exercise3_6 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		// C = 5 / 9 X (F - 32)
		// 소수점 셋째자리에서 반올림
		float celcius = (int) ((5 / 9f * (fahrenheit - 32)) * 100 + 0.5f) / 100f ;
		
		System.out.println("Fahrenheit:" + fahrenheit);
		System.out.println("Celcius:" + celcius);
	}
}