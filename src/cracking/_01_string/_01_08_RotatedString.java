package cracking._01_string;

public class _01_08_RotatedString {

	public static void main(String[] args) {
		String s1 = "adbc";
		String s2 = "bcad";
		System.out.println(isRotatedString(s1,s2));
	}
	
	public static boolean isRotatedString(String s1, String s2){
		return (s1+s1).contains(s2)&&s1.length()==s2.length();
	}

}
