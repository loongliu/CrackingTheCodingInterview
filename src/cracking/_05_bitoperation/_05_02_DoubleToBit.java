package cracking._05_bitoperation;

public class _05_02_DoubleToBit {
	public static String doubleToBit(double d){
		StringBuilder sb = new StringBuilder("0.");
		for(int count = 0; count<32; count++){
			int val = d*2>=1?1:0;
			sb.append(val);
			d = d*2-val;
			if(d == 0){
				return sb.toString();
			}
		}
		return "ERROR";
	}
	public static void main(String[] args){
		System.out.println(doubleToBit(0.5d));
		System.out.println(doubleToBit(0.25d));
		System.out.println(doubleToBit(0.375d));
		System.out.println(doubleToBit(0.2d));
	}
}
