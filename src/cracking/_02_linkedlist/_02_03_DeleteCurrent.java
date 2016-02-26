package cracking._02_linkedlist;

public class _02_03_DeleteCurrent {

	public static boolean deleteCurrent(Node cur){
		if(cur==null || cur.next==null){
			return false;
		}
		cur.val = cur.next.val;
		cur.next = cur.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		Node n = Node.fromArray(new int[]{1,2,3});
		System.out.println(n);
		deleteCurrent(n.next.next);
		System.out.println(n);
	}

}
