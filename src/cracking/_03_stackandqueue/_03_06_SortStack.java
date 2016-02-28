package cracking._03_stackandqueue;
/**
 * sort a stack (the largest number on the top), with help of only one extra stack
 * @author liujilong.me@gmail.com
 */
public class _03_06_SortStack {
	Stack<Integer> src;
	Stack<Integer> store;
	Integer tmp;
	
	public _03_06_SortStack(){
		src = new Stack<>();
		store = new Stack<>();
	}
	
	public void setSrc(Integer[] array){
		src = new Stack<>(array);
	}
	
	public void sortStack(){
		System.out.println(this);
		while(!src.isEmpty()){
			store.push(src.pop());
		}
		System.out.println(this);
		while(!store.isEmpty()){
			tmp = store.pop();
			System.out.println(this);
			while(!src.isEmpty()&&src.peek()>tmp){
				store.push(src.pop());
				System.out.println(this);
			}
			src.push(tmp);
			tmp = null;
			System.out.println(this);
			while(!store.isEmpty() && store.peek() > src.peek()){
				src.push(store.pop());
				System.out.println(this);
			}
		}
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(tmp != null) sb.append("Tmp   : ").append(tmp).append("\n");
		sb.append("Src   : ").append(src).append("\n");
		sb.append("Store : ").append(store).append("\n\n");
		return sb.toString();
	}
	
	public static void main(String[] args){
		_03_06_SortStack sortStack = new _03_06_SortStack();
		sortStack.setSrc(new Integer[]{32,4,21,6,10,8,5,40});
		sortStack.sortStack();
	}
}
