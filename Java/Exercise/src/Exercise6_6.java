
public class Exercise6_6 {

	public static void main(String args[]) {
		MyPoint p = new MyPoint(1, 1);

		// p와 (2, 2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}

}

class MyPoint {
	int x; // 인스턴스 변수
	int y; // 인스턴스 변수

	MyPoint(int x, int y) { // 인스턴스 메서드
		this.x = x;
		this.y = y;
	}

	double getDistance(int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)); // x, y는 지역변수
	}

}
