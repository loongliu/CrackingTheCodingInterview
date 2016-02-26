package cracking._02_linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _02_01_DelteDuplicate {
	
	public static Node deleteDuplicate(Node head){
		if(head==null) return head;
		Set<Integer> cache = new HashSet<>();
		cache.add(head.val);
		for(Node cur = head; cur.next!=null;){
			if(cache.contains(cur.next.val)){
				deleteNext(cur);
			}else{
				cache.add(cur.next.val); 
				cur = cur.next;
			}
		}
		return head;
	}
	
	public static Node deleteDuplicateNoCache(Node head){
		if(head==null) return head;
		for(Node cur = head; cur.next!=null;){
			boolean found = false;
			for(Node sub = head; sub!=cur.next; sub = sub.next){
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
	
	
	private static Node deleteNext(Node pre){
		if(pre.next != null){
			pre.next = pre.next.next;
		}
		return pre;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,1,3,4,2,4,5,12,2,345,2,3,7};
		Node ori = Node.fromArray(a);
		System.out.println(ori);
		System.out.println(deleteDuplicate(ori));
		System.out.println(deleteDuplicateNoCache(ori));

	}

}
