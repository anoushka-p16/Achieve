package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * The LogList class implements the ILogList interface with functionality for an
 * array list.
 * 
 * @param <E> the list of elements.
 * @author Anoushka Piduru
 */
public class LogList<E> implements ILogList<E> {
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
		list = (E[]) new Object[INIT_CAP];
		size = 0;
	}

	/**
	 * Adds the element to the end of the list.
	 * 
	 * @param element the element being added.
	 * @throws NullPointerException if element is null.
	 */
	public void addLog(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		ensureCapacity(size);
		list[size] = element;
		size++;
	}

	/**
	 * Set the log at the given index to the given element.
	 * 
	 * @param idx     the index to be added to.
	 * @param element the element to be added.
	 * @throws NullPointerException if element is null, or IndexOutOfBoundsException
	 *                              if index is out of valid bounds.
	 */
	public void setLog(int idx, E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		list[idx] = element;
	}

	/**
	 * Removes the element at a given index.
	 * 
	 * @param idx the index to be removed.
	 * @return the element at the given index.
	 * @throws IndexOutOfBoundsException if index is out of valid bounds.
	 */
	public E removeLog(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E remove = list[idx];
		for (int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		size--;
		return remove;
	}

	/**
	 * Returns the element at a given index.
	 * 
	 * @param idx the index of the element to be returned.
	 * @return the element at the given index.
	 * @throws IndexOutOfBoundsException if index is out of valid bounds.
	 */
	public E getLog(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return list[idx];
	}

	/**
	 * Determines the current size of the list.
	 * 
	 * @return the size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Ensures the capacity of the list has not been exceeded. If the capacity has
	 * been exceeded, a grow array functionality is carried out.
	 * 
	 * @param size the size of the list.
	 */
	private void ensureCapacity(int size) {
		if (size >= list.length) {
			E[] doubleArray = (E[]) new Object[list.length * 2];
			for (int i = 0; i < list.length; i++) {
				doubleArray[i] = list[i];
			}
			list = doubleArray;
		}
	}
}
