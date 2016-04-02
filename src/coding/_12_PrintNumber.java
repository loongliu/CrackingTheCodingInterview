package coding;

import java.math.BigInteger;

public class _12_PrintNumber {
	
	public static void print(int n){
		char[] c = new char[n];
		for(int i = 0; i<n;i++)
			c[i] = '9';
		BigInteger max = new BigInteger(new String(c),10);
		//System.out.println(max);
		for(BigInteger b = BigInteger.ONE; b.compareTo(max)<=0;b = b.add(BigInteger.ONE)){
			System.out.println(b+" ");
		}
	}
	
	public static void print2(int n){
		if(n<= 0) return;
		char[] number = new char[n];
		printRecursively(number, 0);
	}
	private static void printRecursively(char[] number, int index){
		if(index == number.length){
			boolean found = false;
			for(char c:number){
				if(c!='0'||found) {System.out.print(c); found = true;}
			}
			System.out.println();
			return;
		}
		for(int i = 0; i<10;++i){
			number[index] = (char) (i+'0');
			printRecursively(number, index+1);
		}
	}

	public static void main(String[] args) {
		print2(4);
	}

}
