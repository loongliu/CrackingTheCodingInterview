package coding;

import java.util.HashMap;

public class _35_FirstNotRepeatingChar {

	public static char firstNotRepeatingChar(String arg){
		HashMap<Character, Integer> map = new HashMap<>();
		int len = arg.length();
		for(int i = 0; i<len; i++){
			char c = arg.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		for(int i = 0; i<len; i++){
			char c = arg.charAt(i);
			if(map.get(c)==1) return c;
		}
		return ' ';
	}
	
	public static void main(String[] args) {
		System.out.println(firstNotRepeatingChar("abaccdeff"));
	}

}
