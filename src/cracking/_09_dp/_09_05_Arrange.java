package cracking._09_dp;

import java.util.HashSet;
import java.util.Set;

public class _09_05_Arrange {

	public static Set<String> arrange(CharSequence s){
		if(s==null || s.length()==0) return null;
		Set<String> res = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		res.add(sb.toString());
		for(int i = 1; i<s.length();i++){
			Set<String> tmp = res;
			res = new HashSet<>();
			for(String sb_tmp : tmp){
				for(int index = 0; index<=sb_tmp.length();index++){
					StringBuilder sb_index = new StringBuilder(sb_tmp);
					sb_index.insert(index, s.charAt(i));
					res.add(sb_index.toString());
				}
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		String s = "acb";
		Set<String> sss = arrange(s);
		System.out.println(sss);
		System.out.println(sss.size());
	}

}
