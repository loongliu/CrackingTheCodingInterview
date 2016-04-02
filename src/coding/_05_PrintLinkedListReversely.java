package coding;

import java.util.LinkedList;

import cracking._02_linkedlist.Node;

public class _05_PrintLinkedListReversely {
	
	public static void printLinkedList(Node<Integer> node){
		LinkedList<Node<Integer>> list = new LinkedList<>();
		while(node != null){
			list.add(node);
			node = node.next;
		}
		while(list.size()!=0){
			System.out.print(list.removeLast().val+" ");
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> node = Node.fromArray(new Integer[]{1,2,3,4,5,6,7});
		printLinkedList(node);
	}

}
