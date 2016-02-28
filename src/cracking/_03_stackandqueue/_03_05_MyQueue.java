package cracking._03_stackandqueue;

import java.util.Random;

public class _03_05_MyQueue<T> {
	Stack<T> head;
	Stack<T> tail;
	public _03_05_MyQueue(){
		head = new Stack<>();
		tail = new Stack<>();
	}
	public void enqueue(T val){
		tail.push(val);
	}
	public T dequeue(){
		T res = head.pop();
		if(res != null){
			return res;
		}
		T cpy = tail.pop();
		while(cpy!=null){
			head.push(cpy);
			cpy = tail.pop();
		}
		return head.pop();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("MyQueue: ").append(head).append(" ||| ").append(tail.reverseString());
		return sb.toString();
	}
	
	public static void main(String[] args){
		_03_05_MyQueue<Integer> queue = new _03_05_MyQueue<>();
		System.out.println(queue);
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i<100;i++){
			int r = rand.nextInt(3);
			if(r==0){
				queue.dequeue();
			}else{
				queue.enqueue(rand.nextInt(100));
			}
			System.out.println(queue);
		}
	}
}
