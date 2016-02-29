package cracking._04_treeandgraph;

import java.util.LinkedList;

public class _04_02_Reachability {
	static <T> boolean reachable(DirectedGraphNode<T> src, DirectedGraphNode<T> dest){
		LinkedList<DirectedGraphNode<T>> list = new LinkedList<>();
		list.add(src);
		src.marked = true;
		while(!list.isEmpty()){
			DirectedGraphNode<T> node = list.removeFirst();
			if(node == dest) return true;
			for(DirectedGraphNode<T> dNode : node.edges){
				if(!dNode.marked){
					dNode.marked = true;
					list.add(dNode);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		DirectedGraphNode<Integer> n1 = new DirectedGraphNode<>(1);
		DirectedGraphNode<Integer> n2 = new DirectedGraphNode<>(2);
		DirectedGraphNode<Integer> n3 = new DirectedGraphNode<>(3);
		DirectedGraphNode<Integer> n4 = new DirectedGraphNode<>(4);
		DirectedGraphNode<Integer> n5 = new DirectedGraphNode<>(5);
		DirectedGraphNode<Integer> n6 = new DirectedGraphNode<>(6);
		DirectedGraphNode<Integer> n7 = new DirectedGraphNode<>(7);
		DirectedGraphNode<Integer> n8 = new DirectedGraphNode<>(8);
		DirectedGraphNode<Integer> n9 = new DirectedGraphNode<>(9);
		DirectedGraphNode<Integer> n10 = new DirectedGraphNode<>(10);
		DirectedGraphNode<Integer> n11 = new DirectedGraphNode<>(11);
		DirectedGraphNode<Integer> n12 = new DirectedGraphNode<>(12);
		DirectedGraphNode<Integer> n13 = new DirectedGraphNode<>(13);
		
		n1.edges.add(n2);
		n2.edges.add(n3);
		n3.edges.add(n4);
		n4.edges.add(n5);
		n2.edges.add(n3);n2.edges.add(n5);n4.edges.add(n6);n3.edges.add(n7);
		n5.edges.add(n10);n4.edges.add(n9);n2.edges.add(n8);n6.edges.add(n13);
		n11.edges.add(n12);
		
		System.out.println(reachable(n1,n12));
	}
}
