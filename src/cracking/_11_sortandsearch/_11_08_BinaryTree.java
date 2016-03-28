package cracking._11_sortandsearch;

class Node{
	Node left;
	Node right;
	int val;
	int leftSize;
	public Node(int v){
		val = v;
	}
}


public class _11_08_BinaryTree {
	static Node root;
	
	static int getRankOfNumber(int x){
		return getNumber(root, x);
	}
	static int getNumber(Node node, int x){
		if(node == null) return 0;
		if(node.val == x) return node.leftSize;
		if(node.val > x) return getNumber(node.left, x);
		return node.leftSize+1+getNumber(node.right,x);
	}
	
	static void track(int x){
		if(root == null){
			root = new Node(x);
			return;
		}
		insertVal(root, x);
	}
	
	private static void insertVal(Node node, int x){
		if(node.val < x){
			if(node.right == null){
				node.right = new Node(x);
			}else{
				insertVal(node.right,x);
			}
		}else{
			if(node.left == null){
				node.left = new Node(x);
			}else{
				insertVal(node.left,x);
			}
			node.leftSize++;
		}
	}
	

	public static void main(String[] args) {
		track(5);
		track(1);
		track(4);
		System.out.println(getRankOfNumber(4));
		track(4);
		track(5);
		track(9);
		track(7);
		track(13);
		track(3);
		System.out.println(getRankOfNumber(1));
		System.out.println(getRankOfNumber(3));
		System.out.println(getRankOfNumber(4));
	}

}
