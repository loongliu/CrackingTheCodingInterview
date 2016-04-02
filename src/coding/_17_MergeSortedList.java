package coding;

import cracking._02_linkedlist.Node;

public class _17_MergeSortedList {
	
	public static Node<Integer> mergeSortedList(Node<Integer> h1,Node<Integer> h2){
		if(h1==null) return h2;
		if(h2==null) return h1;
		Node<Integer> head,cur;
		if(h1.val<h2.val){
			head = h1;
			h1 = h1.next;
		}else{
			head = h2;
			h2 = h2.next;
		}
		cur = head;
		while(h1!=null || h2!=null){
			if(h1==null){
				cur.next = h2;
				cur = cur.next;
				h2 = h2.next;
			}else if(h2 == null){
				cur.next = h1;
				cur = cur.next;
				h1 = h1.next;
			}else if(h1.val<h2.val){
				cur.next = h1;
				cur = cur.next;
				h1 = h1.next;
			}else{
				cur.next = h2;
				cur = cur.next;
				h2 = h2.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> h1 = Node.fromArray(new Integer[]{1,3,5,6,7,90});
		Node<Integer> h2 = Node.fromArray(new Integer[]{2,4,8,9,10});
		System.out.println(mergeSortedList(h1,h2));
	}

}
