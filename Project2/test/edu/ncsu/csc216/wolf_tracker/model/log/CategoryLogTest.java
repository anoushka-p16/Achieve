package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the CategoryLog class.
 * 
 * @author Anoushka Piduru
 */
class CategoryLogTest {
	/** Task instance for testing. */
	private Task task1;
	/** Task instance for testing. */
	private Task task2;
	/** Task instance for testing. */
	private Task task3;
	/** Category instance for testing. */
	private CategoryLog log;
	/** Category instance for testing. */
	private CategoryLog log2;
	/** Category instance for testing. */
	private CategoryLog log3;
	/** Category instance for testing. */
	private CategoryLog log4;

	/**
	 * Tests the set task method.
	 */
	@Test
	void testSetTask() {
		task1 = new Task("Task 1", 35, "Description 1");
		task2 = new Task("Task 2", 95, "Description 2");
		task3 = new Task("Task 3", 80, "Description 3");

		log = new CategoryLog("Projects");

		log.addTask(task1);
		log.addTask(task2);

		log.setTask(1, task3);
		assertEquals("Task 1", log.getTask(0).getTaskTitle());
		assertEquals("Description 3", log.getTask(1).getTaskDetails());
	}

	/**
	 * Tests the add task method.
	 */
	@Test
	void testAddTask() {
		task1 = new Task("Task 1", 80, "Description 1");
		task2 = new Task("Task 2", 35, "Description 2");
		task3 = new Task("Task 3", 95, "Description 3");

		log = new CategoryLog("Projects");

		log.addTask(task1);
		log.addTask(task2);
		log.addTask(task3);

		assertEquals("Task 1", log.getTask(0).getTaskTitle());
		assertEquals("Description 2", log.getTask(1).getTaskDetails());
		assertEquals(95, log.getTask(2).getTaskDuration());
	}

	/**
	 * Tests the comparing method.
	 */
	@Test
	void testCompareTo() {
		log = new CategoryLog("Projects");
		log2 = new CategoryLog("Homework");
		log3 = new CategoryLog("homework");
		log4 = new CategoryLog("Labs");

		assertEquals(0, log2.compareTo(log3));
		assertEquals(-1, log3.compareTo(log));
		assertEquals(1, log4.compareTo(log3));
	}
}
