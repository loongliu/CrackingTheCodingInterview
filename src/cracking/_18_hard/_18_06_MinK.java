package cracking._18_hard;

import java.util.Arrays;

public class _18_06_MinK {

	public static int[] minK(int[] array, int k){
		int[] res = new int[k];
		int count = 0;
		int tmp;
		for(int val : array){
			tmp = val;
			for(int i = 0; i<count;i++){
				if(res[i]>val){
					tmp = res[count-1];
					for(int j = count-1; j>i;j--){
						res[j]=res[j-1];
					}
					res[i] = val;
					break;
				}
			}
			if(count<k) res[count++] = tmp;
		}
		return res;
	}
	
	public static int[] minK2(int[] array, int k){
		int[] res = new int[k];
		split(array,0, array.length-1, res,0,k-1);
		return res;
	}
	private static void split(int[] array, int left,int right, int[] res,int start, int end){
		if(left >= right) return;
		int part = part(array, left, right);
		if(part-start>end-start+1){
			split(array, left, part,res,start,end);
		}else if(part-start+1 == end-start+1||part-start == end-start+1){
			System.arraycopy(array,left, res, start,end-start+1);
		}else{
			System.arraycopy(array, left, res, start, part-start+1);
			split(array,part+1, right, res,start+part-left+1,end);
		}
	}
	
	/**
	 * @param start include
	 * @param end include
	 */
	private static int part(int[] array, int start, int end){
		int value = array[start];
		int left = start;
		int right = end;
		while(left<right){
			while(left<right && array[right]>=value) right--;
			if(left<right){
				array[left] = array[right];
				left++;
			}
			while(left<right && array[left]<=value) left++;
			if(left<right){
				array[right] = array[left];
				right--;
			}
		}
		array[left] = value;
		return left;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,43,453,23,45,2,14,56};
		System.out.println(Arrays.toString(minK(array,4)));
		System.out.println(Arrays.toString(minK2(array,4)));
	}

}
