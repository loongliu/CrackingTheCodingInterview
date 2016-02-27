package cracking._03_stackandqueue;

public class _03_02_MinStack<T extends Comparable<T>> {
	Stack<T> stack;
	Stack<T> minStack;
	
	public _03_02_MinStack(){
		stack = new Stack<T>();
		minStack = new Stack<T>();
	}
	
	void push(T val){
		stack.push(val);
		if(minStack.peek() == null){
			minStack.push(val);
		}else{
			if(val.compareTo(minStack.peek()) <=0){
				minStack.push(val);
			}
		}
	}
	
	T pop(){
		T val = stack.pop();
		if(val == minStack.peek()){
			minStack.pop();
		}
		return val;
	}
	T min(){
		return minStack.peek();
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("stack: ").append(stack).append("\n");
		sb.append("minStack: ").append(minStack).append("\n");
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		_03_02_MinStack<Integer> stack = new _03_02_MinStack<>();
		System.out.println(stack);
		stack.push(10);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(10);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(-1);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}

}
