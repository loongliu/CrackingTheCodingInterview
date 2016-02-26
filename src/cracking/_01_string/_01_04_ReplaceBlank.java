package cracking._01_string;

public class _01_04_ReplaceBlank {

	public static void main(String[] args){
		char[] input = new char[20];
		String s = "Mr John Smith";
		for(int i = 0; i<s.length(); i++){
			input[i] = s.charAt(i);
		}
		replaceBlank(input);
		System.out.println(input);
	}
	public static void replaceBlank(char[] input){
		int count = 0;
		for(char c : input){
			if (c==' '){
				count++;
			}
		}
		for(int i = input.length-1;count>0 && i>=0;i--){
			if(input[i]==(char)0){
				continue;
			}
			if(input[i]==' '){
				input[i+count*2] = '0';
				input[i+count*2-1] = '2';
				input[i+count*2-2] = '%';
				count--;
			}else{
				input[i+count*2] = input[i];
			}
		}
	}
}
