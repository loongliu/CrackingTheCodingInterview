package coding;

import java.util.LinkedList;

import cracking._04_treeandgraph.TreeNode;

public class _23_PrintTree {
	
	public static void printTree(TreeNode<Integer> root){
		if(root == null) return;
		LinkedList<TreeNode<Integer>> list = new LinkedList<>();
		list.add(root);
		list.add(null);
		while(list.size()>1){
			TreeNode<Integer> node = list.removeFirst();
			if(node == null){
				System.out.println();
				list.add(null);
				continue;
			}
			System.out.print(node.val+" ");
			if(node.left != null) list.add(node.left);
			if(node.right != null) list.add(node.right);
		}
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
		
		printTree(n1);
	}

}
