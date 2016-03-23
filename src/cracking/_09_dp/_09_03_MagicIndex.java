package cracking._09_dp;

public class _09_03_MagicIndex {
	
	public static int getIndex(int[] array){
		for(int i = 0; i<array.length; i++){
			if(i == array[i]) return i;
		}
		return -1;
	}
	
	
	public static int getIndexBinary(int[] array){
		int left = 0; 
		int right = array.length-1;
		int mid;
		while(left<right){
			mid = left+(right-left)/2;
			if(array[mid]<mid){
				left = mid+1;
			}else{
				right = mid;
			}
		}
		return right;
	}

	

	public static void main(String[] args) {
		int[] array = new int[]{-2,-1,0,3,5,6};
		System.out.println(getIndex(array));
		System.out.println(getIndexBinary(array));
	}

}
