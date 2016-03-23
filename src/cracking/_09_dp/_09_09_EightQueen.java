package cracking._09_dp;

import java.util.ArrayList;

public class _09_09_EightQueen {
	
	public static void main(String[] args) {
		ArrayList<Integer> cur = new ArrayList<>();
		ArrayList<ArrayList<Integer>> re = new ArrayList<>();
		re.add(cur);
		for(int index = 0; index<8; index++){
			ArrayList<ArrayList<Integer>> tmp = re;
			re = new ArrayList<>();
			for(ArrayList<Integer> t : tmp){
				for(int i = 0;i<8;i++){
					if(canAdd(index, i,t)){
						ArrayList<Integer> cpy = new ArrayList<>();
						cpy.addAll(t);
						cpy.add(i);
						re.add(cpy);
					}
				}
			}
		}
		System.out.println(re.size());
		for(ArrayList<Integer> list : re){
			System.out.println(list);
		}
	}
	private static boolean canAdd(int index,int position, ArrayList<Integer> cur){
		for(int i = 0; i<index; i++){
			if(position == cur.get(i)) return false;
			if(position-index == cur.get(i)-i) return false;
			if(position+index == cur.get(i)+i) return false;
		}
		return true;
	}

}