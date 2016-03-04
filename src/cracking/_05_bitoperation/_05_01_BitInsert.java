package cracking._05_bitoperation;

public class _05_01_BitInsert {
	static int bitInsert(int M, int N, int i, int j){
		System.out.println("M: " + Integer.toBinaryString(M));
		System.out.println("N: " + Integer.toBinaryString(N));
		int lM = 0;
		int xm = M;
		while(xm!=0){
			xm=xm>>1;
			lM++;
		}
		int bM = M << (j - lM+1);
		System.out.println("bM: " + Integer.toBinaryString(bM));
		int a = -1<<i;
		System.out.println("a: " + Integer.toBinaryString(a));
		int b = -1>>>(31-j);
		System.out.println("b: " + Integer.toBinaryString(b));
		int c = ~(a&b);
		System.out.println("c: " + Integer.toBinaryString(c));

		System.out.printf(Integer.toBinaryString(c&N)+"\n");
		return (c&N)|bM;
	}
	public static void main(String[] args){
		int k =bitInsert((1<<4)+3,1<<12,2,8);
		System.out.println(Integer.toBinaryString(k));
	}
}
