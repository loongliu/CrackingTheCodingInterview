package cracking._04_treeandgraph;
/**
 * same as the leetcode problem 236
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author liujilong.me@gmail.com
 */
public class _04_07_LowestCommonAncestor {
	
	public static <T> TreeNode<T> lowestCommonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
		if(root == null || root == p || root == q) return root;
		TreeNode<T> left = lowestCommonAncestor(root.left, p,q);
		TreeNode<T> right = lowestCommonAncestor(root.right, p, q);
		if(left!=null && right!=null) return root;
		return left!=null ? left : right;
	}

	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,};
		TreeNode<Integer> root = _04_03_BalancedTree.balance(array, 0, array.length-1);
		System.out.println(root);
		TreeNode<Integer> p = root.right.right;
		TreeNode<Integer> q = root.right.left.right;
		System.out.println(lowestCommonAncestor(root, p,q).val);
	}

}
