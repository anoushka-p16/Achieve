package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * Implements the ISortedList interface. Handles functionality for linked lists.
 * 
 * @param <E> the list of elements.
 * @author Anoushka Piduru
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** The size of the linked list. */
	private int size;

	/**
	 * Constructor for SortedList.
	 */
	public SortedList() {
		// Implement
	}

	/**
	 * Adds an element to the list in sorted order.
	 * 
	 * @param element the element to be added.
	 */
	public void add(E element) {
		// Implement
	}

	/**
	 * Removes the element at a given index.
	 * 
	 * @param idx the index to be removed.
	 * @return the element at the given index.
	 */
	public E remove(int idx) {
		return null;
	}

	/**
	 * Determined if the list contains a given element.
	 * 
	 * @param element the element being checked for.
	 * @return true if the list contains the element, false if not.
	 */
	public boolean contains(E element) {
		return false;
	}

	/**
	 * Returns the element at a given index.
	 * 
	 * @param idx the index being checked.
	 * @return the element at the given index.
	 */
	public E get(int idx) {
		return null;
	}

	/**
	 * Determines the size of the list.
	 * 
	 * @return the size of the list.
	 */
	public int size() {
		return 0;
	}

	/**
	 * Inner class handling nodes in the linked list.
	 */
	private class ListNode {
		/** Data stored in the node. */
		public E data;

		/**
		 * Constructs a ListNode.
		 * 
		 * @param element  the data to be stored in the node.
		 * @param listNode the next listNode in the linked list.
		 */
		public ListNode(E element, ListNode listNode) {
			// Implement
		}
	}
}
