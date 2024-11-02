package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * Implements the ILogList interface with functionality for an array-based list.
 * 
 * @param <E> the list of elements.
 * @author Anoushka Piduru
 */
public class LogList<E extends Comparable<E>> implements ILogList<E> {
	/** A list of elements. */
	private E[] list;
	/** The size of the list. */
	private int size;
	/** The constant capacity of the list. */
	private final static int INIT_CAP = 10;

	/**
	 * Constructor for LogList.
	 */
	public LogList() {
		// Implement
	}

	/**
	 * Adds the element to the end of the list.
	 * 
	 * @param element the element being added.
	 */
	public void addLog(E element) {
		// Implement
	}

	/**
	 * Set the log at the given index to the given element.
	 * 
	 * @param idx     the index to be added to.
	 * @param element the element to be added.
	 */
	public void setLog(int idx, E element) {
		// Implement
	}

	/**
	 * Removes the element at a given index.
	 * 
	 * @param idx the index to be removed.
	 * @return the element at the given index.
	 */
	public E removeLog(int idx) {
		return null;
	}

	/**
	 * Returns the element at a given index.
	 * 
	 * @param idx the index of the element to be returned.
	 * @return the element at the given index.
	 */
	public E getLog(int idx) {
		return null;
	}

	/**
	 * Determines the current size of the list.
	 * 
	 * @return the size of the list.
	 */
	public int size() {
		return 0;
	}

	/**
	 * Ensures the capacity of the list has not been exceeded.
	 * 
	 * @param INIT_CAP the capacity of the list.
	 */
	private void ensureCapacity(int INIT_CAP) {
		// Implement
	}
}
