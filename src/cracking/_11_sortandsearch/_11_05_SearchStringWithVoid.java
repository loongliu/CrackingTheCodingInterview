package cracking._11_sortandsearch;

public class _11_05_SearchStringWithVoid {
	
	public static int searchArrayWithVoid(String[] array, String key){
		if(key == null) return -1;
		int left = 0;
		int right = array.length;
		int mid;
		while(left<right){
			mid = (right-left)/2+left;
			int index = nearestString(array, mid, left, right);
			if(index == -1) return -1;
			if(key.compareTo(array[index])==0){
				return index;
			}else if(key.compareTo(array[index])<0){
				right = index -1;
			}else{
				left = index + 1;
			}
		}
		return -1;
	}
	
	private static int nearestString(String[] array, int index, int left, int right){
		for(int i = 0; index+i<=right || index-i>=left ;i++){
			int i1 = index -i;
			if(i1>=left && !"".equals(array[i1])){return i1;}
			int i2 = index + i;
			if(i2<=right && !"".equals(array[i2])) { return i2;}
		}
		return -1;
	}
	
	

	public static void main(String[] args) {
		String[] array = new String[]{
				"at","","","","ball","","","car","","","dad","",""
		};
		System.out.println(searchArrayWithVoid(array, "ball"));
	}

}
