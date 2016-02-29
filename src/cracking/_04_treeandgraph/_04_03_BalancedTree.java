package cracking._04_treeandgraph;

public class _04_03_BalancedTree {
	static TreeNode<Integer> balance(Integer[] array, int start, int end){
		if(start == end) 
			return new TreeNode<>(array[start]);
		if(start > end) return null;
		int half = start+(end-start)/2;
		TreeNode<Integer> node = new TreeNode<>(array[half]);
		node.left = balance(array, start, half-1);
		node.right = balance(array, half+1,end);
		return node;
	}
	
	public static void main(String[] args){
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,};
		System.out.println(balance(array, 0, array.length-1));
		array = new Integer[]{1};
		System.out.println(balance(array, 0, array.length-1));
		array = new Integer[]{};
		System.out.println(balance(array, 0, array.length-1));
		array = new Integer[]{1,2,3,4,};
		System.out.println(balance(array, 0, array.length-1));
	}
}
