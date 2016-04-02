package coding;

import cracking._04_treeandgraph.TreeNode;

public class _24_SequenceOfBST {
	
	public static boolean preOrderOfTree(TreeNode<Integer> tree, int[] array){
		if(tree.val != array[array.length-1]) return false;
		return isOk(tree, array, 0, array.length-1);
	}
	
	private static boolean isOk(TreeNode<Integer> tree, int[] array, int left, int right){
		if(array[right]!=tree.val) return false;
		if(tree.right==null && tree.left==null){
			return left == right;
		}
		if(tree.left!= null && tree.right==null){
			return isOk(tree.left,array,left,right-1);
		}
		if(tree.left == null && tree.right!= null){
			return isOk(tree.right, array,left,right-1);
		}
		int index = -1;
		for(int i = left; i<right; i++){
			if(array[i] == tree.left.val){
				index = i;
			}
		}
		return isOk(tree.left, array,left,index) && isOk(tree.right, array, index+1,right-1);
	}
	
	public static boolean sequenceOfBST(int[] array){
		return isBSTOk(array, 0, array.length-1);
	}
	
	private static boolean isBSTOk(int[] array, int left, int right){
		if(left >= right) return true;
		int lastVal = array[right];
		int mid = left;
		while(array[mid]<lastVal){
			mid++;
		}
		for(int i = mid;i<right;i++){
			if(array[i]<lastVal) return false;
		}
		return isBSTOk(array, 0, mid-1) && isBSTOk(array, mid, right-1);
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
		
		int[] array = new int[]{4,5,2,6,3,1};
		int[] aa = new int[]{4,5,6,2,3,1};
		
		System.out.println(preOrderOfTree(n1,array));
		System.out.println(preOrderOfTree(n1,aa));
		
		array = new int[]{1,5,4,8,12,10,6};
		aa = new int[]{1,5,4,8,12,5,6};
		
		System.out.println(sequenceOfBST(array));
		System.out.println(sequenceOfBST(aa));
	}

}
