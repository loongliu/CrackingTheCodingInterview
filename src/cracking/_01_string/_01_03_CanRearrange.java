package cracking._01_string;

import java.util.Arrays;

public class _01_03_CanRearrange {

	public static void main(String[] args) {
		System.out.println(canRearrange("abc","bca"));
	}
	
	private static boolean canRearrange(String s1, String s2){
		if(s1==null || s2==null || s1.length()!= s2.length()) {
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i = 0; i<c1.length&&i<c2.length; i++){
			if(c1[i]!=c2[i]){
				return false;
			}
		}
		return true;
	}

}
