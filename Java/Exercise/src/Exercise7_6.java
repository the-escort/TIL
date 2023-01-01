
public class Exercise7_6 {

	public static void main(String args[]) {
		Outer oc = new Outer();
		Outer.Inner ii = oc.new Inner();
		
		System.out.println(ii.iv);
		
	}
}

class Outer {
	class Inner {
		int iv = 100;
	}
}