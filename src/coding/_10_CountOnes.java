package coding;

public class _10_CountOnes {
	
	public static int countOnes(int val){
		int count = 0;
		while(val!=0){
			val = val&(val-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countOnes(0));
		System.out.println(countOnes(0xffffffff));
	}

}
