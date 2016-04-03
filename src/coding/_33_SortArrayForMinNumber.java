package coding;

import java.util.Arrays;
import java.util.Comparator;

public class _33_SortArrayForMinNumber {

	public static void sortArrayForMinNumber(int[] array){
		if(array == null || array.length==0) return;
		String[] strarray = new String[array.length];
		for(int i = 0; i<array.length; i++){
			strarray[i] = String.valueOf(array[i]);
		}
		Arrays.sort(strarray, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
			
		});
		for(String s:strarray){
			System.out.print(s);
		}
	}
	
	public static void main(String[] args){
		int[] array = new int[]{3,32,321};
		sortArrayForMinNumber(array);
	}
	
}
