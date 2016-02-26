package cracking._03_stackandqueue;

public class _03_01_ThreeStack {
	int[] array;
	int capacity;
	int maxSize;
	
	// location of the three stacks, -1 for no element
	int top1;
	int top2;
	int top3;
	
	public _03_01_ThreeStack(){
		this(9);
	}
	
	public _03_01_ThreeStack(int size){
		array = new int[size];
		capacity = size;
		top1 = -1; 
		top2 = -1;
		top3 = -1;
		maxSize = -1;
	} 
	
	int pop1(){
		if(top1==-1){
			return Integer.MIN_VALUE;
		}
		int value = array[top1];
		if(top1 > Math.max(top2, top3)){
			maxSize = Math.max(top2, top3);
		}
		trimIfNeed();
		top1-=3;
		return value;
	}
	private void trimIfNeed(){
		
	}
	
	public static void main(String[] args) {

	}

}