package cracking._04_treeandgraph;

import java.util.LinkedList;
/**
 * quiet similar with leetcode problem 117
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author liujilong.me@gmail.com
 *
 */
public class _04_04_TreeToLinkedList {
	static LinkedList<LinkedList<TreeNode<Integer>>> toLinkedList(TreeNode<Integer> root){
		LinkedList<LinkedList<TreeNode<Integer>>> res = new LinkedList<>();
		LinkedList<TreeNode<Integer>> firstList = new LinkedList<>();
		firstList.add(root);
		res.add(firstList);

		LinkedList<TreeNode<Integer>> cur = firstList;
		while(!cur.isEmpty()){
			LinkedList<TreeNode<Integer>> list = new LinkedList<>();
			for(TreeNode<Integer> node : cur){
				if(node.left!=null) list.add(node.left);
				if(node.right!=null) list.add(node.right);
			}
			if(!list.isEmpty()) res.add(list);
			cur = list;
		}
		return res;
	}
	
	public static void main(String[] args){
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,156};
		TreeNode<Integer> root = _04_03_BalancedTree.balance(array, 0, array.length-1);
		System.out.println(root);
		LinkedList<LinkedList<TreeNode<Integer>>> res = toLinkedList(root);
		StringBuilder sb = new StringBuilder();
		for(LinkedList<TreeNode<Integer>> list : res){
			for(TreeNode<Integer> node : list){
				sb.append(node.val).append(" ").append("->");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
