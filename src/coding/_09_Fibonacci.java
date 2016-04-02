package coding;

public class _09_Fibonacci {

	public static long fibonacci(int n){
		long f1 = 1;
		long f2 = 1;
		if(n<=2) return 1;
		long fn;
		for(int i = 3; i<=n;i++){
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}
		return f2;
	}
	
	public static void main(String[] args) {
		for(int i = 1; i<10; i++){
			System.out.println(fibonacci(i));
		}
	}

}
