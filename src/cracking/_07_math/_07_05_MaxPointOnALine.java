package cracking._07_math;


import java.util.HashMap;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}



public class _07_05_MaxPointOnALine {
	static class Line{
    	final double MIN = 0.000001;
    	boolean isX = false;
    	double k;
    	double d;
    	int x;
    	Line(int x){
    		isX = true;
    		this.x = x;
    	}
    	Line(Point a, Point b){
    		if(a.x == b.x){
    			isX = true;
    			x = a.x;
    		}else{
    			k = (b.y-a.y)*1.0d/(b.x-a.x);
    			d = b.y-k*b.x;
    		}
    	}
    	Line(Point a, double k){
    		this.k = k;
    		this.d = a.y-k*a.x;
    	}
    	@Override
    	public String toString(){
    		StringBuilder sb = new StringBuilder();
    		if(isX){
    			sb.append("x=").append(x);
    		}else{
    			sb.append("y=").append(k).append("x+").append(d);
    		}
    		return sb.toString();
    	}
    }
    public static Line maxPointsLine(Point[] points) {
    	Line line = null;
    	if(points == null || points.length<2) return line;
    	int max= 0;
    	for(int i = 0; i<points.length; i++){
    		HashMap<Double,Integer> map = new HashMap<>();
    		int sameX = 0, samePoint = 0;
    		for(int j = 0; j<points.length;j++){
    			if(i == j) continue;
    			if(points[i].x == points[j].x && points[i].y == points[j].y){
    				samePoint ++;
    				sameX++;
    				continue;
    			}
    			if(points[i].x == points[j].x){
    				sameX++;
    				continue;
    			}
    			double d = (double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
    			if(map.containsKey(d)){
    				map.put(d, map.get(d)+1);
    			}else{
    				map.put(d, 2);
    			}
    		}
    		for(double d : map.keySet()){
    			if(max < map.get(d)+samePoint){
    				max = map.get(d)+samePoint;
    				line = new Line(points[i],d);
    			}
    		}
    		if(max<sameX+1){
    			max = sameX+1;
    			line = new Line(points[i].x);
    		}
    	}
    	return line;
    }
    
    public static void main(String[] args){
    	Point[] points = new Point[]{new Point(1,1),new Point(0,0),new Point(-2,1),new Point(-2,2),new Point(-2,4),new Point(-2,-2)};
    	System.out.print(maxPointsLine(points));
    }
}
