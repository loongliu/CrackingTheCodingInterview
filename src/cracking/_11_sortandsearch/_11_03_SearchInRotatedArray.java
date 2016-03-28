package cracking._11_sortandsearch;

import java.util.Arrays;

public class _11_03_SearchInRotatedArray {
	
	public static int sortInRotatedArray(int[] array, int key){
		int gap = -1;
		for(int i = 0; i<array.length-1; i++){
			if(array[i]>array[i+1]){
				gap = i;
			}
		}
		if(gap == -1){
			return Arrays.binarySearch(array, key);
		}
		int search = Arrays.binarySearch(array, 0, gap+1, key);
		if(search>=0){
			return search;
		}else{
			return Arrays.binarySearch(array, gap+1,array.length, key);
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] array = new int[]{15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(sortInRotatedArray(array,5));
	}

}
