package cracking._18_hard;

public class _18_01_AddNumber {
	
	/*�ӷ���ʵ�֣�a^b��ʾ���Ƕ�������û�н�λ�ĺͣ�
	 * (a&b)��ʾ���ǽ�λ�ĺͣ����������Ӿ͵õ�ԭ���ĺ͡�
	 * ������ʵ�֣����������෴���ټӾͿ��ԡ��෴����ȡ��+1.
	*/
	public static int add(int a, int b){
		if(b == 0) return a;
		return add(a^b, (a&b)<<1);
	}

	public static void main(String[] args) {
		System.out.println(add(34,78));
	}

}
