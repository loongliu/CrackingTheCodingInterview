package cracking._04_treeandgraph;


class Info{
	boolean s;
	Integer min;
	Integer max;
	Info(boolean s, Integer i, Integer m){
		this.s = s; min = i; max = m;
	}
}
public class _04_05_IsSearchTree {
	
	/**
	 * check whether a tree is a search tree.
	 * @param node the root node of the tree
	 * @return whether this tree is a search tree.
	 */
	static Info isSearchTree(TreeNode<Integer> node){
		if(node == null){
			return new Info(true, null, null);
		}
		Info left = isSearchTree(node.left);
		Info right = isSearchTree(node.right);
		if(!left.s || !right.s) return new Info(false, null, null);
		if(left.max == null){
			if(right.min == null){
				return new Info(true, node.val, node.val);
			}else{
				if(node.val <= right.min){
					return new Info(true, node.val, right.max);
				}else{
					return new Info(false, null, null);
				}
			}
		}else{
			if(right.min == null){
				if(node.val >= left.max){
					return new Info(true, left.min, node.val);
				}else{
					return new Info(false, null, null);
				}
			}else{
				if(node.val >= left.max && node.val <= right.min){
					return new Info(true, left.min, right.max);
				}else{
					return new Info(false, null, null);
				}
			}
		}

	}
	
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,};
		TreeNode<Integer> root = _04_03_BalancedTree.balance(array, 0, array.length-1);
		System.out.println(root);
		System.out.println(isSearchTree(root).s);
		
		array = new Integer[]{1,12,3,4,5,6,7,8,9,10,11,12,};
		root = _04_03_BalancedTree.balance(array, 0, array.length-1);
		System.out.println(root);
		System.out.println(isSearchTree(root).s);
	}

}
