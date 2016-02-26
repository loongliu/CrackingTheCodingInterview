package cracking._01_string;

public class _01_01_AllDifferent {

	public static void main(String[] args) {
		System.out.println(allDifferent("aabc"));
		System.out.println(allDifferent("adbc"));
	}
	
	private static boolean allDifferent(String input){
		boolean[] b = new boolean[Character.MAX_VALUE];
		for(char c : input.toCharArray()){
			if(b[c]==true){
				return false;
			}
			b[c] = true;
		}
		return true;
	}

}