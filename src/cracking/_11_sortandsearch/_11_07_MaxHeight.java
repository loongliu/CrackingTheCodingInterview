package cracking._11_sortandsearch;

import java.util.ArrayList;
import java.util.HashMap;

public class _11_07_MaxHeight {
	static class Person{
		int ht;
		int wt;
		Person(int h, int w){
			ht = h;
			wt = w;
		}
		
		public String toString(){
			return " ("+ht+","+wt+")";
		}
	}
	
	public static ArrayList<Person> maxHeight(ArrayList<Person> people){
		HashMap<Person, ArrayList<Person>> map = new HashMap<>();
		ArrayList<Person> heightStack = null;
		int height = -1;
		for(Person p : people){
			ArrayList<Person> tmp = getHeight(people, p, map);
			if(height<height(tmp)){
				height = height(tmp);
				heightStack = tmp;
			}
		}
		return heightStack;
	}
	
	private static ArrayList<Person> getHeight(ArrayList<Person> people, Person p, HashMap<Person, ArrayList<Person>> map){
		if(map.containsKey(p)) return map.get(p);
		ArrayList<Person> stack = null;
		int height = -1;
		for(Person pp : people){
			if(pp.wt<p.wt && pp.ht<p.ht){
				ArrayList<Person> tmp = getHeight(people, pp, map);
				if(height < height(tmp)){
					height = height(tmp);
					stack = tmp;
				}
			}
		}
		ArrayList<Person> sss = new ArrayList<>();
		if(stack != null ) sss.addAll(stack);
		sss.add(p);
		map.put(p, sss);
		return sss;
	}
	
	private static int height(ArrayList<Person> stack){
		int h = 0;
		for(Person p : stack){
			h+=p.ht;
		}
		return h;
	}
	

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person(65,100));
		list.add(new Person(70,150));
		list.add(new Person(56,90));
		list.add(new Person(75,190));
		list.add(new Person(60,95));
		list.add(new Person(68,110));
		System.out.println(maxHeight(list));
	}

}
