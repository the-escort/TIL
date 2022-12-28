
public class Exercise6_7 {

	public static void main(String args[]) {

	}

}

class Marine {
	int x = 0, y = 0;
	int hp = 60;
	int weapon = 6; // static
	int armor = 0; // static

	void weaponUp() { // static
		weapon++;
	}

	void armorUp() { // static
		armor++;
	}

	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}