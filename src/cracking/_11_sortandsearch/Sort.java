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
	
	// heap sort
	public static void heapSort(int[] array){
		for(int i = (array.length-1-1)/2; i>=0; i--){
			for(int j = i;j<=(array.length-1-1)/2;){
				j = rerange(array, j, array.length-1);
				if(j == -1) break;
			}
		}
		//System.out.println(Arrays.toString(array));
		for(int heapSize = array.length-1; heapSize>=0;){
			exchange(array, 0, heapSize--);
			for(int i = 0; i<=(heapSize-1)/2;){
				i = rerange(array, i, heapSize);
				if(i == -1) break;
			}
		}
	}
	
	private static int rerange(int[] array, int i, int max){
		if(2*i+1>max){ return -1;}
		if(2*i+2 > max){
			if(array[2*i+1]>= array[i]){
				exchange(array,2*i+1, i);
				return 2*i+1;
			}else{
				return -1;
			}
		}
		if(array[2*i+1]>=array[i] && array[2*i+1]>= array[2*i+2]){
			exchange(array, i, 2*i+1);
			return 2*i+1;
		}else if( array[2*i+2]>=array[i] && array[2*i+2]>=array[2*i+1]){
			exchange(array, i, 2*i+2);
			return 2*i+2;
		}
		return -1;
	}
	
	// quick sort
	public static void quickSort(int[] array){
		int left = 0;
		int right = array.length-1;
		quickSort(array, left, right);
	}
	
	private static void quickSort(int[] array, int left, int right){
		if(left >= right) return;
		int part = part(array, left, right);
		quickSort(array, left, part-1);
		quickSort(array, part+1, right);
	}
	
	/**
	 * @param start include
	 * @param end include
	 */
	private static int part(int[] array, int start, int end){
		int value = array[start];
		int left = start;
		int right = end;
		while(left<right){
			while(left<right && array[right]>=value) right--;
			if(left<right){
				array[left] = array[right];
				left++;
			}
			while(left<right && array[left]<=value) left++;
			if(left<right){
				array[right] = array[left];
				right--;
			}
		}
		array[left] = value;
		return left;
	}
	
	// merge sort
	public static void mergeSort(int[] array){
		int[] aux = new int[array.length];
		mergeSort(array, 0, array.length-1, aux);
	}
	private static void mergeSort(int[] array, int start, int end, int[] aux){
		if(start>=end) return;
		int mid = start + (end-start)/2;
		mergeSort(array, start, mid ,aux);
		mergeSort(array, mid+1, end, aux);
		mergeArray(array, start,mid, end, aux);
	}
	private static void mergeArray(int[] array, int start, int mid, int end, int[] aux){
		System.arraycopy(array, start, aux, start, end-start+1);
		int index1 = start;
		int index2 = mid+1;
		for(int i = start; i<=end;i++){
			if(index1>=mid+1){
				array[i] = aux[index2++];
				continue;
			}
			if(index2>=end+1){
				array[i] = aux[index1++];
				continue;
			}
			if(aux[index1]<=aux[index2]){
				array[i] = aux[index1++];
			}else{
				array[i] = aux[index2++];
			}
		}
	}
	
	public static int binearySearch(int[] array, int key){
		int left = 0;
		int right = array.length-1;
		int mid;
		while(left<right){
			mid = (right-left)/2+left;
			if(array[mid]>key){
				right = mid-1;
			}else if(array[mid] < key){
				left = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		int N = 80;
		int[] array = generateArray(N);
		
		
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(binearySearch(array, 18));
		
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
		
		System.out.println();
		array = generateArray(N);
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println();
		array = generateArray(N);
		System.out.println(Arrays.toString(array));
		quickSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println();
		array = generateArray(N);
		System.out.println(Arrays.toString(array));
		mergeSort(array);
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
