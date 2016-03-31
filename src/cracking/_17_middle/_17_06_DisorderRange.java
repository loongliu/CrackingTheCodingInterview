package cracking._17_middle;

public class _17_06_DisorderRange {
	
	public static void disorderRange(int[] array){
		int left = 0, right = array.length-1;
		for(;left<right; left++){
			boolean found = false;
			for(int j = left+1; j<=right;j++){
				if(array[left]>array[j]) {
					found = true;
					break;
				}
			}
			if(found) break;
		}
		for(; right>left;right--){
			boolean found = false;
			for(int j = 0; j<right;j++){
				if(array[j]>array[right]) {
					found = true;
					break;
				}
			}
			if(found) break;
		}
		System.out.print("("+left+","+right+")");
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,4,7,10,11,17,22,26,27,36,38,39};
		disorderRange(array);
	}

}
