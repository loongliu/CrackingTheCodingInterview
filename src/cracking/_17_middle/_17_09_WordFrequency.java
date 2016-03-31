package cracking._17_middle;

import java.util.HashMap;

public class _17_09_WordFrequency {

	static HashMap<String,Integer> generateMap(String[] book){
		HashMap<String,Integer> map = new HashMap<>();
		for(String s : book){
			if(map.containsKey(s)){
				map.put(s, map.get(s)+1);
			}else{
				map.put(s, 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		String[] book = "ok i will go to the classroom ok this is better for me ok".split(" ");
		HashMap<String,Integer> map = generateMap(book);
		System.out.println(map.get("ok"));
	}

}
