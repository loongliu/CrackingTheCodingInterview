package coding;

import java.util.HashMap;

public class _43_DicesProbability {
	
	public static void printN(int n){
		HashMap<Integer,Integer> pre = new HashMap<>(),cur;
		pre.put(0, 1);
		int total = 1;
		for(int i = 0; i<n;i++){
			cur = new HashMap<Integer,Integer>();
			for(int number = 1; number<=6; number++){
				for(int preNum : pre.keySet()){
					int curNum = number+preNum;
					if(cur.containsKey(curNum)){
						cur.put(curNum, cur.get(curNum)+pre.get(preNum));
					}else{
						cur.put(curNum, pre.get(preNum));
					}
				}
			}
			pre = cur;
			total*=6;
		}
		for(int num : pre.keySet()){
			System.out.printf("%3d: %5.2f%%\n",num,pre.get(num)*100f/total);
		}
	}

	public static void main(String[] args){
		printN(3);
	}

}
