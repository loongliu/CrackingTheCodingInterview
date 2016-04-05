package coding;

public class _51_DuplicateKeyInArray {
	
	public static int duplicateKey(int[] array){
		int len = array.length;
		int[] aux = new int[len];
		for(int i =0;i<len;i++) aux[i]=0;
		for(int num : array){
			if(aux[num]!=0) return num;
			aux[num]++;
		}
		return -1;
	}
	
	public static int duplicateKey2(int[] array){
		if(array == null||array.length==0) return -1;
		int len = array.length;
		for(int num : array)
			if(num<0||num>=len) return -1;
		for(int i = 0;i<len;i++){
			while(array[i]!=i){
				if(array[i]==array[array[i]]) return array[i];
				int tmp = array[i];
				array[i] = array[tmp];
				array[tmp] = tmp;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[]{2,3,1,0,2,5,3};
		System.out.println(duplicateKey(array));
		System.out.println(duplicateKey2(array));
	}

}
