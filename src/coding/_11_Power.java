package coding;

public class _11_Power {
	
	public static double power(double base, int exponent){
		if(exponent == 0) return 1;
		if(exponent == 1) return base;
		if(exponent < 0){
			base = 1/base;
			exponent = -exponent;
		}
		double half = power(base, exponent/2);
		return half*half*power(base,exponent%2);
	}

	public static void main(String[] args) {
		System.out.println(power(2,3));
		System.out.println(power(2,0));
		System.out.println(power(2,-3));
	}

}
