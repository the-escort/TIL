import java.util.Arrays;

public class Exercise6_20 {

	public static void main(String args[]) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(Arrays.toString(data));
		System.out.println("최대값 : " + max(data));
		System.out.println("최대값 : " + max(null));
		System.out.println("최대값 : " + max(new int[] {}));

	}

	public static int max(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -99999;
		}

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}
}
