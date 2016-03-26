package cracking._11_sortandsearch;

import java.util.Arrays;

public class _11_01_MergeSort {
	/**
	 * 
	 * @param A the destination array
	 * @param length length of effective elements in array A
	 * @param B array to be merged
	 */
	public static void merge(int[] A, int length ,int[] B){
		int totalLength = A.length;
		for(int i = 0; i<length; i++){
			A[totalLength-length+i] = A[i];
		}
		int iA = totalLength-length;
		int iB = 0;
		int i = 0;
		for(; i<length+B.length-1; i++){
			if(iA == totalLength){
				A[i] = B[iB++];
				continue;
			}
			if(iB == B.length){
				A[i] = A[iA++];
				continue;
			}
			if(A[iA] < B[iB]){
				A[i] = A[iA++];
			}else{
				A[i] = B[iB++];
			}
		}
		for(;i<totalLength; i++){
			A[i] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 3;
		A[2] = 7;
		int[] B = new int[]{2,4,6,8};
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		merge(A,3,B);
		System.out.println(Arrays.toString(A));
	}

}
