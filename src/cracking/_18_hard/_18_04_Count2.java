package cracking._18_hard;

import java.util.ArrayList;

public class _18_04_Count2 {

	public static int count2(int n){
		ArrayList<Integer> base = new ArrayList<>();
		base.add(0);
		return count2(n, base);
	}
	
	private static int count2(int n, ArrayList<Integer> base){
		int count = 0;
		int reminder;
		int div = 1;
		int b;
		int index = 0;
		while(n/div!=0){
			reminder = (n/div)%10;
			if(reminder>2){
				count+=div;
			}else if (reminder == 2){
				count += (1+n%div);
			}
			if(base.size()<=index){
				b = count2(div-1,base);
				base.add(b);
			}
			count += reminder*base.get(index);
			div*=10;
			index++;
		}
		//if(add) base.add(count);
		return count;
	}
	
	
	public static int count(int n){
		int count = 0;
		for(int i = 2; i<=n; i++){
			count+=numberOf2s(i);
		}
		return count;
	}
	
	private static int numberOf2s(int n){
		int count = 0;
		while(n>0){
			if(n%10 == 2){
				count++;
			}
			n = n/10;
		}
		return count;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		for(int i = 98; i<120000;i++ ){
			count2(i);
		}
		System.out.println((System.nanoTime()-start));
		start = System.nanoTime();
		for(int i = 98; i<120000;i++ ){
			count(i);
		}
		System.out.println((System.nanoTime()-start));
	}

}
