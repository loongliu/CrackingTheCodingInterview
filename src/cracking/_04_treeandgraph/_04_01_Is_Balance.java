package cracking._04_treeandgraph;
/**
 * this problem is same as leetcode problem
 * https://leetcode.com/problems/balanced-binary-tree/
 * and the answer has been proved true by leetcode submission
 * so the unit test is quit sample
 * @author liujilong.me@gmail.com
 *
 */
public class _04_01_Is_Balance {
	/**
	 * check the node is balanced. we define a tree is balanced when
	 * the differents of thwo heights of two child trees of any node in this tree 
	 * is smaller than 2;
	 * @param the root node of this tree
	 * @return -1 if this node is not balanced. 
	 * 0 if this node is null.
	 * value larger than 1 if this node is balanced, 
	 * and the value represents the height of this node
	 */
	static int isBalanced(TreeNode<Integer> node){
		if(node == null) return 0;
		int leftHeight = isBalanced(node.left);
		int rightHeight = isBalanced(node.right);
		if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight)>1) 
			return -1;
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public static void main(String[] args){
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		TreeNode<Integer> n4 = new TreeNode<>(4);
		n1.left = n2; n1.right = n3; n2.left = n4;
		System.out.println(isBalanced(n1)>=0);
	}
}
