package cracking._02_linkedlist;

public class _02_02_NthLastNode {
	
	public static Node nthLastNode(Node head, int n){
		Node fir = head, sec = head;
		for(int k = n; k>=0; k--){
			if(fir==null){
				return null;
			}
			fir = fir.next;
		}
		while(fir!=null){
			fir = fir.next;
			sec = sec.next;
		}
		return sec;
	}

	public static void main(String[] args) {
		Node head = Node.fromArray(new int[]{1,2,3,4,5});
		System.out.println(nthLastNode(head,1).val);
	}

}
