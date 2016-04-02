package coding;

import cracking._04_treeandgraph.TreeNode;

public class _19_MirrorOfTree {
	
	public static <T> void mirror(TreeNode<T> root){
		if(root == null) return;
		TreeNode<T> tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		mirror(root.left);
		mirror(root.right);
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
		System.out.println(n1);
		mirror(n1);
		System.out.println(n1);
	}
}