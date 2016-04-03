package coding;

public class _42_ReverseString {
	
	public static void reverseWordsInSentence(char[] array){
		reverse(array, 0, array.length-1);
		int fir = 0;
		for(int i = 0; i<array.length; i++){
			if(array[i]==' '){
				if(i == fir){
					fir++;
					continue;
				}
				reverse(array,fir,i-1);
				fir = i+1;
			}
		}
	}
	
	private static void reverse(char[] array, int left, int right){
		while(left<right){
			char tmp = array[left];
			array[left++] = array[right];
			array[right--] = tmp;
		}
	}
	
	public static void rotate(char[] array, int k){
		k = k % array.length;
		reverse(array, 0, array.length-1);
		reverse(array, 0, array.length-1-k);
		reverse(array, array.length-k,array.length-1);
	}

	public static void main(String[] args) {
		char[] array = "I am a student.".toCharArray();
		reverseWordsInSentence(array);
		System.out.println(new String(array));
		
		array = "abcedfgh".toCharArray();
		rotate(array,2);
		System.out.println(new String(array));
	}

}
