package coding;

import cracking._04_treeandgraph.TreeNode;

public class _18_SubStructureInTree {
	
	public static <T> boolean isSubTree(TreeNode<T> large, TreeNode<T> small){
		if(same(large, small)) return true;
		if(same(large.left, small)) return true;
		if(same(large.right, small)) return true;
		return false;
	}
	
	private static <T> boolean same(TreeNode<T> large, TreeNode<T> small){
		if(large == null || small == null) return false;
		if(!large.val.equals(small.val)) return false;
		if(small.left!=null){
			if(!same(large.left,small.left)) return false;
		}
		if(small.right != null){
			if(!same(large.right,small.right)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		TreeNode<Integer> n4 = new TreeNode<>(4);
		TreeNode<Integer> n5 = new TreeNode<>(5);
		TreeNode<Integer> n6 = new TreeNode<>(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		

		TreeNode<Integer> n7 = new TreeNode<>(2);
		TreeNode<Integer> n8 = new TreeNode<>(4);
		TreeNode<Integer> n9 = new TreeNode<>(5);
		n7.left = n8;
		n7.right = n9;
		System.out.println(isSubTree(n1,n7));
	}

}
