package coding;

public class _20_PrintMatrix {
	
	public static void printMatrix(int[][] matrix){
		int top = 0;
		int bottom = matrix.length-1;
		int left = 0;
		int right = matrix[0].length-1;
		while(top<=bottom && left<=right){
			for(int i = left; i<=right; i++){
				System.out.print(matrix[top][i]+" ");
			}
			top++;
			for(int i = top;i<=bottom; i++){
				System.out.print(matrix[i][right]+" ");
			}
			right--;
			for(int i = right;top<=bottom&& i>=left; i--){
				System.out.print(matrix[bottom][i]+" ");
			}
			bottom--;
			for(int i = bottom;left<=right && i>=top;i--){
				System.out.print(matrix[i][left]+" ");
			}
			left++;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
//				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		printMatrix(matrix);
	}

}
