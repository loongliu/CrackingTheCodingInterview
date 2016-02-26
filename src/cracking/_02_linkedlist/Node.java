package cracking._02_linkedlist;

public class Node {
	public Node next = null;
	public int val;
	
	public Node(){
		this(0);
	}
	
	public Node(int d){
		val = d;
	}
	
	public Node getLast(){
		Node cur = this;
		while(cur.next!=null){
			cur = cur.next;
		}
		return cur;
	}
	
	public static Node fromAray(int... array){
		if(array == null || array.length == 0){
			return null;
		}
		Node head = new Node(array[0]);
		Node cur = head;
		for(int i = 1; i<array.length; i++){
			cur.next = new Node(array[i]);
			cur = cur.next;
		}
		return head;
	}
	
	public static Node fromArray(int[] array){
		if(array == null || array.length == 0){
			return null;
		}
		Node head = new Node(array[0]);
		Node cur = head;
		for(int i = 1; i<array.length; i++){
			cur.next = new Node(array[i]);
			cur = cur.next;
		}
		return head;
	}
	
	@Override
	public boolean equals(Object n){
		if(n==null || !(n instanceof Node)) return false;
		Node cur = this;
		Node curN = (Node) n;
		while(true){
			if(cur==null && curN!=null) return false;
			if(cur!=null && curN==null) return false;
			if(cur==null && curN == null) return true;
			if(cur.val!=curN.val) return false;
			cur = cur.next;
			curN = curN.next;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder stb = new StringBuilder();
		stb.append('[').append(this.val);
		for(Node cur = this.next; cur!=null; cur = cur.next){
			stb.append(" -> ").append(cur.val);
		}
		stb.append(']');
		return stb.toString();
	}
	
	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		System.out.println(head);
		int[] a = new int[]{1,2,3,4,5,6,7,8,12};
		System.out.print(fromArray(a));
	}
}
