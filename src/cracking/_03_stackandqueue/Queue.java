package cracking._03_stackandqueue;

import cracking._02_linkedlist.Node;

public class Queue {
	Node head;
	Node tail;
	public Queue(){	}
	public Queue(int... args){
		head = Node.fromAray(args);
		tail = head.getLast();
	}
	public void enqueue(int val){
		if(head==null){
			head = new Node(val);
			tail = head;
		}else{
			tail.next = new Node(val);
			tail = tail.next;
		}
	}
	
	public int dequeue(){
		if(head == null){
			return Integer.MIN_VALUE;
		}
		int value = head.val;
		head = head.next;
		return value;
	}
}
