package cracking._07_math;

public class _07_04_Operator {

	public static int neg(int val){
		int de = val>0?-1:1;
		int res = 0;
		while(val!=0){
			val+=de;
			res+=de;
		}
		return res;
	}
	
	public static int minus(int v1, int v2){
		return v1+neg(v2);
	}
	
	public static int multi(int v1, int v2){
		int res = 0;
		v1 = v2>0?v1:neg(v1);
		v2 = v2>0?v2:neg(v2);
		while(v2!=0){
			res+=v1;
			v2--;
		}
		return res;
	} 
	
	public static int divide(int v1, int v2){
		int m1 = v1>0?1:-1;
		int m2 = v2>0?1:-1;
		v1 = v1*m1;
		v2 = v2*m2;
		boolean m = m1==m2;
		int res = 0;
		while(v1<=v2){
			v2-=v1;
			res++;
		}
		return m ? res : neg(res);
	}
	
	public static void main(String[] args) {
		System.out.println(neg(10));
		System.out.println(minus(10,-8));
		System.out.println(multi(-2,0));
		System.out.println(divide(9,-70));
	}

}
