package cracking._09_dp;

public class _09_01_Upstair {
	public static int upStartLow(int n){
		if(n < 0) return 0;
		if(n == 0) return 1;
		int[] count = new int[n+1];
		count[0] = 1;
		for(int i = 1; i<=n; i++){
			if(i==1)	count[i]=count[i-1];
			else if(i == 2) count[i] = count[i-1]+count[i-2];
			else count[i] = count[i-1]+count[i-2]+count[i-3];
		}
		return count[n];
	}
	

	
	public static void main(String[] args) {
		for(int i = 0;i<20;i++)
		System.out.println(upStartLow(i));
	}

}
