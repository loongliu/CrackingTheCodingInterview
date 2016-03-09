package cracking._07_math;

import java.util.TreeSet;

public class _07_06_GetKthMagicNumber {
	
	public static int getKthMagicNumber(int k){
		TreeSet<Integer> set = new TreeSet<>();
		set.add(3);
		set.add(5);
		set.add(7);
		int num = 0;
		int least = 0;
		while(num<k){
			least = set.first();
			set.remove(least);
			System.out.println(least);
			num++;
			if(num+set.size()<k){
				set.add(least*3);
				set.add(least*5);
				set.add(least*7);
			}
		}
		return least;
	}

	public static void main(String[] args) {
		System.out.println(getKthMagicNumber(50));
	}

}
