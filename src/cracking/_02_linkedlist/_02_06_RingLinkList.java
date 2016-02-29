package cracking._02_linkedlist;


public class _02_06_RingLinkList {
	
	static <T> Node<T> ringNode(Node<T> head){
		Node<T> fir = head;
		Node<T> sec = head;
		while(fir!=null && fir.next!=null && sec!=null){
			fir = fir.next.next;
			sec = sec.next;
			if(fir == sec){
				Node<T> h = head;
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
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		Node<Integer> n5 = new Node<>(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n3;
		Node<Integer> ring = ringNode(n1);
		if(ring!=null){
			System.out.println(ring.val);
		}else{
			System.out.println("null");
		}
	}

}
