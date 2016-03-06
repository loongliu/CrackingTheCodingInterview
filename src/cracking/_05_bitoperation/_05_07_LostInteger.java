package cracking._05_bitoperation;

import java.util.ArrayList;

class BitInteger{
	public static final int INTEGER_SIZE = 32;
	int[] array = new int[INTEGER_SIZE];
	public BitInteger(int n){
		for(int i = 0; i<INTEGER_SIZE; i++,n/=2){
			array[i] = n %2;
		}
	}
	public int fetch(int column){
		return array[column];
	}
}


public class _05_07_LostInteger {
	public static void main(String[] args) {
		ArrayList<BitInteger> array = new ArrayList<>();
		array.add(new BitInteger(0));
		array.add(new BitInteger(1));
		array.add(new BitInteger(2));
		array.add(new BitInteger(3));
		array.add(new BitInteger(4));
		array.add(new BitInteger(5));
		array.add(new BitInteger(6));
		array.add(new BitInteger(7));
		array.add(new BitInteger(8));
		array.add(new BitInteger(9));
		array.add(new BitInteger(10));
		array.add(new BitInteger(12));
		array.add(new BitInteger(13));
		array.add(new BitInteger(14));
		array.add(new BitInteger(15));
		array.add(new BitInteger(16));
		System.out.println(findMissing(array));
	}
	public static int findMissing(ArrayList<BitInteger> input){
		return findMissing(input,0);	
	}
	
	public static int findMissing(ArrayList<BitInteger> input, int column){
		if(column >= BitInteger.INTEGER_SIZE){
			return 0;
		}
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size()/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size()/2);
		for (BitInteger t : input){
			if(t.fetch(column) == 0){
				zeroBits.add(t);
			}else{
				oneBits.add(t);
			}
		}
		if (zeroBits.size() <= oneBits.size()){
			int v = findMissing(zeroBits, column + 1);
			return (v<<1) | 0;
		} else {
			int v = findMissing(oneBits, column + 1);
			return (v<<1) | 1;
		}
	}

}
