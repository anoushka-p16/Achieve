package edu.ncsu.csc216.wolf_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

/**
 * Tests the Task class.
 * 
 * @author Anoushka Piduru
 */
class TaskTest {
	/** Task instance for testing. */
	private Task task;
	/** CategoryLog instance for testing. */
	private CategoryLog category;

	/**
	 * Tests the task title.
	 */
	@Test
	void testTaskTitle() {
		task = new Task("Task", 45, "Description");
		assertEquals("Task", task.getTaskTitle());

		// Null title
		assertThrows(IllegalArgumentException.class, () -> new Task(null, 45, "Description"));
	}

	/**
	 * Tests the task duration.
	 */
	@Test
	void testTaskDuration() {
		task = new Task("Task", 45, "Description");
		assertEquals(45, task.getTaskDuration());

		// Null duration
		assertThrows(IllegalArgumentException.class, () -> new Task("Task", -5, "Description"));
	}

	/**
	 * Tests the task description.
	 */
	@Test
	void testTaskDetails() {
		task = new Task("Task", 45, "Description");
		assertEquals("Description", task.getTaskDetails());

		// Null details
		assertThrows(IllegalArgumentException.class, () -> new Task("Task", 45, null));
	}

	/**
	 * Tests the add category method.
	 */
	@Test
	void testAddCategory() {
		task = new Task("Task", 45, "Description");

		// Null category
		assertThrows(IllegalArgumentException.class, () -> task.addCategory(null));
		assertEquals("", task.getCategoryName());

		category = new CategoryLog("CSC116");
		task.addCategory(category);
		assertEquals("CSC116", task.getCategoryName());

	}

	/**
	 * Tests the toString method.
	 */
	@Test
	void testToString() {
		task = new Task("Task 1", 65, "Completed Project 1");
		category = new CategoryLog("CSC116");
		task.addCategory(category);

		assertEquals("Task 1,65,CSC116\nCompleted Project 1", task.toString());
	}

}
