package cracking._02_linkedlist;

public class _02_05_LinkedAdd {
	
	
	public static Node add(Node n1, Node n2){
		if(n1 == null) return n2;
		if(n2 == null) return n1;
		int s = (n1.val+n2.val)%10;
		int p = (n1.val+n2.val)/10;
		Node head = new Node(s);
		Node cur = head;
		for(Node c1 = n1.next, c2 = n2.next; c1!=null || c2!=null;){
			int add = p+(c1!=null?c1.val:0)+(c2!=null?c2.val:0);
			p = add/10;
			cur.next = new Node(add%10);
			cur = cur.next;
			if(c1!=null) c1=c1.next;
			if(c2!=null) c2=c2.next;
		}
		if(p!=0){
			cur.next = new Node(p);
		}
		return head;
	}
	
	public static void main(String[] args){
		Node n1 = Node.fromArray(new int[]{6,1,7,8});
		Node n2 = Node.fromArray(new int[]{2,9,5});
		System.out.println(add(n1,n2));
	}

}
