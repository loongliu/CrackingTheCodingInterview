package coding;

class Node{
	int val;
	Node next;
	Node rand;
	public Node(int v){val = v;}
}

public class _26_CopyComplexListNode {
	
	public static Node copy(Node origin){
		Node cur = origin;
		while(cur!= null){
			Node cpy = new Node(cur.val);
			cpy.next = cur.next;
			cur.next = cpy;
			cur = cpy.next;
		}
		cur = origin;
		while(cur!= null){
			if(cur.rand!=null){
			cur.next.rand = cur.rand.next;
			}
		}
		cur = origin;
		Node cpyHead = null, cpyCur = null;
		if(cur != null){
			cpyHead = cur.next;
			cpyCur = cur.next;
			cur.next = cpyCur.next;
			cur = cur.next;
		}
		while(cur!= null){
			cpyCur.next = cur.next;
			cpyCur = cpyCur.next;
			cur.next = cpyCur.next;
			cur = cur.next;
		}
		return cpyHead;
	}

	public static void main(String[] args) {
		
	}

}
