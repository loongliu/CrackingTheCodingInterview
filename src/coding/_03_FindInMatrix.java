package coding;

public class _03_FindInMatrix {

	public static boolean found(int[][] array, int key){
		if(array == null) return false;
		int row = 0, colomn = array[0].length-1;
		while(row<array.length && colomn>=0){
			if(array[row][colomn] == key) return true;
			if(array[row][colomn]>key) colomn--;
			else row++;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,15,16,18},
			};
			System.out.println(found(matrix, 14));
			System.out.println(found(matrix, 10));
			System.out.println(found(matrix, 20));
	}

}
