package coding;

import java.util.Random;

public class _47_Add {

	public static int add(int v1, int v2){
		int tmp1, tmp2;
		while(v2!=0){
			tmp1 = v1;
			tmp2 = v2;
			v1 = tmp1^tmp2;
			v2 = (tmp1&tmp2)<<1;
		}
		return v1;
	}
	
	public static void main(String[] args){
		Random r = new Random(System.nanoTime());
		for(int i = 1; i<100;i++){
			int v1 = r.nextInt(1000);
			int v2 = r.nextInt(1000);
			System.out.printf("%4d + %4d = %5d%n", v1,v2,add(v1,v2));
		}
	}
	
}
