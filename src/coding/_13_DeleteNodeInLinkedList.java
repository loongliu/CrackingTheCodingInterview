package coding;

import cracking._02_linkedlist.Node;

public class _13_DeleteNodeInLinkedList {
	
	public static <T> Node<T> delete(Node<T> head, Node<T> toDelete){
		if(head == null || toDelete == null) return null;
		if(toDelete.next!=null){
			toDelete.val = toDelete.next.val;
			toDelete.next = toDelete.next.next;
		}else{
			if(head == toDelete) return null;
			Node<T> cur = head;
			while(cur.next != toDelete){
				cur = cur.next;
			}
			cur.next = null;
		}
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> n;
		n = Node.fromArray(new Integer[]{1,2,3});
		System.out.println(n);
		n = delete(n,n);
		System.out.println(n);
		

		n = Node.fromArray(new Integer[]{1,2,3});
		System.out.println(n);
		n = delete(n,n.next);
		System.out.println(n);
		
		n = Node.fromArray(new Integer[]{1,2,3});
		System.out.println(n);
		n = delete(n,n.next.next);
		System.out.println(n);
		
		n = Node.fromArray(new Integer[]{1});
		System.out.println(n);
		n = delete(n,n);
		System.out.println(n);
	}

}
