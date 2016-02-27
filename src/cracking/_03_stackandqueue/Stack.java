package cracking._03_stackandqueue;

import cracking._02_linkedlist.Node;

public class Stack<T> {
	Node<T> top;
	
	T pop(){
		if(top == null){
			return null;
		}
		T item = top.val;
		top = top.next;
		return item;
	}
	T peek(){
		if(top == null){
			return null;
		}
		return top.val;
	}
	void push(T val){
		Node<T> n = new Node<T>(val);
		n.next = top;
		top = n;
	}
	public int length(){
		if(top == null) return 0;
		return top.length();
	}
	
	public String toString(){
		return top!=null ? top.toString() : "null";
	}
	
	public Stack(){
	}
	public Stack(T[] arg){
		top = Node.fromArray(arg);
	}
	
	public static void main(String[] args){
		Integer[] array = new Integer[]{1,2,3,4};
		Stack<Integer> s = new Stack<>(array);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		System.out.println(s.peek());
		s.push(10);
		System.out.println(s);
	}
}
