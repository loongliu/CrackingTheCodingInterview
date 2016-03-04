package cracking._05_bitoperation;

public class _05_05_DifferentBitCount {

	//c=c&(c-1); clear the least effective bit
	public static int countDifferent(int a, int b){
		int count = 0;
		for(int c = a^b; c!=0; c=c&(c-1)){
			count++;
		}
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(countDifferent(31,32));
	}
}
