package cracking._02_linkedlist;


public class _02_06_RingLinkList {
	
	static Node ringNode(Node head){
		Node fir = head;
		Node sec = head;
		while(fir!=null && fir.next!=null && sec!=null){
			fir = fir.next.next;
			sec = sec.next;
			if(fir == sec){
				Node h = head;
				while(h!=fir){
					h = h.next;
					fir = fir.next;
				}
				return h;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n3;
		Node ring = ringNode(n1);
		if(ring!=null){
			System.out.println(ring.val);
		}else{
			System.out.println("null");
		}
	}

}
