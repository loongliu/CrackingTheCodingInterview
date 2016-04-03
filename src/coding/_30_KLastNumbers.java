package coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _30_KLastNumbers {
	
	public static List<Integer> kLastNumbers(int[] array,int k){
		ArrayList<Integer> res = new ArrayList<>(k);
		if(array==null||k>array.length||k<0) return res;
		int left = 0, right =array.length-1;
		int index = part(array, left, right);
		while(index!= k-1){
			if(index<k-1){
				left = index+1;
				index = part(array, left,right);
			}else{
				right = index-1;
				index = part(array,left,right);
			}
		}
		for(int i = 0; i<k; i++){
			res.add(array[i]);
		}
		return res;
	}
	
	
	private static int part(int[] array, int left, int right){
		int val = array[left];
		int start = left;
		int end = right;
		while(start<end){
			while(start<end && array[end]>val) end--;
			if(start<end){
				array[start] = array[end];
				start++;
			}
			while(start<end && array[start]<val) start++;
			if(start<end){
				array[end] = array[start];
				end--;
			}
		}
		array[start] = val;
		return start;
	}

	public static List<Integer> kLast(int[] array, int k){
		LinkedList<Integer> res = new LinkedList<Integer>();
		if(array==null||k>array.length||k<0) return res;
		for(int number : array){
			if(res.size()>=k){
				if(number<res.getLast()){
					res.removeLast();
				}else{
					continue;
				}
			}
			int size = res.size();
			for(int i = 0; i<=size; i++){
				if(i == res.size()){
					res.add(number);
				}else if(number<res.get(i)){
					res.add(i,number);
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,4,2,6,3,78,3,4};
		System.out.println(kLast(array,4));
		System.out.println(kLastNumbers(array,4));
	}

}
