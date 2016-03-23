package cracking._09_dp;

import java.util.Arrays;
import java.util.LinkedList;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class _09_07_Paint {
	
	public static void fillColor(int[][] board, Point p, int toColor){
		int initColor = board[p.x][p.y];
		if(initColor == toColor){
			return;
		}
		int xMax = board.length;
		int yMax = board[0].length;
		LinkedList<Point> list = new LinkedList<>();
		list.add(p);
		while(list.size()!=0){
			Point first = list.removeFirst();
			board[first.x][first.y] = toColor;
			if(first.x-1>=0 && board[first.x-1][first.y] == initColor){
				list.add(new Point(first.x-1,first.y));
			}
			if(first.x+1<xMax && board[first.x+1][first.y] == initColor){
				list.add(new Point(first.x+1,first.y));
			}
			if(first.y-1>=0 && board[first.x][first.y-1] == initColor){
				list.add(new Point(first.x,first.y-1));
			}
			if(first.y+1<yMax && board[first.x][first.y+1] == initColor){
				list.add(new Point(first.x,first.y+1));
			}
		}
	}
	
	public static void main(String[] args){
		int[][] board = new int[5][5];
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				if(i+j>2&& i+j<7){
					board[i][j] = 10;
				}else{
					board[i][j] = 5;
				}
			}
		}
		for(int i = 0; i<board.length; i++){
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
		fillColor(board,new Point(0,0),13);

		for(int i = 0; i<board.length; i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
}
