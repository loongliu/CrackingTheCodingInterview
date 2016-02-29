package cracking._04_treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;

public class _04_02_ReachabilityGraph<T> {
	ArrayList<DirectedGraphNode<T>> nodes;
	ArrayList<Boolean> marked;
	ArrayList<DirectedGraphNode<T>> fromNode;
	
	public _04_02_ReachabilityGraph(){
		nodes = new ArrayList<>();
		marked = new ArrayList<>();
		fromNode = new ArrayList<>();
	}
	boolean reachable(DirectedGraphNode<T> src, DirectedGraphNode<T> dest){
		LinkedList<DirectedGraphNode<T>> list = new LinkedList<>();
		list.add(src);
		marked.set(nodes.indexOf(src),true);
		while(!list.isEmpty()){
			DirectedGraphNode<T> node = list.removeFirst();
			if(node == dest) return true;
			for(DirectedGraphNode<T> dNode : node.edges){
				int index = nodes.indexOf(dNode);
				if(!marked.get(index)){
					marked.set(index,true);
					fromNode.set(index, node);
					list.add(dNode);
				}
			}
		}
		return false;
	}
	 
	 public void addNode(DirectedGraphNode<T> node){
		 nodes.add(node);
		 marked.add(false);
		 fromNode.add(null);
	 }
	 public void addEdge(DirectedGraphNode<T> from,DirectedGraphNode<T> to){
		 from.edges.add(to);
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
		
		_04_02_ReachabilityGraph<Integer> graph = new _04_02_ReachabilityGraph<>();
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addNode(n6);
		graph.addNode(n7);
		graph.addNode(n8);
		graph.addNode(n9);
		graph.addNode(n10);
		graph.addNode(n11);
		graph.addNode(n12);
		graph.addNode(n13);
		
		
		graph.addEdge(n1,n2);
		graph.addEdge(n2,n3);
		graph.addEdge(n3,n4);
		graph.addEdge(n4,n5);
		graph.addEdge(n2,n3);
		graph.addEdge(n2,n5);
		graph.addEdge(n4,n6);
		graph.addEdge(n3,n7);
		graph.addEdge(n5,n11);
		graph.addEdge(n4,n9);
		graph.addEdge(n2,n8);
		graph.addEdge(n6,n13);
		graph.addEdge(n11,n12);
		
		boolean r = graph.reachable(n1, n12);
		System.out.println(r);
		StringBuilder path = new StringBuilder();
		if(r){
			DirectedGraphNode<Integer> n = n12;
			while(n != null){
				path.insert(0, n.val);
				path.insert(0,"->");
				n = graph.fromNode.get(graph.nodes.indexOf(n));
			}
			System.out.println(path);
		}
		
	}
}
