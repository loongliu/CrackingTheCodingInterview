package cracking._04_treeandgraph;

import java.util.LinkedList;

public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T val;
	public TreeNode(T val){
		this.val = val;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode<T>> list = new LinkedList<>();
		list.add(this);
		while(!list.isEmpty()){
			TreeNode<T> node = list.removeFirst();
			sb.append(node.val).append(" (");
//			if(node.left != null){
//				list.add(node.left);
//				sb.append(node.left.val).append(" ");
//			}else{
//				sb.append("null ");
//			}
			if(node.right != null){
				list.add(node.right);
				sb.append(node.right.val).append(" ");
			}else{
				sb.append("null ");
			}
			sb.append(") \n");
		}
		return sb.toString();
	}
	

}
