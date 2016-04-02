package coding;

import cracking._02_linkedlist.Node;

public class _16_ReverseList {
	static Node<Integer> sHead;
	public static Node<Integer> reverse1(Node<Integer> head){
		if(head == null) return null;
		reverseR(head);
		return sHead;
	}
	private static Node<Integer> reverseR(Node<Integer> head){
		if(head.next!=null){
			Node<Integer> cur = reverseR(head.next);
			head.next = null;
			cur.next = head;
			return head;
		}
		sHead = head;
		return sHead;
	}
	
	public static Node<Integer> reverse2(Node<Integer> head){
		if(head == null||head.next == null) return head;
		Node<Integer> middle = head.next;
		Node<Integer> slow = head;
		if(middle.next == null){
			middle.next = slow;
			slow.next = null;
			return middle;
		}
		Node<Integer> fast = middle.next;
		slow.next = null;
		while(fast!=null){
			middle.next = slow;
			slow = middle;
			middle = fast;
			fast = fast.next;
		}
		middle.next = slow;
		return middle;
	}

	public static void main(String[] args) {
		Node<Integer> node = Node.fromArray(new Integer[]{1,2,3,4,5});
		System.out.println(reverse2(node));
	}

}
