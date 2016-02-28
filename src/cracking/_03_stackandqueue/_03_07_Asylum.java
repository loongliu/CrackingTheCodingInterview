package cracking._03_stackandqueue;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Pet{	}

class Cat extends Pet{
	public int id;
	public String name;
	
	private static AtomicInteger idGenerator = new AtomicInteger(0);
	public Cat(String name){
		id = idGenerator.incrementAndGet();
		this.name = name;
	}
}

class Dog extends Pet{
	public int id;
	public String name;
	private static AtomicInteger idGenerator = new AtomicInteger(0);
	public Dog(String name){
		id = idGenerator.incrementAndGet();
		this.name = name;
	}
}


public class _03_07_Asylum {
	private static AtomicInteger adoptNum = new AtomicInteger(0);
	class CatWithNo{
		int adoptNum;
		Cat cat;
		public CatWithNo(String name) {
			cat = new Cat(name);
		}
		public CatWithNo(Cat cat){
			this.cat = cat;
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(adoptNum);
			return sb.toString();
		}
	}
	class DogWithNo{
		int adoptNum;
		Dog dog;
		public DogWithNo(String name) {
			dog = new Dog(name);
		}
		public DogWithNo(Dog dog){
			this.dog = dog;
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(adoptNum);
			return sb.toString();
		}
	}
	Queue<CatWithNo> catQueue;
	Queue<DogWithNo> dogQueue;
	
	public _03_07_Asylum(){
		catQueue = new Queue<>();
		dogQueue = new Queue<>();
	}
	
	public void enqueueDog(String name){
		enqueueDog(new Dog(name));
	}
	
	public void enqueueDog(Dog dog){
		DogWithNo dogWithTime = new DogWithNo(dog);
		dogWithTime.adoptNum = adoptNum.incrementAndGet();
		dogQueue.enqueue(dogWithTime);
	}
	
	public void enqueueCat(Cat cat){
		CatWithNo catWithTime = new CatWithNo(cat);
		catWithTime.adoptNum = adoptNum.incrementAndGet();
		catQueue.enqueue(catWithTime);
	}
	public void enqueueCat(String name){
		enqueueCat(new Cat(name));
	}
	
	public Cat dequeueCat(){
		CatWithNo catWithNo = catQueue.dequeue();
		return catWithNo == null ? null : catWithNo.cat;
	}
	
	public Dog dequeueDog(){
		DogWithNo dogWithNo = dogQueue.dequeue();
		return dogWithNo == null ? null : dogWithNo.dog;
	}
	
	public Pet dequeue(){
		CatWithNo catWithNo = catQueue.check();
		DogWithNo dogWithNo = dogQueue.check();
		if(catWithNo == null) {
			return dogWithNo == null ? null : dogQueue.dequeue().dog;
		}
		if(dogWithNo == null){
			return catWithNo == null ? null : catQueue.dequeue().cat;
		}
		if(catWithNo.adoptNum>dogWithNo.adoptNum){
			return dogQueue.dequeue().dog;
		}else{
			return catQueue.dequeue().cat;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Cat Queue: \t").append(catQueue).append("\n");
		sb.append("Dog Queue: \t").append(dogQueue).append("\n");
		return sb.toString();
	}

	
	public static void main(String[] args) {
		_03_07_Asylum asylum = new _03_07_Asylum();
		System.out.println(asylum);
		Random ran = new Random(System.currentTimeMillis());
		for(int i = 0; i<40;i++){
			int r = ran.nextInt(2);
			String name = "name: " + i;
			if(r == 0){
				asylum.enqueueCat(name);
			}else{
				asylum.enqueueDog(name);
			}
		}
		System.out.println(asylum);
		for(int i = 0; i<20; i++){
			int r = ran.nextInt(5);
			String name = "name2: " + i;
			if(r == 0){
				asylum.enqueueCat(name);
			}else if(r == 1){
				asylum.enqueueDog(name);
			}else if(r == 2){
				asylum.dequeueCat();
			}else if(r == 3){
				asylum.dequeueDog();
			}else if(r == 4){
				asylum.dequeue();
			}
			System.out.println(asylum);
		}
	}

}


