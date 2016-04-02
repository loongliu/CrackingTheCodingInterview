package coding;

import java.util.HashMap;

import cracking._04_treeandgraph.TreeNode;

public class _06_ConstructBinaryTree {

	public static <T> TreeNode<T> constructTree(T[] preorder, T[] inorder){
		HashMap<T,Integer> map = new HashMap<>();
		for(int i = 0; i<inorder.length; i++){
			map.put(inorder[i], i);
		}
		return resolve(preorder,0, inorder,0, inorder.length-1, map);
	}
	
	private static <T> TreeNode<T> resolve(T[] preorder, int ps, T[] inorder, int is, int iend, HashMap<T,Integer> map){
		if(is > iend) return null;
		TreeNode<T> node = new TreeNode<>(preorder[ps]);
		int index = map.get(preorder[ps]);
		node.left = resolve(preorder, ps+1, inorder,is,index-1,map);
		node.right = resolve(preorder, index+1-is+ps, inorder, index+1,iend,map);
		return node;
	}
	
	public static void main(String[] args) {
		Integer[] preorder = new Integer[]{1,2,4,5,3,6};
		Integer[] inorder = new Integer[]{4,2,5,1,6,3};
		TreeNode<Integer> root = constructTree(preorder, inorder);
		System.out.println(root);
	}

}
