package cracking._02_linkedlist;

import java.util.LinkedList;

public class _02_07_PalindromeLinkedList {
	/**
	 * reverse LinkedList via iteration
	 * @param head head of LinkedList
	 * @return
	 */
	private static Node reverse1(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node P = null;
		Node C = head;
		Node tmp;
		while(C!=null){
			tmp = C;
			C = C.next;
			tmp.next = P;
			P = tmp;
		}
		return P;
	}

	/**
	 * reverse LinkedList via Stack
	 * @param head head of LinkedList
	 * @return
	 */
	private static Node reverse2(Node head){
		LinkedList<Node> list = new LinkedList<>();
		for(Node c = head; c!=null; c = c.next){
			list.add(c);
		}
		Node res;
		if(list.size()!=0){
			res = list.removeLast();
		}else{
			return null;
		}
		Node cur = res;
		while(list.size()!=0){
			cur.next = list.removeLast();
			cur = cur.next;
			cur.next = null;
		}
		return res;
	}
	private static Node reverse3(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node curHead = reverse3(head.next);
		head.next.next = head;
		head.next = null;
		return curHead;
	}
	
	public static void main(String[] args){
		Node nn = Node.fromAray(1,2,3,2,1);
		System.out.println(nn);
		System.out.println(reverse1(nn));
		System.out.println(reverse2(nn));
		System.out.println(reverse3(nn));
		Node n = Node.fromAray(1,2,3,2,1);
		Node n1 = n;
		Node n2 = n;
		while(n2!= null&&n2.next!=null){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		Node head = n2==null?n1.next:n1;
		Node reHead = reverse1(head);
		System.out.println(n);
		System.out.println(reHead);
		System.out.println(n.equals(reHead));
	}
}
