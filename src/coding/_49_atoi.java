package coding;

public class _49_atoi {
	public static int atoi(String str){
		str = str.trim();
		int len = str.length();
		if(len<1) return 0;
		int i = 0, num = 0, flag = 1;
		while(i<len){
			if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
				if(i > 8){
					long tem = num;
					tem = tem*10+str.charAt(i)-48;
					if(tem>2147483647 && flag>0) return Integer.MAX_VALUE;
					else if(tem > 2147483648L && flag<0) return Integer.MIN_VALUE;
				}
				num=num*10+str.charAt(i)-48;
				i++;
			}else if(str.charAt(i)=='-'&&i==0){
				flag = -1;
				i++;
				continue;
			}else if(str.charAt(i) == '+' && i ==0){
				i++;
				continue;
			}else i = len;
		}
		return num*flag; 
	}
	
	public static void main(String[] args){
		System.out.println(atoi("1234")-1);
		System.out.println(atoi("0")-1);
		System.out.println(atoi("-1")-1);
		System.out.println(atoi("-100")-1);
		System.out.println(atoi("10")-1);
	}
}
