package cracking._04_treeandgraph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode<T> {
	T val;
	boolean marked;
	List<DirectedGraphNode<T>> edges;
	DirectedGraphNode(T val){
		this.val = val;
		marked = false;
		edges = new ArrayList<>();
	}

	public static void main(String[] args) {
		
	}

}
