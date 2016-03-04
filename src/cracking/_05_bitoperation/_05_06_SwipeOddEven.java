package cracking._05_bitoperation;

public class _05_06_SwipeOddEven {

	public static int swipeOddEven(int val){
		return ((val&0x55555555)<<1)|((val&0xaaaaaaaa)>>1);
	}
	
	public static void main(String[] args) {
		System.out.println(swipeOddEven(0xd));
	}

}
