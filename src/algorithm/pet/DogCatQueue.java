package algorithm.pet;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月23日   下午11:19:22
 * @version 1.0
 **/
public class DogCatQueue {
	
	private Queue<PetEnterQueue> dogQueue = new LinkedList<>();
	private Queue<PetEnterQueue> catQueue = new LinkedList<>();
	
	public void add(Pet pet){
		PetEnterQueue ele = new PetEnterQueue(pet, System.nanoTime());
		if(pet.getType().equals("cat")){
			catQueue.offer(ele);
		}else{
			dogQueue.offer(ele);
		}
	}
	
	public void popAll(){
		int num = dogQueue.size()+catQueue.size();
		if(num == 0){
			System.out.println("empty queue");
		}
		for(int i=0;i<num;i++){
			PetEnterQueue catele = catQueue.peek();
			PetEnterQueue dogele = dogQueue.peek();
			if(catele == null){
				dogQueue.poll();
				System.out.println(dogele.getPet().getType()+"-"+dogele.getPet().getName());
			}else if(dogele == null){
				catQueue.poll();
				System.out.println(catele.getPet().getType()+"-"+catele.getPet().getName());
			}else{
				if(catele.getTime() > dogele.getTime()){
					dogQueue.poll();
					System.out.println(dogele.getPet().getType()+"-"+dogele.getPet().getName());
				}else{
					catQueue.poll();
					System.out.println(catele.getPet().getType()+"-"+catele.getPet().getName());
				}
			}
		}
	}
	
	public void popDog(){
		PetEnterQueue dogele = dogQueue.poll();
		if(dogele == null){
			System.out.println("dog queue is empty");
		}
		System.out.println(dogele.getPet().getType()+"-"+dogele.getPet().getName());
	}
	
	public void popCat(){
		PetEnterQueue catele = catQueue.poll();
		if(catele == null){
			System.out.println("cat queue is empty");
			return;
		}
		System.out.println(catele.getPet().getType()+"-"+catele.getPet().getName());
	}
	
	public boolean isDogEmpty(){
		return dogQueue.isEmpty();
	}
	
	public boolean isCatEmpty(){
		return catQueue.isEmpty();
	}
	
	public boolean isEmpty(){
		return catQueue.isEmpty() && dogQueue.isEmpty();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Dog dg1 = new Dog("a1");
		Dog dg2 = new Dog("a2");
		Dog dg3 = new Dog("a3");
		Dog dg4 = new Dog("a4");
		Dog dg5 = new Dog("a5");
		Dog dg6 = new Dog("a6");
		
		Cat c1 = new Cat("c1");
		Cat c2 = new Cat("c2");
		Cat c3 = new Cat("c3");
		
		DogCatQueue queue = new DogCatQueue();
		queue.add(c2);
		Thread.currentThread().sleep(10);
		queue.add(dg1);
		Thread.currentThread().sleep(10);
		queue.add(dg2);
		Thread.currentThread().sleep(10);
		queue.add(dg3);
		Thread.currentThread().sleep(10);
		queue.add(c1);
		Thread.currentThread().sleep(10);
		queue.add(dg4);
		Thread.currentThread().sleep(10);
		queue.add(dg5);
		Thread.currentThread().sleep(10);
		queue.add(dg6);
		Thread.currentThread().sleep(10);
		queue.add(c3);
//		while(!queue.isCatEmpty()){
//			queue.popCat();
//		}
		queue.popCat();
		queue.popAll();
	}
}
