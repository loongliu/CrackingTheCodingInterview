package cracking._17_middle;

class BiNode{
	public BiNode node1, node2;
	public int data;
	
	public BiNode(int d){
		data = d;
	}
	
	public String toString(){
		return data+"";
	}
}
class Pack{
	BiNode head, tail;
	public Pack(){};
	public Pack(BiNode h, BiNode t){
		head = h;
		tail = t;
	}
}

public class _17_13_TreeToList {
	public static BiNode treeToList(BiNode root){
		Pack p1 = listPack(root);
		return p1.head;
	}
	
	private static Pack listPack(BiNode root){
		if(root == null) return new Pack(null, null);
		Pack p1 = listPack(root.node1);
		Pack p2 = listPack(root.node2);
		Pack ans = new Pack();
		if(p1.tail != null){
			p1.tail.node2 = root;
			root.node1 = p1.tail;
			ans.head = p1.head;
		}else{
			ans.head = root;
		}
		if(p2.head != null){
			root.node2 = p2.head;
			p2.head.node1 = root;
			ans.tail = p2.tail;
		}else{
			ans.tail = root;
		}
		return ans;
	}
	
	public static void main(String[] args){
		BiNode n1 = new BiNode(6);
		BiNode n2 = new BiNode(4);
		BiNode n3 = new BiNode(9);
		BiNode n4 = new BiNode(2);
		BiNode n5 = new BiNode(5);
		BiNode n6 = new BiNode(8);
		n1.node1 = n2; n1.node2 = n3;
		n2.node1 = n4; n2.node2 = n5;
		n3.node1 = n6;
		BiNode head = treeToList(n1);
		System.out.println(head);
	}
}
