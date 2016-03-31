package cracking._18_hard;

import java.util.HashSet;

public class _18_07_GetLongestWord {
	
	
	public static String getLongestWord(String[] words){
		HashSet<String> set = new HashSet<String>();
		for(String s:words){
			set.add(s);
		}
		int longest = Integer.MIN_VALUE;
		String res = null;
		for(String s : words){
			if(canSpare(set,s)){
				if(longest<s.length()){
					longest = s.length();
					res = s;
				}
			}
		}
		return res;
	}
	
	private static boolean canSpare(HashSet<String> set, String s){
		for(String sub : set){
			if(s.equals(sub)) return true;
			if(s.startsWith(sub)){
				String t = s.substring(sub.length(), s.length());
				if(canSpare(set,t)) return true;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		String[] words = new String[]{"cat","banana","dog","nana","walk","walker","dogwalker"};
		System.out.println(getLongestWord(words));
	}

}
