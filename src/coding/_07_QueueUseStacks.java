package coding;

import cracking._03_stackandqueue.Stack;

public class _07_QueueUseStacks {
	
	static Stack<Integer> tail = new Stack<Integer>();
	static Stack<Integer> head = new Stack<Integer>();
	
	public static void enqueue(int val){
		tail.push(val);
	}
	public static int dequeue(){
		if(head.peek()==null){
			transform();
			return head.pop();
		}
		return head.pop();
	}

	
	private static void transform(){
		while(tail.peek()!=null){
			head.push(tail.pop());
		}
	}
	
	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		System.out.println(dequeue());
		enqueue(4);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		enqueue(5);
		enqueue(6);
		enqueue(7);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		enqueue(8);
		System.out.println(dequeue());
	}

}
