package coding;

public class _41_SumSequence {
	
	public static void sumPair(int[] array, int key){
		int left = 0;
		int right = array.length-1;
		int sum;
		while(left<right){
			sum = array[left]+array[right];
			if(sum==key){
				System.out.println(array[left]+" "+array[right]);
				return;
			}
			if(sum>key) right--;
			else left++;
		}
		System.out.println("no pairs");
	}
	
	public static void printSequence(int key){
		int left = 1;
		int right = 2;
		int count = 1+2;
		while(right<=(key+1)/2){
			if(count == key){
				for(int i = left; i<=right;i++) System.out.print(i+" ");
				System.out.println();
				right++;
				count+=right;
			}else if(count<key){
				right++;
				count+=right;
			}else{
				count-=left;
				left++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,4,7,11,15};
		sumPair(array,15);
		
		printSequence(901);
	}

}
