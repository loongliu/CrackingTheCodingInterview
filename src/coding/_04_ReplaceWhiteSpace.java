package coding;

public class _04_ReplaceWhiteSpace {
	public static String replaceWhietSpace(String s){
		if(s == null) return null;
		char[] array = s.toCharArray();
		int count = 0;
		for(char c : array){
			if(c==' ') count++;
		}
		char[] newStr = new char[array.length+2*count];
		int index = newStr.length-1;
		for(int i = array.length-1; i>=0;i--){
			if(array[i]==' '){
				newStr[index--]='0';
				newStr[index--]='2';
				newStr[index--]='%';
			}else{
				newStr[index--]=array[i];
			}
		}
		return new String(newStr);
	}
	
	
	public static void main(String[] args){
		System.out.println(replaceWhietSpace("abcd abc gpe2 % 2"));
		System.out.println(replaceWhietSpace("    "));
	}
}
