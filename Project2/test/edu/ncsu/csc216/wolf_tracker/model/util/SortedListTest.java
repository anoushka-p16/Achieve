package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the SortedList class.
 * 
 * @param <E> the generic type of the list.
 * @author Anoushka Piduru
 */
class SortedListTest<E> {
	/** Instance of SortedList for testing. */
	private SortedList<String> list;

	/**
	 * Creates a SortedList before each test.
	 */
	@BeforeEach
	void createList() {
		list = new SortedList<>();
	}

	/**
	 * Tests the add method.
	 */
	@Test
	void testAdd() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals(3, list.size());

		// Add null element
		assertThrows(NullPointerException.class, () -> list.add(null));

		// Add duplicate element
		assertThrows(IllegalArgumentException.class, () -> list.add("B"));

		list.add("D");
		list.add("E");
		assertEquals(5, list.size());
	}

	/**
	 * Tests the remove method.
	 */
	@Test
	void testRemoveLog() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		assertEquals(5, list.size());

		// Remove from beginning
		list.remove(0);
		assertEquals(4, list.size());
		assertEquals("B", list.get(0));

		// Remove from middle
		list.remove(2);
		assertEquals(3, list.size());
		assertEquals("E", list.get(2));

		// Invalid index
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
	}

	/**
	 * Tests the get method.
	 */
	@Test
	void testGetLog() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));

		list.remove(0);
		assertEquals(2, list.size());
		assertEquals("B", list.get(0));

		// Invalid index
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-3));
	}

	/**
	 * Tests the size method.
	 */
	@Test
	void testSize() {
		list.add("A");
		assertEquals(1, list.size());

		list.add("B");
		assertEquals(2, list.size());

		list.add("C");
		assertEquals(3, list.size());

		list.remove(0);
		assertEquals(2, list.size());
	}

	/**
	 * Tests the contains method.
	 */
	@Test
	void testContains() {
		list.add("A");
		list.add("B");
		list.add("C");

		assertTrue(list.contains("A"));
		assertFalse(list.contains("D"));

		list.remove(0);
		assertFalse(list.contains("A"));
	}

}
