package coding;

public class _40_SingleNumbers {
	
	public static void singleNumbers(int[] array){
		int xor = 0;
		for(int num : array) xor^=num;
		int digit = lastDigit(xor);
		int key = 1<<(digit-1);
		int fir = 0;
		int sec = 0;
		for(int num:array){
			if((num&key)==1){
				fir^=num;
			}else{
				sec^=num;
			}
		}
		System.out.println(fir+" "+sec);
	}
	
	private static int lastDigit(int number){
		int i = 1;
		int res = 1;
		while((number&i)!=1){
			i<<=1;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,45,34,34,45,56,56,79,78,79,78,34};
		singleNumbers(array);
	}

}
