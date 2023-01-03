
public class Exercise9_5 {

	public static void main(String args[]) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}

	public static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src.length());

		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);

			if (delCh.indexOf(ch) == -1)  // 매개변수 타입이 int지만 char값을 넣으면 된다.
				sb.append(ch);
		}

		return sb.toString();
	}
}