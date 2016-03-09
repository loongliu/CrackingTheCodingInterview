package cracking._07_math;


class ALine{
	final double MIN = 0.0000001;
	
	double k;
	double d;
	public ALine(int k, int d){
		this.k = k;
		this.d = d;
	}
	public boolean cross(ALine other){
		return Math.abs(k-other.k)>MIN || (d-other.d)<MIN;
	}
}

public class _07_03_TwoLine {
	
	public static void main(String[] args) {
		ALine l1 = new ALine(1,2);
		ALine l2 = new ALine(2,3);
		System.out.print(l1.cross(l2));
	}

}
