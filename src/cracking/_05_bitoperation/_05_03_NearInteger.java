package cracking._05_bitoperation;

public class _05_03_NearInteger {
	private static boolean isOne(int val, int pos){
		int i = 1<<pos;
		return (val & i) != 0;
	}

	public static void nearInteger(int val){
		int fir0=-1,fir1=-1;
		int pre = -1,next=-1;
		boolean found0 = false, found1 = false;
		for(int i = 0;i<32&&(!found0 || !found1);i++){
			if(isOne(val, i) && !found1){
				found1 = true;
				fir1 = i;
			}
			if(!isOne(val,i) && !found0){
				found0 = true;
				fir0 = i;
			}
		}
		System.out.println(fir0+" " + fir1);
		if(fir0>fir1){
			next = val + (1<<fir1);
			int sec1 = -1;
			for(int i = fir0+1; i<32; i++){
				if(isOne(val,i)){
					sec1 = i;
					break;
				}
			}
			if(sec1 !=-1){
				pre = val - (1<<(sec1-1));
			}
		}else{
			pre = val - (1<<(fir1-1));
			int sec0 = -1;
			for(int i = fir0+1;i<32; i++){
				if(!isOne(val,i)){
					sec0 = i;
					break;
				}
			}
			if(sec0 != -1){
				next = val + (1<<(sec0-1));
			}
		}
		System.out.println("next: " + ((next==-1)?"no next":next));
		System.out.println("pre " + ((pre == -1)?"no pre": pre));
	}
	
	public static void main(String[] args){
		nearInteger(Integer.MAX_VALUE);
		nearInteger(3);
		nearInteger(6);
		nearInteger(8);
	}
}
