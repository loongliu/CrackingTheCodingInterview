package cracking._18_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _18_10_WordTransformation {
	
	public static ArrayList<String> transform(String[] words,String s,String out){
		HashMap<String, ArrayList<String>> did = new HashMap<>();
		HashMap<String, ArrayList<String>> doing = new HashMap<>();
		HashSet<String> will = new HashSet<>();
		for(String ss:words){
			will.add(ss);
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(s);
		did.put(s, list);
		while(did.size()!=0){
			for(String ss:did.keySet()){
				// for words are very large, the next for loop is slow
				// one can find all String that ss has distance of 1
				// and then check whether the string is in Set will.
				for(String sss : will){
					if(length(ss,sss) == 1){
						ArrayList<String> l = new ArrayList<String>(did.get(ss));
						l.add(sss);
						if(length(sss, out)==1){
							l.add(out);
							return l;
						}
						doing.put(sss,l);
					}
				}
			}
			did = doing;
			will.removeAll(doing.keySet());
			doing = new HashMap<>();
		}
		return null;
	}
	
	private static int length(String s1, String s2){
		int count = 0;
		for(int i = 0; i<s1.length()&&i<s2.length(); i++){
			if(s1.charAt(i)!= s2.charAt(i)) count++;
		}
		return count;
	}
	
	

	public static void main(String[] args) {
		String[] array = new String[]{"dog", "boy", "dok", "bok", "cat"};
		System.out.println(transform(array,"eog","bcy"));
	}

}
