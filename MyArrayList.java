/*
 * COMP352 - Data Structures and Algorithms
 * Assignment 2
 * Written by: Andy Vu (27008481)
 * Due: Monday, October 22, 2018
 */

import java.util.Arrays;

public class MyArrayList <E> implements List <E> {
	
	private int size;
	private int cap;
	private static final int DEFAULT=10;
	private E [] arrayE;
	
	public MyArrayList() {
		size=0;
		cap=DEFAULT;
		arrayE=(E[]) new Object [cap];
	}
	
	public MyArrayList(int i) {
		size=0;
		cap=i;
		arrayE=(E[]) new Object [cap];
	}
	
	//Adjust capactiy of array based on current size
	public void adjustSize() {
		if (size==0) {
			cap=DEFAULT;
			arrayE=Arrays.copyOf(arrayE, cap);
		}
		else if ((double)size/(double)cap<0.25) {
			cap=cap/2;
			arrayE=Arrays.copyOf(arrayE, cap);
		}
		else if (size==cap) {
			cap=size*2;
			arrayE=Arrays.copyOf(arrayE, cap);
		}
	}
	
	//Adds an element to the end
	public boolean add (E e) {
		arrayE[size]=e;
		size++;
		adjustSize();
		return true;
	}
	
	//Adds an element at index
	public void add (int index, E e) {
		if (index>size) {
			System.out.println("MyArrayList: Error  adding, index out of bounds.");
			return;
		}
		for (int i=size-1; i>=index; i--) {
			arrayE[i+1]=arrayE[i];
		}
		arrayE[index]=e;
		size++;
		adjustSize();
	}
	
	//Empties array
	public void clear () {
		for (int i=0; i<size; i++) {
			arrayE[i]=null;
			size--;
		}
		adjustSize();
	}
	
	//Removes element at index
	public E remove (int index) {
		if (index>size) {
			System.out.println("MyArrayList: Error removing, index out of bounds.");
			return null;
		}
		E e=arrayE[index];
		for (int i=index; i<size; i++) {
			arrayE[i]=arrayE[i+1];
		}
		arrayE[size-1]=null;
		size--;
		adjustSize();
		return e;
	}
	
	//Removes first instance of object
	public boolean remove (Object o) {
		if (o==null || arrayE.getClass()!=o.getClass()) {
			return false;
		}
		E objE=(E)o;
		for (int i=0; i<size; i++) {
			if (arrayE[i]==objE) {
				
				for (int j=i; j<size; j++) {
					arrayE[j]=arrayE[j+1];
				}
				arrayE[size-1]=null;
				size--;
				adjustSize();
				return true;
			}
		}
		return false;
	}
	
	public String toString()	{
		if (size==0) {
			return "ArrayList is empty.";
		}
		String s="[";
		for (int i=0; i<size; i++) {
			s=s+arrayE[i]+", ";
		}
		s=s+"]";
		return s;
	}
	
	public int size () {
		return size;
	}
	
	public int getCap() {
		return cap;
	}
}
