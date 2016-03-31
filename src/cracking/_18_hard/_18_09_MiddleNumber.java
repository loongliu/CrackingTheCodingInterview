package cracking._18_hard;

import java.util.ArrayList;

public class _18_09_MiddleNumber {
	static ArrayList<Integer> minHeap = new ArrayList<>();
	static ArrayList<Integer> maxHeap = new ArrayList<>();
	public static int middleAfferAdd(int val){
		if(minHeap.size() == 0) {
			minHeap.add(val);
			return val;
		}
		if(val>=minHeap.get(0)){
			addToMinHeap(val);
		}else{
			addToMaxHeap(val);
		}
		return minHeap.get(0);
	}
	
	private static void addToMinHeap(int val){
		minHeap.add(val);
		for(int i = minHeap.size()-1; i>0;i=(i-1)/2){
			if(minHeap.get((i-1)/2)<minHeap.get(i)) break;
			exchange(minHeap,i,(i-1)/2);
		}
		if(minHeap.size()-maxHeap.size()>1){
			addToMaxHeap(minHeap.get(0));
			minHeap.set(0,minHeap.get(minHeap.size()-1));
			minHeap.remove(minHeap.size()-1);
			if(minHeap.size()==1) return;
			for(int i = 0;i<=(minHeap.size()-1-1)/2;i++){
				if(2*i+2 == minHeap.size() || minHeap.get(2*i+1)<minHeap.get(2*i+2)){
					if(minHeap.get(2*i+1)<minHeap.get(i)){
						exchange(minHeap,i,2*i+1);
						i = 2*i+1;
					}
				}else{
					if(minHeap.get(2*i+2)<minHeap.get(i)){
						exchange(minHeap,i,2*i+2);
						i = 2*i+2;
					}
				}
			}
		}
	}
	
	private static void addToMaxHeap(int val){
		maxHeap.add(val);
		for(int i = maxHeap.size()-1; i>0;i=(i-1)/2){
			if(maxHeap.get((i-1)/2)>maxHeap.get(i)) break;
			exchange(maxHeap,i,(i-1)/2);
		}
		if(maxHeap.size()>minHeap.size()){
			addToMinHeap(maxHeap.get(0));
			maxHeap.set(0,maxHeap.get(maxHeap.size()-1));
			maxHeap.remove(maxHeap.size()-1);
			if(maxHeap.size()==1) return;
			for(int i = 0;i<=(maxHeap.size()-1-1)/2;i++){
				if(2*i+2 == maxHeap.size() || maxHeap.get(2*i+1)>maxHeap.get(2*i+2)){
					if(maxHeap.get(2*i+1)>maxHeap.get(i)){
						exchange(maxHeap,i,2*i+1);
						i = 2*i+1;
					}
				}else{
					if(maxHeap.get(2*i+2)>maxHeap.get(i)){
						exchange(maxHeap,i,2*i+2);
						i = 2*i+2;
					}
				}
			}
		}
	}
	
	private static void exchange(ArrayList<Integer> list, int k, int g){
		int tmp = list.get(k);
		list.set(k, list.get(g));
		list.set(g,tmp);
	}
	

	
	public static void main(String[] args){
		int[] array = new int[]{8,7,6,5,4,3,2,1};
		for(int i : array){
			System.out.println(middleAfferAdd(i));
		}
	}
}
