package cracking._09_dp;

import java.util.HashSet;
import java.util.Set;

class Bucket{
	int n;
	int size;
	char[] arrange;
	int tNum;
	int fNum;
	Bucket(int n){
		this.n = n;
		size = 0;
		arrange = new char[2*n];
		tNum = 0;
		fNum = 0;
	}
	Bucket(Bucket clone){
		n = clone.n;
		size = clone.size;
		arrange = new char[2*n];
		System.arraycopy(clone.arrange, 0, arrange, 0, clone.tNum+clone.fNum);
		tNum = clone.tNum;
		fNum = clone.fNum;
	}
	boolean trueAcceptable(){
		return tNum<n;
	}
	boolean falseAcceptable(){
		return tNum>fNum;
	}
	Bucket addTrue(){
		if(!trueAcceptable()){
			throw new RuntimeException();
		}
		Bucket b = new Bucket(this);
		b.arrange[size] = '(';
		b.size++;
		b.tNum++;
		return b;
	}
	
	Bucket addFalse(){
		if(!falseAcceptable()){
			throw new RuntimeException();
		}
		Bucket b = new Bucket(this);
		b.arrange[size] = ')';
		b.size++;
		b.fNum++;
		return b;
	}
	public String toString(){
		return new String(arrange);
	}
}

public class _09_06_N_Brackets {
	
	public static Set<String> nBrackets(int n){
		Set<Bucket> res = new HashSet<Bucket>();
		res.add(new Bucket(n));
		for(int i = 0; i<2*n; i++){
			Set<Bucket> tmp = res;
			res = new HashSet<Bucket>();
			for(Bucket b : tmp){
				if(b.trueAcceptable()){
					res.add(b.addTrue());
				}
				if(b.falseAcceptable()){
					res.add(b.addFalse());
				}
			}
		}
		Set<String> s = new HashSet<String>();
		for(Bucket b : res){
			s.add(b.toString());
		}
		return s;
	}

	public static void main(String[] args) {
		for(int i = 0; i<5; i++)
		System.out.println(nBrackets(i));
	}

}
