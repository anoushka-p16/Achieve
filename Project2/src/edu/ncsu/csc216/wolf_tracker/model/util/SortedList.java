package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * The SortedList class implements the ISortedList interface. Handles
 * functionality for a linked list.
 * 
 * @param <E> the list of elements.
 * @author Anoushka Piduru
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** The size of the linked list. */
	private int size;
	/** The first node of the linked list. */
	private ListNode head;

	/**
	 * Constructor for SortedList.
	 */
	public SortedList() {
		head = null;
		size = 0;
	}

	/**
	 * Adds an element to the list in sorted order.
	 * 
	 * @param element the element to be added.
	 * @throws IllegalArgumentException if element is null, or
	 *                                  IllegalArgumentException if element is
	 *                                  duplicate of another.
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		ListNode newNode = new ListNode(element, null);

		if (head == null) {
			head = newNode;
		} else {
			ListNode current = head;
			ListNode previous = null;

			while (current != null && current.data.compareTo(element) < 0) {
				previous = current;
				current = current.next;
			}

			if (current != null && current.data.compareTo(element) == 0) {
				throw new IllegalArgumentException("Cannot add duplicate element.");
			}
			if (previous == null) {
				newNode.next = head;
				head = newNode;
			} else {
				previous.next = newNode;
				newNode.next = current;
			}
		}
		size++;
	}

	/**
	 * Removes the element at a given index.
	 * 
	 * @param idx the index to be removed.
	 * @return the element at the given index.
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	public E remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		ListNode current = head;
		ListNode remove;

		if (idx == 0) {
			remove = head;
			head = head.next;
		} else {
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			remove = current.next;
			current.next = current.next.next;
		}
		size--;
		return remove.data;
	}

	/**
	 * Determines if the list contains a given element.
	 * 
	 * @param element the element being checked for.
	 * @return true if the list contains the element, false if not.
	 */
	public boolean contains(E element) {
		ListNode current = head;
		while (current != null) {
			if (current.data.compareTo(element) == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Returns the element at a given index.
	 * 
	 * @param idx the index being checked.
	 * @return the element at the given index.
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		ListNode current = head;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Determines the size of the list.
	 * 
	 * @return the size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * The ListNode class is an inner class handling nodes in the linked list.
	 */
	private class ListNode {
		/** Data stored in the node. */
		public E data;
		/** The next list node in the list. */
		public ListNode next;

		/**
		 * Constructs a ListNode.
		 * 
		 * @param element  the data to be stored in the node.
		 * @param listNode the next listNode in the linked list.
		 */
		public ListNode(E element, ListNode listNode) {
			data = element;
			next = listNode;
		}
	}
}
