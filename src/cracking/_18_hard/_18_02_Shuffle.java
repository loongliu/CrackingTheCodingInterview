package cracking._18_hard;

import java.util.Random;

public class _18_02_Shuffle {
	
	public static void shuffle(int[] array){
		int tmp;
		Random r = new Random(System.nanoTime());
		for(int i = array.length-1; i>0; i--){
			int ran = r.nextInt(i+1);
			tmp = array[i];
			array[i] = array[ran];
			array[ran] = tmp;
		}
	}
	

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		int[][] count = new int[11][11];
		for(int i = 0; i<11;i++){
			for(int j = 0; j<11;j++){
				count[i][j] = 0;
			}
		}
		for(int i = 0; i<10000000; i++){
			shuffle(array);
			for(int j = 0; j<array.length; j++){
				for(int k : array){
					if(array[j] == k){
						count[j][k-1]++;
					}
				}
			}
		}
		for(int i = 0; i<11;i++){
			for(int j = 0; j<11;j++){
				System.out.print(count[i][j]+" ");
			}
			System.out.println();
		}
	}

}
