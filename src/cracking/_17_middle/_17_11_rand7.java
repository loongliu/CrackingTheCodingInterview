package cracking._17_middle;

import java.util.Arrays;
import java.util.Random;

public class _17_11_rand7 {
	public static int rand7(){
		int count;
		while(true){
			count = rand5()+rand5();
			if(count == 0 || count == 3) {
				count = rand5();
				if(count <2) return 0;
				if(count > 2) return 1;
				continue;
			}
			if(count == 5 || count == 8) {
				count = rand5();
				if(count <2) return 2;
				if(count > 2) return 3;
				continue;
			}
			if(count == 4) {
				count = rand5();
				if(count <2) return 4;
				if(count > 2) return 5;
				continue;
			}
			if(count == 7) return 6;
		}
	}
	
	static Random r = new Random(System.nanoTime());
	private static int rand5(){
		return r.nextInt(5);
	}
	
	public static void main(String[] args){
		int[] array = new int[]{0,0,0,0,0,0,0};
		for(int i = 0;i<10000000; i++){
			array[rand7()]++;
		}
		System.out.println(Arrays.toString(array));
	}
}
