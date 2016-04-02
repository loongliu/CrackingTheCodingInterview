package coding;

import java.util.LinkedList;

import cracking._04_treeandgraph.TreeNode;

public class _25_PathInTree {
	
	// large memory consume
	public static void printPathInTree(TreeNode<Integer> root, int val){
		if(root == null) return;
		print(root,val, new LinkedList<Integer>());
	}
	
	private static void print(TreeNode<Integer> root, int val, LinkedList<Integer> list){
		LinkedList<Integer> newList = new LinkedList<>(list);
		newList.add(root.val);
		if(root.left==null && root.right == null && root.val == val){
			System.out.println(newList);
			return;
		}
		if(root.left!=null){
			print(root.left,val-root.val, newList);
		}
		if(root.right != null){
			print(root.right, val-root.val, newList);
		}
	}
	
	// small memory consume
	public static void printPath(TreeNode<Integer> root, int val){
		if(root == null) return;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(root.val);
		print2(root, val-root.val, list);
	}
	
	private static void print2(TreeNode<Integer> root, int val, LinkedList<Integer> list){
		if(root.left==null && root.right == null && val==0){
			System.out.println(list);
			return;
		}
		if(root.left!=null){
			list.add(root.left.val);
			print2(root.left, val-root.left.val, list);
			list.removeLast();
		}
		if(root.right!=null){
			list.add(root.right.val);
			print2(root.right,val-root.right.val, list);
			list.removeLast();
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(10);
		TreeNode<Integer> n2 = new TreeNode<>(5);
		TreeNode<Integer> n3 = new TreeNode<>(12);
		TreeNode<Integer> n4 = new TreeNode<>(4);
		TreeNode<Integer> n5 = new TreeNode<>(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		printPathInTree(n1, 22);
		printPath(n1, 22);
	}

}
