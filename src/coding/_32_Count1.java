package coding;

public class _32_Count1 {
	public static int count1(int number){
		int count = 0;
		int len = String.valueOf(number).length();
		for(int digit = 0; digit<len; digit++){
			count+=count1AtDigit(number,digit);
		}
		return count;
	}
	
	private static int count1AtDigit(int number, int d){
		int powerOf10 = (int) Math.pow(10, d);
		int nextPower = powerOf10*10;
		int right = number % powerOf10;
		
		int down = number - number % nextPower;
		int up = down + nextPower;
		
		int digit = (number / powerOf10)%10;
		if(digit<1){
			return down/10;
		}else if(digit == 1){
			return down/10+right+1;
		}else{
			return up/10;
		}
	}
	public static void main(String[] args) {
		System.out.println(count1(3415));
	}

}
