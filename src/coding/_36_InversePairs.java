package coding;

public class _36_InversePairs {
	
	public static int inversePairs(int[] args){
		if(args == null || args.length<2) return 0;
		int[] aux = new int[args.length];
		return count(args,0, args.length-1,aux);
	}
	
	private static int count(int[] array, int left, int right, int[] aux){
		if(left == right) return 0;
		int mid = (right-left)/2+left;
		int lc = count(array,left, mid,aux);
		int rc = count(array, mid+1, right,aux);
		int mc = 0;
		int l_start = left;
		int r_start = mid+1;
		for(int i = left; i<right+1;i++){
			if(l_start == mid+1){
				aux[i] = array[r_start++];
			}else if(r_start == right+1){
				aux[i] = array[l_start++];
			}else if(array[l_start]<=array[r_start]){
				aux[i] = array[l_start++];
			}else{
				aux[i] = array[r_start++];
				mc+=(mid-l_start+1);
			}
		}
		for(int i = left; i<=right;i++){
			array[i] = aux[i];
		}
		return lc+rc+mc;
	}

	public static void main(String[] args) {
		int[] array = new int[]{7,5,6,4};
		System.out.println(inversePairs(array));
	}

}
