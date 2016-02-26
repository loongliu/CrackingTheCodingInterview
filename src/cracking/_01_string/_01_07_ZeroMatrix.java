package cracking._01_string;

public class _01_07_ZeroMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1,2,3,4,5},
				{1,0,2,3,4},
				{1,1,1,0,4},
				{0,1,0,1,0}
		};
		print(matrix);
		zeroMatrix(matrix);
		System.out.println();
		print(matrix);
	}
	
	public static void zeroMatrix(int[][] matrix){
		int M = matrix.length;
		int N = matrix[0].length;
		boolean[] m = new boolean[M];
		boolean[] n = new boolean[N];
		for(int i = 0; i<M; i++){
			for(int j = 0; j<N; j++){
				if(matrix[i][j]==0){
					m[i] = true;
					n[j] = true;
				}
			}
		}
		for(int i = 0; i<M; i++){
			if(m[i]==true){
				for(int j = 0; j<N; j++){
					matrix[i][j] = 0;
				}
			}
		}
		for(int j = 0; j<N; j++){
			if(n[j]==true){
				for(int i = 0; i<M; i++){
					matrix[i][j] = 0;
				}
			}
		}
	}
	private static void print(int[][] input){
		int M = input.length;
		int N = input[0].length;
		for(int i = 0; i<M; i++){
			for(int j = 0; j<N; j++){
				System.out.printf("% 3d", input[i][j]);
			}
			System.out.println();
		}
	}

}
