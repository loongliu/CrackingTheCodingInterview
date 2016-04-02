package coding;

import cracking._03_stackandqueue.Stack;

public class _22_StackPushPopOrder {
	
	public static boolean isOrder(int[] push, int[] pop){
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for(int i : push){
			stack.push(i);
			while(index<pop.length && pop[index] == stack.peek()){
				stack.pop();
				index++;
			}
		}
		for(;index<pop.length; index++){
			Integer i = stack.pop();
			if(i==null || i != pop[index]) return false;
		}
		if(stack.pop()!= null) return false;
		return true;
	}

	public static void main(String[] args) {
		int[] push = new int[]{1,2,3,4,5};
		int[] pop = new int[]{4,3,5,1,2};
		System.out.println(isOrder(push, pop));
	}

}
