 package coding;

import cracking._02_linkedlist.Node;

public class _15_KthNodeFromEnd {

	public static <T> Node<T> kthNodeFromEnd(Node<T> head, int k){
		Node<T> fast, slow;
		fast = head;
		slow = head;
		for(int i = 0; i<=k; i++,fast = fast.next){
			if(fast == null) return null;
		}
		while(fast!=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		Node<Integer> node = null;
		System.out.println(kthNodeFromEnd(node,0));
		
		node = Node.fromArray(new Integer[]{1,2,3});
		System.out.println(kthNodeFromEnd(node,0));
		System.out.println(kthNodeFromEnd(node,1));
		System.out.println(kthNodeFromEnd(node,2));
		System.out.println(kthNodeFromEnd(node,3));
		System.out.println(kthNodeFromEnd(node,4));
	}

}
