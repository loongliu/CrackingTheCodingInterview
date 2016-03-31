package cracking._17_middle;

public class _17_08_MaxSumSubArray {
	
	public static int maxSum(int[] array){
		if(array == null || array.length==0) return 0;
		int max = array[0];
		int maxLeft = 0; // include
		int maxRight = 0; // include
		
		int maxLast = array[0];
		int maxLastLeft = 0;
		for(int i = 1; i<array.length; i++){
			if(maxLast<=0){
				maxLast = array[i];
				maxLastLeft = i;
			}else{
				maxLast += array[i];
			}
			if(maxLast>max){
				max = maxLast;
				maxLeft = maxLastLeft;
				maxRight = i;
			}
		}
		System.out.println("("+maxLeft+","+maxRight+")");
		return max;
	}

	public static void main(String[] args) {
		int[] array = new int[]{2,-8,3,-2,4,-10};
		System.out.println(maxSum(array));
	}

}
