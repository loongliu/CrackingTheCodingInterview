package coding;

import java.util.Arrays;

public class _52_ArrayConstruction {
	
	public static int[] construct(int[] arrA){
		int n = arrA.length;
		int[] arrB = new int[n];
		int[] arrC = new int[n];
		int[] arrD = new int[n];
		arrC[0] = 1;
		arrD[n-1] = 1;
		for(int i = 1; i<n;i++){
			arrC[i] = arrC[i-1]*arrA[i-1];
			arrD[n-1-i] = arrD[n-i]*arrA[n-i];
		}
		for(int i = 0;i<n;i++) arrB[i] = arrC[i]*arrD[i];
		return arrB;
	}

	public static void main(String[] args) {
		int[] arrA = new int[]{1,2,3,4};
		System.out.println(Arrays.toString(construct(arrA)));
	}

}
