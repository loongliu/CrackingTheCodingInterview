package cracking._17_middle;

import java.util.HashSet;

public class _17_12_NumberPair {

	public static void pair(int[] array, int key){
		for(int i = 0; i<array.length; i++)
			for(int j = i+1; j<array.length; j++)
				if(array[i] + array[j] == key)
					System.out.println("("+array[i]+","+array[j]+")");
	}
	
	public static void pair2(int[] array, int key){
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i<array.length; i++){
			if(set.contains(array[i])){
				System.out.println("("+array[i]+","+(key-array[i])+")");
			}else{
				set.add(key-array[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		pair(array,8);
		pair2(array,9);
	}

}
