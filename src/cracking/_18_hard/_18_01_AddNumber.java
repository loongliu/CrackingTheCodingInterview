package cracking._18_hard;

public class _18_01_AddNumber {
	
	/*加法的实现：a^b表示的是二进制中没有进位的和，
	 * (a&b)表示的是进位的和，将这二者相加就得到原来的和、
	 * 减法的实现：将被减数相反数再加就可以。相反数：取反+1.
	*/
	public static int add(int a, int b){
		if(b == 0) return a;
		return add(a^b, (a&b)<<1);
	}

	public static void main(String[] args) {
		System.out.println(add(34,78));
	}

}
