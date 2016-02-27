package cracking._02_linkedlist;

import java.util.LinkedList;

public class _02_07_PalindromeLinkedList {
	/**
	 * reverse LinkedList via iteration
	 * @param head head of LinkedList
	 * @return
	 */
	private static <T> Node<T> reverse1(Node<T> head){
		if(head == null || head.next == null){
			return head;
		}
		Node<T> P = null;
		Node<T> C = head;
		Node<T> tmp;
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
	private static <T> Node<T> reverse2(Node<T> head){
		LinkedList<Node<T>> list = new LinkedList<>();
		for(Node<T> c = head; c!=null; c = c.next){
			list.add(c);
		}
		Node<T> res;
		if(list.size()!=0){
			res = list.removeLast();
		}else{
			return null;
		}
		Node<T> cur = res;
		while(list.size()!=0){
			cur.next = list.removeLast();
			cur = cur.next;
			cur.next = null;
		}
		return res;
	}
	private static <T> Node<T> reverse3(Node<T> head){
		if(head == null || head.next == null){
			return head;
		}
		Node<T> curHead = reverse3(head.next);
		head.next.next = head;
		head.next = null;
		return curHead;
	}
	
	public static void main(String[] args){
		Integer[] array = new Integer[]{1,2,3,2,1};
		Node<Integer> nn = Node.fromArray(array);
		System.out.println(nn);
		System.out.println(reverse1(nn));
		System.out.println(reverse2(nn));
		System.out.println(reverse3(nn));
		array = new Integer[]{1,2,3,2,1};
		Node<Integer> n = Node.fromArray(array);
		Node<Integer> n1 = n;
		Node<Integer> n2 = n;
		while(n2!= null&&n2.next!=null){
			n1 = n1.next;
			n2 = n2.next.next;
		}
		Node<Integer> head = n2==null?n1.next:n1;
		Node<Integer> reHead = reverse1(head);
		System.out.println(n);
		System.out.println(reHead);
		//System.out.println(n.equals(reHead));
	}
}
