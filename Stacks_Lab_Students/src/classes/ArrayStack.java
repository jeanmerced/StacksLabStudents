package classes;

import interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {

	private static final int IC = 10; // initial capacity
	private static final int CC = 5; // capacity change
	private static final int MAXEMPTYPOS = 10; // maximum empty positions
	private E[] elements;
	private int size;
	
	public ArrayStack() {
		elements = (E[]) new Object[IC];
		size = 0;
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E top() {
		if(isEmpty())
			return null;
		return elements[size - 1];
	}

	public void push(E e) {
		if(size == elements.length)
			changeCapacity(CC);
		elements[size] = e;
		size++;
	}

	public E pop() {
		if(isEmpty())
			return null;
		E etr = elements[size - 1];
		elements[size - 1] = null;
		size--;
		if((elements.length - size) > MAXEMPTYPOS)
			changeCapacity(-CC);
		return etr;
	}
	
	private void changeCapacity(int change) { 
		int newCapacity = elements.length + change; 
		E[] newElements = (E[]) new Object[newCapacity]; 
		for (int i=0; i < size; i++) { 
			newElements[i] = elements[i]; 
			elements[i] = null; 
		} 
		elements = newElements; 
	}
}
