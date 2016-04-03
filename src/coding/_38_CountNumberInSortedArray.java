package coding;

public class _38_CountNumberInSortedArray {

	public static int countNumber(int[] array, int key){
		int leftIndex = countLeft(array, key);
		int rightIndex = countRight(array, key);
		return rightIndex-leftIndex+1;
	}
	
	private static int countLeft(int[] array, int key){
		int left = 0;
		int right = array.length-1;
		int mid;
		while(left<right){
			mid = (right-left)/2+left;
			if(array[mid]<key){
				left = mid+1;
			}else{
				right = mid;
			}
		}
		return left;
	}
	
	private static int countRight(int[] array, int key){
		int left = 0;
		int right = array.length-1;
		int mid;
		while(left<right){
			mid = (right-left+1)/2+left;
			if(array[mid]<=key){
				left = mid;
			}else{
				right = mid-1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,3,3,3,3,4,5};
		System.out.println(countNumber(array,3));
		System.out.println(countNumber(array,4));
	}

}
