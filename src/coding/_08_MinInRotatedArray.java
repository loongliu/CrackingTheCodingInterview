package coding;

public class _08_MinInRotatedArray {

	public static int min(int[] array){
		int left = 0;
		int right = array.length-1;
		int mid = left;
		while(array[left]>=array[right]){
			if(right-left==1){
				mid = right;
				break;
			}
			mid = left+(right-left)/2;
			if(array[left] == array[mid] && array[left]==array[right]){
				return minInOrder(array, left, right);
			}
			if(array[mid]>=array[0]){
				left = mid;
			}else{
				right = mid;
			}
		}
		return array[left];
	}
	private static int minInOrder(int[] array, int left, int right){
		int min = array[left];
		for(int i = left+1; i<=right; i++){
			if(min>array[i]) min = array[i];
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[]{1,1,1,0,1};
		System.out.println(min(array));
	}

}
