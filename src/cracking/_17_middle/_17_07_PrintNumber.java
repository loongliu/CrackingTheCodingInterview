package cracking._17_middle;

import java.util.Random;

public class _17_07_PrintNumber {
	
	static String[] numbers = new String[] { "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",	
			"Eleven", "Twelve","Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "SevenTeen", "Eighteen", "NineTeen"};
	static String[] dozens = new String[] {"Twenty","Thirty", "Forty",
		"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	};
	
	
	public static String printNumber(int number){
		StringBuilder sb = new StringBuilder();
		sb.append(numberOfThousand(number%1000));
		number = number/1000;
		if(number!=0){
			sb.insert(0, " Thousand, ").insert(0,numberOfThousand(number%1000));
		}
		number = number/1000;
		if(number!=0){
			sb.insert(0, " Million, ").insert(0,numberOfThousand(number%1000));
		}
		number = number/1000;
		if(number!=0){
			sb.insert(0, " Billion, ").insert(0,numberOfThousand(number%1000));
		}
		return sb.toString();
	}
	
	private static String numberOfThousand(int number){
		if(number>999) return "";
		StringBuilder sb = new StringBuilder();
		int g = number%100;
		if(g == 0) ;
		else if(g<20){sb.append(numbers[g-1]);}
		else{
			sb.append(dozens[g/10-2]);
			if(g%10 != 0){
				sb.append(" ").append(numbers[g%10-1]);
			}
		}
		if(number/100>0){
			sb.insert(0," Hundred ").insert(0,numbers[number/100-1]);
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		Random r = new Random(System.nanoTime());
		for(int i = 1; i<100; i++){
			int num = r.nextInt(Integer.MAX_VALUE);
			System.out.printf("%,d",num);
			System.out.println(": " + printNumber(num));
		}
	}

}
