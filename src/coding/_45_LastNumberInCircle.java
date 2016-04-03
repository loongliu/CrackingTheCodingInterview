package coding;

import cracking._02_linkedlist.Node;

public class _45_LastNumberInCircle {
	
	public static int lastNumber(int n, int m){
		Node<Integer> head = new Node<>(0);
		Node<Integer> cur = head;
		for(int i = 1; i<n; i++){
			cur.next = new Node<>(i);
			cur = cur.next;
		}
		cur.next = head;
		while(cur.next!=cur){
			for(int i = 0; i<m-1; i++){
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return cur.val;
	}

	public static void main(String[] args) {
		System.out.println(lastNumber(7,5));
		System.out.println(lastNumber(9,5));
	}

}
