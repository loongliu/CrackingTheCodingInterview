package coding;

public class _28_PrintPermutation {
	
	public static void print(char[] array){
		if(array == null || array.length==0) return;
		print(array,0);
	}
	
	private static void print(char[] array, int index){
		if(index == array.length-1){
			for(char c : array){
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		for(int i = index; i<array.length; i++){
			exchange(array, index, i);
			print(array, index+1);
			exchange(array, index, i);
		}
	}
	
	private static void exchange(char[] array, int i, int j){
		char t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void main(String[] args) {
		print("abc".toCharArray());
	}

}
