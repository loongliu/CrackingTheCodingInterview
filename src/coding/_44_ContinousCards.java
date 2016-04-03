package coding;

import java.util.Arrays;

public class _44_ContinousCards {
	
	public static boolean isContinuous(int[] array){
		if(array==null) return false;
		int len = array.length;
		if(len!=5) return false;
		Arrays.sort(array);
		int numOf0 = 0;
		for(numOf0 = 0; numOf0<5 && array[numOf0]==0; numOf0++);
		if(numOf0==5) return true;
		int dif = array[4] - array[numOf0];
		if(dif>=5||dif<4-numOf0) return false;
		for(int i = numOf0+1;i<len; i++){
			if(array[i]== array[i-1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isContinuous(new int[]{1,2,3,4,5}));
		System.out.println(isContinuous(new int[]{1,2,2,3,4}));
		System.out.println(isContinuous(new int[]{1,2,4,6,5}));
		System.out.println(isContinuous(new int[]{0,0,0,0,0}));
	}

}
