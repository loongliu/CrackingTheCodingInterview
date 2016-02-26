package cracking._03_stackandqueue;

import cracking._02_linkedlist.Node;

public class Stack {
	Node top;
	
	int pop(){
		if(top == null){
			return Integer.MIN_VALUE;
		}
		int item = top.val;
		top = top.next;
		return item;
	}
	int peek(){
		if(top == null){
			return Integer.MIN_VALUE;
		}
		return top.val;
	}
	void push(int val){
		Node n = new Node(val);
		n.next = top;
		top = n;
	}
	
	public String toString(){
		return top.toString();
	}
	
	public Stack(){
	}
	public Stack(int...arg){
		top = Node.fromAray(arg);
	}
	
	public static void main(String[] args){
		Stack s = new Stack(1,2,3,4);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		System.out.println(s.peek());
		s.push(10);
		System.out.println(s);
	}
}
