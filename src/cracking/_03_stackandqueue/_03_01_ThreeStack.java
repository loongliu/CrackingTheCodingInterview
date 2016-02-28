package cracking._03_stackandqueue;

import java.util.Arrays;
import java.util.Random;

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
		capacity = Math.max(3, size);
		top1 = -1; 
		top2 = -1;
		top3 = -1;
		maxSize = -1;
	} 
	
	public int pop1(){
		if(top1==-1){
			return Integer.MIN_VALUE;
		}
		int value = array[top1];
		top1-=3;
		int max23 = Math.max(top2, top3);
		if(top1 < max23 && top1+3>max23){
			maxSize = max23;
			trimIfNeed();
		}
		return value;
	}
	
	public int pop2(){
		if(top2==-1){
			return Integer.MIN_VALUE;
		}
		int value = array[top2];
		top2-=3;
		int max13 = Math.max(top1, top3);
		if(top2 < max13 && top2+3 > max13){
			maxSize = max13;
			trimIfNeed();
		}
		return value;
	}
	
	public int pop3(){
		if(top3==-1){
			return Integer.MIN_VALUE;
		}
		int value = array[top3];
		top3-=3;
		int max12 = Math.max(top1, top2);
		if(top3 < max12 && top3 +3 > max12){
			maxSize = max12;
			trimIfNeed();
		}
		return value;
	}
	
	public int peek1(){
		if(top1==-1){
			return Integer.MIN_VALUE;
		}
		return array[top3];
	}
	
	public int peek2(){
		if(top2==-1){
			return Integer.MIN_VALUE;
		}
		return array[top2];
	}
	
	public int peek3(){
		if(top3==-1){
			return Integer.MIN_VALUE;
		}
		return array[top3];
	}
	
	public void push1(int val){
		if(top1==-1){
			top1 = 0;
		}else{
			top1+=3;
		}
		enlargeIfNeed(top1+1);
		maxSize = Math.max(top1, maxSize);
		array[top1] = val;
	}
	public void push2(int val){
		if(top2==-1){
			top2 = 1;
		}else{
			top2+=3;
		}
		enlargeIfNeed(top2+1);
		maxSize = Math.max(top2, maxSize);
		array[top2] = val;
	}
	public void push3(int val){
		if(top3==-1){
			top3 = 2;
		}else{
			top3+=3;
		}
		enlargeIfNeed(top3+1);
		maxSize = Math.max(top3, maxSize);
		array[top3] = val;
	}
	
	@Override
	public String toString(){
		StringBuilder stb = new StringBuilder();
		stb.append(Arrays.toString(array)).append("\n");
		stb.append("array.length: ").append(array.length).append("\tcapacity: ").append(capacity).append("\n");
		stb.append("[");
		for(int i = 0; i<array.length;i+=3){
			stb.append(array[i]).append("->");
		}
		stb.append("]\n");
		stb.append("[");
		for(int i = 1; i<array.length;i+=3){
			stb.append(array[i]).append("->");
		}
		stb.append("]\n");
		stb.append("[");
		for(int i = 2; i<array.length;i+=3){
			stb.append(array[i]).append("->");
		}
		stb.append("]\n");
		return stb.toString();
	}
	
	private void trimIfNeed(){
		if(maxSize*2+2<capacity){
			int[] newArray = Arrays.copyOf(array, maxSize+1);
			array = newArray;
			capacity = maxSize+1;
		}
	}
	
	private void enlargeIfNeed(int size){
		if(size > capacity){
			capacity = capacity+capacity/2+2;
			int[] newArray = Arrays.copyOf(array, capacity);
			array = newArray;
		}
	}
	
	public static void main(String[] args) {
		_03_01_ThreeStack stack = new _03_01_ThreeStack();
		Random r = new Random(System.currentTimeMillis());
		for(int i = 0; i<200;i++){
			int ran = r.nextInt(3);
			switch(ran){
			case 0:
				stack.push1(r.nextInt(100));
				break;
			case 1:
				stack.push2(r.nextInt(100));
				break;
			case 2:
				stack.push3(r.nextInt(100));
			}
			System.out.println(stack);
		}
		for(int i = 0; i<100;i++){
			int ran = r.nextInt(3);
			switch(ran){
			case 0:
				stack.pop1();
				break;
			case 1:
				stack.pop2();
				break;
			case 2:
				stack.pop3();
			}
			System.out.println(stack);
		}
	}

}