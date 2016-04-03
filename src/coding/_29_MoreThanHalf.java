package coding;

public class _29_MoreThanHalf {

	public static int moreThanHalf(int[] array){
		if(array== null || array.length==0) return Integer.MIN_VALUE;
		int count = 1;
		int val = array[0];
		for(int i = 1; i<array.length; i++){
			if(count == 0){
				val = array[i];
				count = 1;
			}else{
				count+= (val==array[i]?1:-1);
			}
		}
		return val;
	}
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,2,2,2,5,4,2};
		System.out.println(moreThanHalf(array));
	}

}
