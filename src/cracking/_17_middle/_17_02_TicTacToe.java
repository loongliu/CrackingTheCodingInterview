package cracking._17_middle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class _17_02_TicTacToe {
	
	ArrayList<Integer> map = new ArrayList<>();
	
	public _17_02_TicTacToe(){
		generateMap();
	}
	
	public int win(int[][] board){
		return map.get(getKey(board));
	}
	
	private void generateMap(){
		int[][] board = new int[3][3];
		for(int i = 0; i<3*3*3*3*3*3*3*3*3; i++){
			board = getBoard(i);
			map.add(i,isWon(board));
		}
	}
	
	/**
	 * is this board win?
	 * @param board
	 * @return 1 for red win, 2 for blue win, 0 for trie
	 */
	private int isWon(int[][] board){
		for(int i = 0; i<3; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				if(board[i][0] !=0) return board[i][0];
			}
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				if(board[0][i] != 0) return board[0][i];
			}
		}
		if(board[1][1] == board[2][2] && board[0][0] == board[1][1]){
			if(board[0][0] !=0) return board[0][0];
		}
		if(board[1][1] == board[2][0] && board[2][0] == board[0][2]){
			if(board[1][1] !=0) return board[0][0];
		}
		return 0;
	}
	
	/**
	 * generate a key for a specific board.
	 * @param board the board array, 1 for red, 2 for blue, 0 for void
	 * @return the specific key
	 */
	private int getKey(int[][]board){
		int count = 0;
		int index = 1;
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				count += board[i][j] * index;
				index *=3;
			}
		}
		return count;
	}
	
	private int[][] getBoard(int key){
		int[][] board = new int[3][3];
		for(int i = 0; i<=8&&key>0; i++){
			board[i/3][i%3] = key%3;
			key = key/3;
		}
		return board;
	}

	public static void main(String[] args) {
		_17_02_TicTacToe game = new _17_02_TicTacToe();
		int [][] board = new int[3][3];
		Scanner scanner = new Scanner(System.in);
		Random r = new Random(System.nanoTime());
		String input;
		try{
			while(true){
				input = scanner.nextLine();
				if("quit".equals(input)) return;
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						board[i][j] = r.nextInt(3);
						if(board[i][j]==1) System.out.print("1");
						else if(board[i][j] == 0) System.out.print("2");
						else System.out.print("0");
					}
					System.out.println();
				}
				System.out.println(game.win(board));
			}
		}finally{
			scanner.close();
		}
	}

}
