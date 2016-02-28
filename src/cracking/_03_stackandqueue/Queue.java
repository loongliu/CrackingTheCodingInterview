package cracking._03_stackandqueue;

import cracking._02_linkedlist.Node;

public class Queue<T> {
	Node<T> head;
	Node<T> tail;
	public Queue(){	}
	public Queue(T[] args){
		head = Node.fromArray(args);
		tail = head.getLast();
	}
	public void enqueue(T val){
		if(head==null){
			head = new Node<T>(val);
			tail = head;
		}else{
			tail.next = new Node<T>(val);
			tail = tail.next;
		}
	}
	public String toString(){
		return head!=null ? head.toString() : "null";
	}
	
	public T dequeue(){
		if(head == null){
			return null;
		}
		T value = head.val;
		head = head.next;
		return value;
	}
	
	public T check(){
		return head.val;
	}
}
