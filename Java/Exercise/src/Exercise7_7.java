
public class Exercise7_7 {

	public static void main(String args[]) {
		Outer.Inner ii = new Outer.Inner();
		
		System.out.println(ii.iv);
		
	}
}

class Outer {
	static class Inner {
		int iv = 200;
	}
}