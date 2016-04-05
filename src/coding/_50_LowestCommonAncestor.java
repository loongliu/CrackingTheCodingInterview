package coding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import cracking._04_treeandgraph.TreeNode;

public class _50_LowestCommonAncestor {
	
	public static TreeNode<Integer> LCAOfBST(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2){
		TreeNode<Integer> small,big;
		if(node1.val>node2.val){
			small = node2;
			big = node1;
		}else{
			small = node1;
			big = node2;
		}
		if(root.val<big.val && root.val>small.val) return root;
		if(root.val<=small.val) return LCAOfBST(root.right, node1, node2);
		if(root.val>=big.val) return LCAOfBST(root.left,node1,node2);
		return null;
	}
	
	public static TreeNode<Integer> LCAOfTree(TreeNode<Integer> root, TreeNode<Integer> node1, TreeNode<Integer> node2){
		ArrayList<LinkedList<TreeNode<Integer>>> pair = new ArrayList<>(2);
		pair.add(null);pair.add(null);
		LinkedList<TreeNode<Integer>> curPath = new LinkedList<>();
		curPath.add(root);
		getPath(root,node1,node2,curPath,pair);
		LinkedList<TreeNode<Integer>> p1 = pair.get(0);
		LinkedList<TreeNode<Integer>> p2 = pair.get(1);
		if(p1==null || p2==null) return null;
		Iterator<TreeNode<Integer>> iter1 = p1.iterator(), iter2 = p2.iterator();
		TreeNode<Integer> last = null;
		while(iter1.hasNext() && iter2.hasNext()){
			TreeNode<Integer> t1 = iter1.next();
			TreeNode<Integer> t2 = iter2.next();
			if(t1== t2) last = t1;
			else break;
		}
		return last;
	}
	
	@SuppressWarnings("unchecked")
	private static void getPath(TreeNode<Integer> node,TreeNode<Integer> node1, TreeNode<Integer> node2,LinkedList<TreeNode<Integer>> curPath, ArrayList<LinkedList<TreeNode<Integer>>> pair){
		if(node==node1){
			pair.add(0,(LinkedList<TreeNode<Integer>>) curPath.clone());
		}else if(node == node2){
			pair.add(1,(LinkedList<TreeNode<Integer>>) curPath.clone());
		}
		if(pair.get(1)!=null && pair.get(2)!=null) return;
		if(node.left!=null){
			curPath.add(node.left);
			getPath(node.left,node1,node2,curPath,pair);
			curPath.removeLast();
		}
		if(node.right!=null){
			curPath.add(node.right);
			getPath(node.right,node1,node2,curPath,pair);
			curPath.removeLast();
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(6);
		TreeNode<Integer> n2 = new TreeNode<>(3);
		TreeNode<Integer> n3 = new TreeNode<>(9);
		TreeNode<Integer> n4 = new TreeNode<>(1);
		TreeNode<Integer> n5 = new TreeNode<>(4);
		TreeNode<Integer> n6 = new TreeNode<>(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		System.out.println(LCAOfBST(n1,n4,n6));
		System.out.println(LCAOfTree(n1,n4,n6));
	}

}
