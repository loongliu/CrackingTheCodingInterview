package cracking._09_dp;

public class _09_08_CountCoins {
	public static int count(int n){
		return count(n,4)+count(n,3)+count(n,2)+count(n,1);
	}
	private static int count(int n, int index){
		if(n == 0) return 1;
		if(index == 1){
			return 1;
		}
		if(index == 2){
			int count = 0;
			for(int i = n-5;i>=0;i-=5){
				count+=count(i,1);
			}
			return count;
		}
		if(index == 3){
			int count = 0;
			for(int i = n-10; i>=0;i-=10){
				if(i == 0) count++;
				else 	count = count + count(i,2) + count(i,1);
			}
			return count;
		}
		if(index == 4){
			int count = 0;
			for(int i = n-25; i>=0;i-=25){
				if(i == 0) count++;
				else 	count = count+ count(i,3)+ count(i,2) + count(i,1);
			}
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		for(int i = 1; i<60; i+=1){
			System.out.println(i+" : "+count(i));
		}
	}

}
