package cracking._11_sortandsearch;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	private static void exchange(int[] array, int index1, int index2){
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	// bubble sort
	public static void bubbleSort(int[] array){
		for(int i = 0; i<array.length; i++){
			for(int j = i +1; j<array.length; j++){
				if(array[i]>array[j]) 
					exchange(array,i,j);
			}
		}
	}
	
	// insert sort
	public static void insertSort(int[] array){
		for(int i = 1; i<array.length; i++){
			int tmp = array[i];
			int j = i-1;
			for(; j>=0 && array[j]>tmp; j--){
				array[j+1] = array[j];
			}
			array[j+1] = tmp;
		}
	}
	
	// select sort
	public static void selectSort(int[] array){
		for(int i = 0; i<array.length; i++){
			int index = i;
			int min = array[i];
			for(int j = i+1; j<array.length; j++){
				if(min>array[j]){
					min = array[j];
					index = j;
				}
			}
			exchange(array, i,index);
		}
	}
	
	

	public static void main(String[] args) {
		int N = 20;
		int[] array = generateArray(N);
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println();
		array = generateArray(N);
		System.out.println(Arrays.toString(array));
		insertSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println();
		array = generateArray(N);
		System.out.println(Arrays.toString(array));
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}
	private static int[] generateArray(int size){
		int[] array = new int[size];
		Random rand = new Random(System.nanoTime());
		for(int i = 0; i<size;i++){
			array[i] = rand.nextInt(100);
		}
		return array;
	}

}
