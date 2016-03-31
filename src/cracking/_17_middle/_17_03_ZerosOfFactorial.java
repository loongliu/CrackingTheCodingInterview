package cracking._17_middle;


public class _17_03_ZerosOfFactorial {
	
	public static int zeroOfFactiorial(int n){
		int count = 0;
		while(n!=0){
			count += n/5;
			n = n/5;
		}
		return count;
	}
	


	public static void main(String[] args) {
		int n = 25;
		System.out.println(zeroOfFactiorial(n));
	}

}
