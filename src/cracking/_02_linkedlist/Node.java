package cracking._02_linkedlist;

public class Node<T> {
	public Node<T> next = null;
	public T val;
	
	public Node(){
		this(null);
	}
	
	public Node(T d){
		val = d;
	}
	
	public Node<T> getLast(){
		Node<T> cur = this;
		while(cur.next!=null){
			cur = cur.next;
		}
		return cur;
	}
	

	
	public static <T> Node<T> fromArray(T[] array){
		if(array == null || array.length == 0){
			return null;
		}
		Node<T> head = new Node<T>(array[0]);
		Node<T> cur = head;
		for(int i = 1; i<array.length; i++){
			cur.next = new Node<T>(array[i]);
			cur = cur.next;
		}
		return head;
	}
	
	public int length(){
		if(next == null){
			return 1;
		}else{
			return 1+ next.length();
		}
	}

	public String toString(String deli){
		StringBuilder stb = new StringBuilder();
		stb.append('[').append(this.val);
		for(Node<T> cur = this.next; cur!=null; cur = cur.next){
			stb.append("\n").append(cur.val);
		}
		stb.append(']');
		return stb.toString();
	}
	
	public String reverseString(){
		StringBuilder stb = new StringBuilder();
		stb.insert(0,']').insert(0,this.val);
		for(Node<T> cur = this.next; cur!=null; cur = cur.next){
			stb.insert(0," <- ").insert(0,cur.val);
		}
		stb.insert(0,'[');
		return stb.toString();
	}
	
	@Override
	public String toString(){
		StringBuilder stb = new StringBuilder();
		stb.append('[').append(this.val);
		for(Node<T> cur = this.next; cur!=null; cur = cur.next){
			stb.append(" -> ").append(cur.val);
		}
		stb.append(']');
		return stb.toString();
	}
	
	public static void main(String[] args){
		Node<Integer> head = new Node<>(1);
		head.next = new Node<Integer>(2);
		head.next.next = new Node<Integer>(4);
		System.out.println(head);
		Integer[] a = new Integer[]{1,2,3,4,5,6,7,8,12};
		System.out.print(fromArray(a));
	}
}
