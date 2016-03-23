package cracking._09_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _09_04_SubSet {

	public static <T> ArrayList<ArrayList<T>> subsets(List<T> c){
		ArrayList<ArrayList<T>> res = new ArrayList<>();
		ArrayList<T> list = new ArrayList<>();
		res.add(list);
		for(T t : c){
			int size = res.size();
			for(int i = 0; i<size; i++){
				ArrayList<T> sub = res.get(i);
				ArrayList<T> a = new ArrayList<>(sub.size()+1);
				a.addAll(sub);
				a.add(t);
				res.add(a);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> s = Arrays.asList(1,2,3,4,5,6);
		ArrayList<ArrayList<Integer>> res = subsets(s);
		System.out.println(res.size());
	}

}
