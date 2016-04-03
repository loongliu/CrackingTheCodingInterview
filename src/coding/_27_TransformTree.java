package coding;

import cracking._04_treeandgraph.TreeNode;

public class _27_TransformTree {
	
	static class Pair{
		TreeNode<Integer> head;
		TreeNode<Integer> tail;
		public Pair(TreeNode<Integer> h, TreeNode<Integer> t){
			head = h;
			tail = t;
		}
	}
	
	public static TreeNode<Integer> transfrom(TreeNode<Integer> root){
		if(root == null) return null;
		return t(root).head;
	}
	
	private static Pair t(TreeNode<Integer> root){
		if(root.left==null && root.right == null){
			return new Pair(root, root);
		}
		if(root.left!=null && root.right ==null ){
			Pair l = t(root.left);
			l.tail.right = root;
			root.left = l.tail;
			return new Pair(l.head, root);
		}
		if(root.right!=null && root.left ==null){
			Pair r = t(root.right);
			r.head.left = root;
			root.right = r.head;
			return new Pair(root, r.tail);
		}
		Pair l = t(root.left);
		Pair r = t(root.right);
		l.tail.right = root;
		root.left = l.tail;
		r.head.left = root;
		root.right = r.head;
		return new Pair(l.head, r.tail);
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
		TreeNode<Integer> head = (transfrom(n1));
		System.out.println(head);
	}

}
