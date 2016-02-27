package cracking._02_linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _02_01_DelteDuplicate {
	
	public static <T>  Node<T> deleteDuplicate(Node<T> head){
		if(head==null) return head;
		Set<T> cache = new HashSet<>();
		cache.add(head.val);
		for(Node<T> cur = head; cur.next!=null;){
			if(cache.contains(cur.next.val)){
				deleteNext(cur);
			}else{
				cache.add(cur.next.val); 
				cur = cur.next;
			}
		}
		return head;
	}
	
	public static <T> Node<T> deleteDuplicateNoCache(Node<T> head){
		if(head==null) return head;
		for(Node<T> cur = head; cur.next!=null;){
			boolean found = false;
			for(Node<T> sub = head; sub!=cur.next; sub = sub.next){
				if(sub.val == cur.next.val){
					found = true;
					break;
				}
			}
			if(found){
				deleteNext(cur);
			}else{
				cur = cur.next;
			}
		}
		return head;
	}
	
	
	private static <T> Node<T> deleteNext(Node<T> pre){
		if(pre.next != null){
			pre.next = pre.next.next;
		}
		return pre;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{1,2,1,3,4,2,4,5,12,2,345,2,3,7};
		Node<Integer> ori = Node.fromArray(a);
		System.out.println(ori);
		System.out.println(deleteDuplicate(ori));
		System.out.println(deleteDuplicateNoCache(ori));

	}

}
