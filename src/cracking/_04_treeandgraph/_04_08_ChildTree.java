package cracking._04_treeandgraph;

import java.util.LinkedList;

public class _04_08_ChildTree {

	
	public static <T> boolean sameTree(TreeNode<T> fir, TreeNode<T> sec){
		if(fir == null && sec == null) return true;
		if(fir == null && sec != null) return false;
		if(fir != null && sec == null) return false;
		if(fir.val == null && sec.val != null) return false;
		if(fir.val != null && sec.val == null) return false;
		if(fir.val != null && !fir.val.equals(sec.val)) return false;
		if( !sameTree(fir.left, sec.left) || !sameTree(fir.right, sec.right)) return false;
		return true;
	}
	
	public static <T> boolean childTree(TreeNode<T> big, TreeNode<T> small){
		LinkedList<TreeNode<T>> list = new LinkedList<>();
		list.add(big);
		while(!list.isEmpty()){
			TreeNode<T> top = list.removeFirst();
			if(sameTree(top, small)) return true;
			if(top.left != null) list.add(top.left);
			if(top.right != null) list.add(top.right);
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// it is quiet hard to create a unit test.
	}

}
