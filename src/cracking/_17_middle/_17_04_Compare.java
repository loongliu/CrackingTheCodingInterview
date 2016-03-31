package cracking._17_middle;

public class _17_04_Compare {
	
	/**
	 * @return sign of val, 1 for bigger than or equal to zero, 0 for smaller than zero
	 */
	private static int sgn(int val){
		val >>= 31;
		return 1^(val&0x1);
	}
	
	public static int max(int a, int b){
		int k = (sgn(a)^sgn(b))*sgn(a) + (1^(sgn(a)^sgn(b)))*sgn(a-b);
		return a*k + b * 1^k;
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE-2;
		int b = Integer.MAX_VALUE;
		System.out.println(max(a,b));
	}

}
