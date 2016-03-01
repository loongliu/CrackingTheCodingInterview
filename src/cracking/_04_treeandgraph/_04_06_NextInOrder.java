package cracking._04_treeandgraph;

class Node {
	int val;
	Node left;
	Node right;
	Node parent;
	public Node(int val){
		this.val = val;
	}
	public String toString(){
		return val+"";
	}
}


public class _04_06_NextInOrder {
	
	public static Node nextInOrder(Node n){
		if(n == null) return null;
		if(n.right != null) return minInTree(n.right);
		Node cur = n;
		while(cur.parent != null){
			if(cur.parent.left == cur) return cur.parent;
			cur = cur.parent;
		}
		return null;
	}
	
	private static Node minInTree(Node root){
		Node cur = root;
		while(cur.left!=null){
			cur = cur.left;
		}
		return cur;
	}

	public static void main(String[] args) {
		Node n4 = new Node(4);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.left = n2; n1.right = n3;
		n2.parent = n1; n3.parent = n1;
		n4.right = n1; n1.parent = n4;
		System.out.println(nextInOrder(n3));
	}
}
