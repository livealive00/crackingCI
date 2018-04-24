package com.psh.crackingCI.ch03;

import java.util.ArrayDeque;
import java.util.Queue;

import lombok.Data;

/**
 * Created by Naver on 2018. 4. 18..
 */
public class P6 {
	public static void main(String[] args) {

	}

}

class AnimalQueue {
	Queue<Animal> cats;
	Queue<Animal> dogs;
	int order = 0;

	public AnimalQueue() {
		this.cats = new ArrayDeque<>();
		this.dogs = new ArrayDeque<>();
	}

	public void enqueue(Animal a) {
		a.setOrder(this.order);
		order++;

		if (a instanceof Cat) {
			cats.add(a);
		} else if (a instanceof Dog) {
			dogs.add(a);
		}
	}

	public Animal dequeueCat() {
		return cats.poll();
	}

	public Animal dequeueDog() {
		return dogs.poll();
	}

	public Animal dequeueAny() {

		if (dogs.isEmpty()) {
			return dequeueCat();
		} else if (cats.isEmpty()) {
			return dequeueDog();
		}

		Animal dog = dogs.peek();
		Animal cat = cats.peek();

		if (dog.getOrder() < cat.getOrder()) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
}

@Data
class Animal {
	int order;
	String name;
	public Animal(String name) {
		this.name = name;
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}