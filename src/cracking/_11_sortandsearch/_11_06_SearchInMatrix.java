package cracking._11_sortandsearch;

public class _11_06_SearchInMatrix {
	
	public static boolean findElement(int[][] matrix, int elem){
		int row = 0;
		int col = matrix[0].length - 1;
		while(row<matrix.length && col >= 0){
			if( matrix[row][col] == elem){
				return true;
			}else if(matrix[row][col] > elem){
				col--;
			}else{
				row++;
			}
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
		System.out.println(findElement(matrix, 14));
		System.out.println(findElement(matrix, 10));
		System.out.println(findElement(matrix, 20));
	}

}
