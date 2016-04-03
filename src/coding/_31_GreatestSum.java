package coding;

public class _31_GreatestSum {
	
	public static int greatestSum(int[] array){
		if(array == null || array.length==0) return 0;
		int largeSum = array[0];
		int curSum = array[0];
		for(int i = 1; i<array.length; i++){
			curSum = array[i] + (curSum>0?curSum:0);
			largeSum = largeSum>curSum?largeSum:curSum;
		}
		return largeSum;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
		System.out.println(greatestSum(array));
	}

}
