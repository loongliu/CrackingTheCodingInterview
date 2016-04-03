package coding;

import cracking._04_treeandgraph.TreeNode;

public class _39_DepthOfTree {

	public static int depth(TreeNode<Integer> root){
		if(root == null) return 0;
		return Math.max(depth(root.left),depth(root.right))+1;
	}
	
	public static boolean isbalanced(TreeNode<Integer> root){
		int[] height = new int[1];
		return isbalanced(root, height);
	}
	
	private static boolean isbalanced(TreeNode<Integer> root, int[]height){
		if(root == null){
			height[0] = 0;
			return true;
		}
		int[] left = new int[1];
		int[] right = new int[1];
		if(isbalanced(root.left, left)&&isbalanced(root.right, right)){
			if(left[0]-right[0]<=1 && left[0]-right[0]>=-1){
				height[0] = Math.max(left[0], right[0])+1;
				return true;
			}
		}
		return false;
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
		n4.right = n5;
		n5.left = n6;
		System.out.println(isbalanced(n1));
	}

}
