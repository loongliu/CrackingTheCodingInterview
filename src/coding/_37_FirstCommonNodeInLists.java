package coding;

import cracking._02_linkedlist.Node;

public class _37_FirstCommonNodeInLists {
	
	public static Node<Integer> firstCommonNode(Node<Integer> head1, Node<Integer> head2){
		int len1 = length(head1);
		int len2 = length(head2);
		Node<Integer> longNode, shortNode;
		if(len1>len2){
			longNode = head1;
			shortNode = head2;
		}else{
			longNode = head2;
			shortNode = head1;
		}
		int dif = Math.abs(len1-len2);
		for(int i = 0; i<dif; i++){
			longNode = longNode.next;
		}
		while(longNode!=null && shortNode!=null && longNode!=shortNode){
			longNode = longNode.next;
			shortNode = shortNode.next;
		}
		return longNode;
	}
	
	private static int length(Node<Integer> head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		Node<Integer> n1 = Node.fromArray(new Integer[]{1,2,3,4,5});
		Node<Integer> n2 = new Node<Integer>(13);
		Node<Integer> n3 = new Node<Integer>(14);
		n2.next = n3;
		n3.next = n1.next.next.next;
		System.out.println(firstCommonNode(n1,n2));
	}

}
