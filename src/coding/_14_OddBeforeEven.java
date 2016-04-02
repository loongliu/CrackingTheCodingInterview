package coding;

import java.util.Arrays;

public class _14_OddBeforeEven {
	
	public static void oddBeforeEven(int[] array){
		if(array == null) return;
		int odd = 0;
		int even = array.length-1;
		while(even>odd){
			if(array[odd]%2==0){
				int tmp = array[odd];
				array[odd] = array[even];
				array[even] = tmp;
				even--;
			}else{
				odd++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,5145,546,45,47,84,15,136,1254,45};
		oddBeforeEven(array);
		System.out.println(Arrays.toString(array));
	}

}
