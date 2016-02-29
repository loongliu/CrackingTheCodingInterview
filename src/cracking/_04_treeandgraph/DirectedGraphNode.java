package cracking._04_treeandgraph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode<T> {
	T val;
	List<DirectedGraphNode<T>> edges;
	DirectedGraphNode(T val){
		this.val = val;
		edges = new ArrayList<>();
	}

	public static void main(String[] args) {
		
	}

}
