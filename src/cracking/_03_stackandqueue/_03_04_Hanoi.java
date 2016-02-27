package cracking._03_stackandqueue;

public class _03_04_Hanoi {

	Stack<Integer> src;
	Stack<Integer> tmp;
	Stack<Integer> dest;
	int size;
	
	public _03_04_Hanoi(int size){
		this.size = size;
	}
	
	private void hanoi(){
		src = new Stack<>();
		tmp = new Stack<>();
		dest = new Stack<>();
		for(int i = size; i>0;i--){
			src.push(i);
		}
		System.out.println(this);
		step(src,dest,tmp,size);
	}
	
	private void step(Stack<Integer> s, Stack<Integer> d, Stack<Integer> tmp, int n){
		if(n == 1){
			d.push(s.pop());
			System.out.println(this);
			return;
		}
		step(s,tmp,d,n-1);
		d.push(s.pop());
		System.out.println(this);
		step(tmp,d,s,n-1);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("src:  ").append(src).append("\n");
		sb.append("tmp:  ").append(tmp).append("\n");
		sb.append("dest: ").append(dest).append("\n\n\n");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		_03_04_Hanoi hanoi = new _03_04_Hanoi(4);
		hanoi.hanoi();
		
	}

}
