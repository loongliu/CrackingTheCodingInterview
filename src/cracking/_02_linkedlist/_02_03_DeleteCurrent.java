package cracking._02_linkedlist;

public class _02_03_DeleteCurrent {

	/**
	 * delete the current node in a linked list.
	 * assume you can only visit this node
	 * this can not delete the last node
	 * @param cur the current node
	 * @return
	 */
	public static <T> boolean deleteCurrent(Node<T> cur){
		if(cur==null || cur.next==null){
			return false;
		}
		cur.val = cur.next.val;
		cur.next = cur.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		Node<Integer> n = Node.fromArray(new Integer[]{1,2,3});
		System.out.println(n);
		deleteCurrent(n.next);
		System.out.println(n);
	}
}
