package cracking._18_hard;

import java.util.Random;

public class _18_03_RandomChoose {
	
	public static int[] subarray(int[] array, int num){
		int total = array.length;
		int tmp;
		Random r = new Random(System.nanoTime());
		for(int i = total-1; i>total-1-num; i--){
			int rand = r.nextInt(i+1);
			tmp = array[rand];
			array[rand] = array[i];
			array[i] = tmp;
		}
		int[] subarray = new int[num];
		System.arraycopy(array, total-num,subarray,0,num);
		return subarray;
	}

	public static void main(String[] args) {
		int total = 11;
		int num = 5;
		int[] array = new int[total];
		for(int i = 0; i<array.length; i++){
			array[i] = i;
		}
		int[][] count = new int[num][total];
		for(int i = 0; i<num;i++){
			for(int j = 0; j<total;j++){
				count[i][j] = 0;
			}
		}
		int[] subarray;
		for(int i = 0; i<10000000; i++){
			subarray = subarray(array,num);
			for(int j = 0; j<subarray.length; j++){
				for(int k : array){
					if(subarray[j] == k){
						count[j][k]++;
					}
				}
			}
		}
		for(int i = 0; i<num;i++){
			for(int j = 0; j<total;j++){
				System.out.print(count[i][j]+" ");
			}
			System.out.println();
		}
	}

}
