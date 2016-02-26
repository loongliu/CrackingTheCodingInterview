package cracking._01_string;

/**
 * @time 2015.12.22
 * @author liujilong
 *
 */

public class _01_06_RotateMatrix {

	public static void main(String[] args) {
		int N = 11;
		int[][] matrix = new int[N][N];
		for(int i = 0; i< N; i++){
			for(int j = 0; j<N; j++){
				matrix[i][j] = i+2*j;
			}
		}
		print(matrix);
		rotateMatrix(matrix);
		System.out.println();
		print(matrix);
	}
	/**
	 * rotate input matrix with 90 degree
	 * @param input matrix with same width and height
	 */
	public static void rotateMatrix(int[][] input){
		if(input == null){
			throw new RuntimeException("input matrix is null");
		}
		if(input.length==0 || input[0].length==0){
			throw new RuntimeException("input matrix has zero length");
		}
		if(input.length != input[0].length){
			throw new RuntimeException("input matrix length not equal");
		}
		int N = input.length;
		for(int i = 0; i<(N+1)/2; i++){
			for(int j = 0; j < N/2; j++){
				rotate(input, i, j);
			}
		}
	}
	
	private static void rotate(int[][] input, int i, int j){
		int N = input.length;
		int tmp = input[i][j];
		input[i][j]=input[j][N-1-i];
		input[j][N-1-i] = input[N-1-i][N-1-j];
		input[N-1-i][N-1-j] = input[N-1-j][i];
		input[N-1-j][i] = tmp;
	}
	
	private static void print(int[][] input){
		int N = input.length;
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				System.out.printf("% 3d", input[i][j]);
			}
			System.out.println();
		}
	}

}
