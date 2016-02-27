package cracking._03_stackandqueue;

public class _03_03_SetOfStack<T> {
	private Stack<Stack<T>> setOfStack;
	private int maxLength;
	
	public _03_03_SetOfStack(){
		this(10);
	}
	
	public _03_03_SetOfStack(int maxlength){
		setOfStack = new Stack<>();
		this.maxLength = maxlength;
	}
	
	public T peek(){
		Stack<T> topStack = setOfStack.peek();
		return topStack.peek();
	}
	
	public void push(T val){
		Stack<T> topStack = setOfStack.peek();
		if(topStack == null || topStack.length() == maxLength){
			Stack<T> stack = new Stack<>();
			stack.push(val);
			setOfStack.push(stack);
		}else{
			topStack.push(val);
		}
	}
	public T pop(){
		Stack<T> topStack = setOfStack.peek();
		T val = topStack.pop();
		if(val == null){
			setOfStack.pop();
			topStack = setOfStack.peek();
			val = topStack.pop();
		}
		return val;
	}
	
	public String toString(){
		return setOfStack.toString("\n");
	}
	

	public static void main(String[] args) {
		_03_03_SetOfStack<Integer> stack = new _03_03_SetOfStack<>();
		for(int i = 0; i<89; i++){
			stack.push(i);
		}
		System.out.println(stack);
		for(int i = 0; i<24; i++){
			stack.pop();
		}
		System.out.println(stack);
	}

}
