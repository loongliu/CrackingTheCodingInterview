package cracking._09_dp;

import java.util.ArrayList;
import java.util.HashMap;

class Box{
	int w;
	int h;
	int d;
	
	public Box(int ww, int hh, int dd){
		w = ww;
		h = hh;
		d = dd;
	}
	
	public boolean canBeAbove(Box bottom){
		return w<bottom.w && h<bottom.h && d<bottom.d;
	}
	
	public String toString(){
		return "\nw: " + w + " h: " + h + " d: "+ d ;
	}
}

public class _09_10_BoxStack {
	/**
	 * get the height stack of given boxes.
	 * @param boxes given boxes
	 * @return the box stack, bottom box is place at position 0.
	 */
	public static ArrayList<Box> heightStack(Box[] boxes){
		HashMap<Box, ArrayList<Box>> stackMap = new HashMap<>();
		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for(int i = 0;i<boxes.length; i++){
			ArrayList<Box> tmpStack = stackOfBox(boxes[i], boxes, stackMap);
			int h = heightOfStack(tmpStack);
			if(maxHeight < h){
				maxHeight = h;
				maxStack = tmpStack;
			}
		}
		return maxStack;
	}
	
	private static ArrayList<Box> stackOfBox(Box bottom, Box[] boxes, HashMap<Box, ArrayList<Box>> map){
		if(map.containsKey(bottom)){
			return map.get(bottom);
		}
		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for(int i = 0; i<boxes.length;i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> tmpStack = stackOfBox(boxes[i], boxes, map);
				int h = heightOfStack(tmpStack);
				if(maxHeight < h){
					maxHeight = h;
					maxStack = tmpStack;
				}
			}
		}
		ArrayList<Box> res = new ArrayList<>();
		res.add(bottom);
		if(maxStack!=null) res.addAll(maxStack);
		map.put(bottom, res);
		return res;
	}
	
	private static int heightOfStack(ArrayList<Box> stack){
		int height = 0;
		for(Box b : stack)
			height += b.h;
		return height;
	}
	

	public static void main(String[] args) {
		Box[] boxes = new Box[4];
		boxes[0] = new Box(1,2,3);
		boxes[1] = new Box(2,8,4);
		boxes[3] = new Box(4,5,6);
		boxes[2] = new Box(5,6,7);
		ArrayList<Box> res = heightStack(boxes);
		System.out.println(res);
	}

}
