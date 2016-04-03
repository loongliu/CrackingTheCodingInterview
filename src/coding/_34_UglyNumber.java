package coding;


public class _34_UglyNumber {
	
	public static int uglyNumber(int index){
		if(index<1) return 0;
		int[] numbers = new int[index+1];
		numbers[0] = 1;
		int index2 =0, index3=0,index5 = 0;
		for(int i = 1; i<=index; i++){
			int min = numbers[index2]*2<numbers[index3]*3?numbers[index2]*2:numbers[index3]*3;
			min = min<numbers[index5]*5?min:numbers[index5]*5;
			numbers[i] = min;
			while(numbers[index2]*2<=min) index2++;
			while(numbers[index3]*3<=min) index3++;
			while(numbers[index5]*5<=min) index5++;
		}
		return numbers[index];
	}
	


	public static void main(String[] args) {
		for(int i = 0; i<100;i++){
			System.out.println(uglyNumber(i));
		}
	}

}
