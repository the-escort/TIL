
public class Exercise9_3 {

	public static void main(String args[]) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}

	public static int count(String src, String target) {
		int count = 0; // 찾은 횟수
		int pos = 0; // 찾기 시작할 위치

//		while (true) {
//			pos = src.indexOf(target, pos);
//
//			if (pos != -1) {
//				count++;
//		/		pos += target.length(); // pos를 찾은 단어 이후로 옮긴다.
//			} else {
//				break;
//			}
//		}
//		
//		return count;

		while ((pos = src.indexOf(target, pos)) != -1) {
			count++;
			pos += target.length();
		}

		return count;
	}
}