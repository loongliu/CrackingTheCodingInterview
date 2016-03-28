package cracking._11_sortandsearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class _11_02_SortAnagrams {

	public static void sortAnagrams(String[] array){
		Arrays.sort(array, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				char c = 'A';
				while(true){
					long c1= 0;
					long c2 = 0;
					for(char cc1 : o1.toCharArray()){
						if(c==cc1) c1++;
					}
					for(char cc2 : o2.toCharArray()){
						if(c==cc2) c2++;
					}
					if(c1!=c2){
						return c1<c2?1:-1;
					}
					if(c=='Z'){
						c = 'a';
						continue;
					}else if(c == 'z'){
						return 0;
					}
					c++;
				}
			}});
	}
	
	public static void arrangeAnagrams(String[] array){
		HashMap<String,LinkedList<String>> map = new HashMap<>();
		
		for(String s:array){
			String chars = sortChar(s);
			if(!map.containsKey(chars)){
				map.put(chars,new LinkedList<String>());
			}
			LinkedList<String> list = map.get(chars);
			list.add(s);
		}
		int index = 0;
		for(String s : map.keySet()){
			for(String arr : map.get(s)){
				array[index++] = arr;
			}
		}
	}
	
	private static String sortChar(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	
	public static void main(String[] args) {
		String[] array = new String[]{"def","ceg","dfe","d","fd","exedfa"};
		System.out.println(Arrays.toString(array));
		arrangeAnagrams(array);
		System.out.println(Arrays.toString(array));
	}

}