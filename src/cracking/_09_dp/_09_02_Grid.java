package cracking._09_dp;

import java.util.HashMap;
import java.util.List;

public class _09_02_Grid {
	
	static class Point{
		int x;
		int y;
		Point(int x, int y) { this.x = x; this.y = y; }
		Point() {this(0,0);}
		public boolean equals(Object o){
			if(!(o instanceof Point)) return false;
			Point p = (Point) o;
			if(x != p.x || y != p.y) return false;
			return true;
		}
		public int hashCode(){
			return x<<16+y;
		}
	}
	
	public static int grid(int x, int y){
		if(x<0 || y <0) return 0;
		int[][] grid = new int[x+1][y+1];
		grid[0][0] = 1;
		for(int i = 1; i<=x; i++){
			grid[i][0] = grid[i-1][0];
		}
		for(int j = 1; j<=y; j++){
			grid[0][j] = grid[0][j-1];
		}
		for(int i = 1; i<=x; i++){
			for(int j = 1; j<=y;j++){
				grid[i][j] = grid[i-1][j] + grid[i][j-1];
			}
		}
		return grid[x][y];
	}
	
	public static boolean canReach(Point p, List<Point> barriar){
		if(barriar == null) return true;
		HashMap<Point, Boolean> re = new HashMap<>();
		return canReach(p,barriar,re);
	}
	
	public static boolean canReach(Point p, List<Point> barriar, HashMap<Point, Boolean> re){
		if(re.containsKey(p)) return re.get(p);
		if(p.x==0 && p.y==0) return true;
		boolean success = false;
		if(p.x>=1 && !barriar.contains(new Point(p.x-1,p.y))){
			success = canReach(new Point(p.x-1,p.y),barriar,re);
		}
		if(!success && p.y>=1 && !barriar.contains(new Point(p.x, p.y-1))){
			success = canReach(new Point(p.x, p.y-1),barriar, re);
		}
		re.put(p,success);
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(grid(1,2));
	}

}
