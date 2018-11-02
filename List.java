/*
 * COMP352 - Data Structures and Algorithms
 * Assignment 2
 * Written by: Andy Vu (27008481)
 * Due: Monday, October 22, 2018
 */

public interface List <E>{
	
	public boolean add(E e);
	
	public void add(int index, E element);
	
	public void clear();
	
	public E remove(int  index);
	
	public boolean remove (Object o);
	
	public String toString();
	
	public int size();
	
}
