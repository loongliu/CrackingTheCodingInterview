package coding;

import cracking._03_stackandqueue.Stack;

public class _21_MinStack {
	
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> min = new Stack<Integer>();
	
	public static void push(int val){
		stack.push(val);
		if(min.peek()==null || min.peek()>=val){
			min.push(val);
		}
	}
	
	public static Integer peek(){
		return stack.peek();
	}
	
	public static Integer min(){
		return min.peek();
	}
	
	public static Integer pop(){
		if(stack.peek()==null) return null;
		int val = stack.pop();
		if(val == min.peek()){
			min.pop();
		}
		return val;
	}
	
	public static void main(String[] args){
		push(5);
		push(4);
		push(8);
		push(2);
		System.out.println(min());
		pop();
		System.out.println(min());
	}
}
