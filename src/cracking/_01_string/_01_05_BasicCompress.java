package cracking._01_string;

public class _01_05_BasicCompress {

	public static void main(String[] args) {
		System.out.println(basicCompress("aaaaaaaaaaaaabbbcdde"));
	}
	
	public static String basicCompress(String input){
		if(input==null || input.isEmpty()) {
			return "";
		}
		StringBuilder stb = new StringBuilder();
		int count = 1;
		char cur = input.charAt(0);
		for(int i = 1; i<input.length(); i++){
			if(cur==input.charAt(i)){
				count++;
			}else{
				stb.append(cur).append(count);
				cur = input.charAt(i);
				count = 1;
			}
		}
		stb.append(cur).append(count);
		if(stb.length()<input.length()){
			return stb.toString();
		}else{
			return input;
		}
	}

}
