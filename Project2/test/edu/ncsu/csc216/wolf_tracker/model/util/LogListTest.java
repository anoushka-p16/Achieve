package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the LogList class.
 * 
 * @param <E> the generic type of the list.
 * @author Anoushka Piduru
 */
class LogListTest<E> {
	/** Instance of LogList for testing. */
	private LogList<Integer> list;

	/**
	 * Creates a LogList before each test.
	 */
	@BeforeEach
	void createList() {
		list = new LogList<>();
	}

	/**
	 * Tests the addLog method.
	 */
	@Test
	void testAddLog() {
		list.addLog(1);
		list.addLog(2);
		list.addLog(3);
		assertEquals(3, list.size());

		list.addLog(4);
		list.addLog(5);
		assertEquals(5, list.size());

		list.addLog(6);
		list.addLog(7);
		list.addLog(8);
		list.addLog(9);
		list.addLog(10);
		assertThrows(IllegalArgumentException.class, () -> list.addLog(11));

		// Null element
		assertThrows(NullPointerException.class, () -> list.addLog(null));
	}

	/**
	 * Tests the setLog method.
	 */
	@Test
	void testSetLog() {
		// Null element
		assertThrows(NullPointerException.class, () -> list.setLog(0, null));

		// Invalid index
		assertThrows(IndexOutOfBoundsException.class, () -> list.setLog(-1, 5));

		list.addLog(1);
		list.addLog(2);
		list.addLog(3);

		list.setLog(0, 4);
		list.setLog(1, 5);
		assertEquals(3, list.size());
		assertEquals(4, list.getLog(0));
		assertEquals(5, list.getLog(1));
	}

	/**
	 * Tests the removeLog method.
	 */
	@Test
	void testRemoveLog() {
		list.addLog(1);
		list.addLog(2);
		list.addLog(3);
		assertEquals(3, list.size());

		list.removeLog(0);
		list.removeLog(1);
		assertEquals(1, list.size());
		assertEquals(2, list.getLog(0));

		// Invalid index
		assertThrows(IndexOutOfBoundsException.class, () -> list.removeLog(5));
	}

	/**
	 * Tests the getLog method.
	 */
	@Test
	void testGetLog() {
		list.addLog(1);
		list.addLog(2);
		list.addLog(3);
		assertEquals(3, list.size());
		assertEquals(1, list.getLog(0));
		assertEquals(2, list.getLog(1));
		assertEquals(3, list.getLog(2));

		list.removeLog(0);
		list.removeLog(1);
		assertEquals(1, list.size());
		assertEquals(2, list.getLog(0));

		// Invalid index
		assertThrows(IndexOutOfBoundsException.class, () -> list.getLog(-3));
	}

	/**
	 * Tests the size method.
	 */
	@Test
	void testSize() {
		list.addLog(1);
		assertEquals(1, list.size());

		list.addLog(2);
		assertEquals(2, list.size());

		list.addLog(3);
		assertEquals(3, list.size());

		list.removeLog(0);
		assertEquals(2, list.size());
	}

}
