package cracking._18_hard;

public class _18_05_ShortestDistance {
	
	public static int shortestDistance(String[] book, String key1, String key2){
		int last1 = -1;
		int last2 = -1;
		int distance = Integer.MAX_VALUE;
		for(int i = 0; i<book.length; i++){
			if(key1.equals(book[i])){
				last1 = i;
				if(last2 != -1 && distance>last1-last2){
					distance = last1-last2;
				}
			}else if(key2.equals(book[i])){
				last2 = i;
				if(last1 != -1 && distance > last2-last1){
					distance = last2-last1;
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		String[] book = new String[]{"a","b","c","d","e","c"};
		System.out.println(shortestDistance(book,"c","e"));
	}

}
