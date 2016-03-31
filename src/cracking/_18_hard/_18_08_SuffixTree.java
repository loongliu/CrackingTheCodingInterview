package cracking._18_hard;

/*
 * 对字符串进行多次搜索时，先将字符串建立一个后缀子树。 
 **/

class Node{
	Node[] nodes = new Node[26]; 
	char c;
	public Node(char c){
		this.c = c;
	}
}


public class _18_08_SuffixTree {
	public static Node generateTree(String str){
		return generateTree(str.toCharArray(),0,(char)0);
	}
	
	private static Node generateTree(char[] array, int start, char cc){
		if(start == array.length) return null;
		Node root = new Node(cc);
		for(int i = start; i<array.length;i++){
			char c;
			Node cur = root;
			for(int j = i;j<array.length;j++){
				c = array[j];
				if(cur.nodes[c-'a']!=null){
					cur = cur.nodes[c-'a'];
				}else{
					cur.nodes[c-'a'] = new Node(c);
					cur = cur.nodes[c-'a'];
				}
			}
		}
		return root;
	}
	
	public static boolean search(Node tree, String str){
		for(char c : str.toCharArray()){
			if(tree.nodes[c-'a']!=null){
				tree = tree.nodes[c-'a'];
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "abdkejaikjeiafjiewjfiawjierfj";
		Node n = generateTree(s);
		for(int i = 0;i<s.length();i++){
			for(int j = i+1; j<s.length();j++){
				System.out.println(search(n,s.substring(i, j)));
				System.out.println(search(n,s.substring(i, j)+'q'));
			}
		}
	}
}
