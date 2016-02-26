package cracking._02_linkedlist;

public class _02_04_Partition {
	
	public static Node partition(Node head, int value){
		if(head == null) return null;
		Node h1=null,e1 = null,h2 = null,e2=null;
		Node cur = head;
		while(cur!=null){
			Node inner = cur;
			cur = cur.next;
			if(inner.val <= value){
				if(h1==null){
					h1=e1=inner;
				}else{
					e1.next = inner;
					e1 = e1.next;
				}
			}else{
				if(h2==null){
					h2=e2=inner;
				}else{
					e2.next = inner;
					e2 = e2.next;
				}
			}
		}
		e2.next = null;
		if(h1==null){
			return h2;
		}else{
			e1.next = h2;
			return h1;
		}
	}

	public static void main(String[] args) {
		Node n = Node.fromArray(new int[]{5,4,2,16,12,5,23,2,243,11,2});
		System.out.println(partition(n,13));
	}

}
