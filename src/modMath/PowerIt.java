package modMath;

public class PowerIt {
	public static int powerIterator(int l, int c, int b) {
	return (int) Math.pow(b, l-c);
	}
	public static int powerIterator(int l, int c) {
		return (int) Math.pow(2, l-c);
	}

}
