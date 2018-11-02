/*
 * COMP352 - Data Structures and Algorithms
 * Assignment 2
 * Written by: Andy Vu (27008481)
 * Due: Monday, October 22, 2018
 */

public class MyLinkedList <E> implements List<E> {
	
	private class Node {
		private E e;
		private Node next;
		private Node prev;
		
		public Node () {
			e=null;
			next=null;
			prev=null;
		}
		
		public Node (E e, Node next, Node prev) {
			this.e=e;
			this.next=next;
			this.prev=prev;
		}
	}
	
	Node head;
	private int size;
	
	public MyLinkedList () {
		head=null;
		size=0;
	}
	
	//Method adds a new node to the end of the list
	public boolean add(E e) {	
		if (head==null) {
			head=new Node(e, null, null);
		}
		else {
			Node t=head;
			while (t.next!=null) {
				t=t.next;
			}
			t.next=new Node (e, null, t);
		}
		size++;
		return true;
	}
	
	//Method adds element at specified index
	public void add(int index, E e) {
		System.out.println("index:"+index);
		System.out.println("size: "+size);
		if (head==null) {
			head=new Node(e, null, null);
		}
		else if (index>=size) {
			System.out.println("> MyLinkedList: Error adding at index, index out of bound.");
			return;
		}
		else if (index==0) {
			head=new Node(e, head, null);                                                                                      
		}
		else if (index==1) {
			head.next=new Node(e, head.next, head);
			head.next.next.prev=head.next;
		}
		else {
			Node t=head;
			for (int i=0; i<index; i++) {
				t=t.next;
			}
			t.prev=new Node (e, t, t.prev);
			System.out.println(t.prev);
			t.prev.prev.next=t.prev;
		}
		size++;
	}
	
	//Removes all elements from list
	public void clear() {
		head=null;
		size=0;
	}
	
	//Removes element at index
	public E remove (int index) {
		if (head==null) {
			System.out.println("> List is empty.");
			return null;
		} 
		else if (index>=size) {
			System.out.println("> MyLinkedList: Error removing, index out of bound.");
			return null;
		} 
		else if (index==0) {
			E e=head.e;
			head=head.next;
			head.prev.next=null;
			head.prev=null;
			size--;
			return e;
		}
		else {
			Node t=head;
			
			for (int i=0; i<index; i++) {
				t=t.next;
			}
			E e=t.e;
			
			if (t.next==null) {
				t.prev.next=null;
				t.prev=null;
			}
			else {	
				t.prev.next=t.next;
				t.next.prev=t.prev;
				t.prev=null;
				t.next=null;	
			}
			size--;
			return e;
		}
	}
	
	//Removes first occurence of element
	public boolean remove (Object o) {	
		if (head==null) {
			return false;
		}
		else {
			if (o==null || head.e.getClass()!=o.getClass()) {
				return false;
			}
			else {
				E objE=(E)o;
				Node t=head;
				if (t.e==objE) {
					head.next.prev=null;
					head=head.next;
					size--;
					return true;
				}
				while (t.next!=null || t.e!=objE) {
					t=t.next;
				}
				if (t.e==objE) {
					if (t.next==null) {
						t.prev.next=null;
						t.prev=null;
					} 
					else {
						t.prev.next=t.next;
						t.next.prev=t.next.prev;
						t.prev=null;
						t.next=null;
					}
					size--;
					return true;
				}
				return false;
			}
		}
	}
	
	public String toString() {
		String s="";
		if (head==null) {
			return "List is empty.";
		}
		Node t=head;
		while (t.next!=null) {
			s=s+t.e+"-";
			t=t.next;
		}
		s=s+t.e+"-x";
		return s;
	}
	
	public int size() {
		return size; 
	}

	public boolean isEmpty() {
		if (size==0) {
			return true;
		}
		return false;
	}
}