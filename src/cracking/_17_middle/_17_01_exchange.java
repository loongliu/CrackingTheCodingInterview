package cracking._17_middle;

public class _17_01_exchange {
	
	/**
	 * exhange the value of v1 and v2, may overflow
	 */
	public static void exchange1(int v1, int v2){
		System.out.println("v1: " + v1 + " v2: " + v2);
		v1 = v1 + v2;
		v2 = v1 - v2;
		v1 = v1 - v2;
		System.out.println("v1: " + v1 + " v2: " + v2);
	}
	/**
	 * exhange the value of v1 and v2, not overflow
	 */
	public static void exchange2(int v1, int v2){
		System.out.println("v1: " + v1 + " v2: " + v2);
		v1 = v1^v2;
		v2 = v1^v2;
		v1 = v1^v2;
		System.out.println("v1: " + v1 + " v2: " + v2);
	}

	public static void main(String[] args) {
		int v1 = 15;
		int v2 = 879;
		exchange1(v1,v2);
		
		v1 = 345;
		v2 = 4234;
		exchange2(v1,v2);
	}

}
