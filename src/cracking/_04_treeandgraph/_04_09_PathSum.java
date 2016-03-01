package cracking._04_treeandgraph;

import java.util.LinkedList;
import java.util.ListIterator;

public class _04_09_PathSum {
	
	public static void paths(TreeNode<Integer> root, int sum){
		LinkedList<Integer> path = new LinkedList<>();
		path.add(root.val);
		search(root, path,sum);
	}
	private static void search(TreeNode<Integer> root, LinkedList<Integer> path, int sum){
		checkPath(path,sum);
		if(root.left != null) {
			path.add(root.left.val);
			search(root.left, path,sum);
			path.removeLast();
		}
		if(root.right != null){
			path.add(root.right.val);
			search(root.right, path,sum);
			path.removeLast();
		}
	}
	private static void checkPath(LinkedList<Integer> path, int sum){
		int tot = 0;
		ListIterator<Integer> i = path.listIterator(path.size());
		while(i.hasPrevious()){
			tot += i.previous();
			if(tot>sum) return;
			if(tot == sum){
				StringBuilder sb = new StringBuilder();
				while(i.hasNext()){
					sb.append(i.next()).append(" ");
				}
				sb.append("\n");
				System.out.println(sb);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		TreeNode<Integer> root = _04_03_BalancedTree.balance(array, 0, array.length-1);
		System.out.println(root);
		paths(root,12);
	}

}
