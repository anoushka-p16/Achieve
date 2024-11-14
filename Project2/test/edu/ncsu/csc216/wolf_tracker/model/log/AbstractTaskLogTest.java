package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the AbstractTaskLog class.
 * 
 * @author Anoushka Piduru
 */
class AbstractTaskLogTest {
	/** Task instance for testing. */
	private Task task1;
	/** Task instance for testing. */
	private Task task2;
	/** Task instance for testing. */
	private Task task3;
	/** Category instance for testing. */
	private AbstractTaskLog log;
	/** Category instance for testing. */
	private AbstractTaskLog log2;

	/**
	 * Tests the construction of an AbstractTaskLog object.
	 */
	@Test
	void testAbstractTaskLogConstruction() {
		assertThrows(IllegalArgumentException.class, () -> new CategoryLog(null));
		assertThrows(IllegalArgumentException.class, () -> new CategoryLog(""));

		log = new CategoryLog("Projects");
		assertNotNull(log);
	}

	/**
	 * Tests the task log name setting.
	 */
	@Test
	void testSetTaskLogName() {
		log = new CategoryLog("Projects");

		log.setTaskLogName("Project 1");
		assertEquals("Project 1", log.getName());
	}

	/**
	 * Tests the getTasks method, duration calculations, and addTask.
	 */
	@Test
	void testGetTasksCountAndDuration() {
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

		assertEquals(3, log.getTaskCount());
		assertEquals(35, log.getMinDuration());
		assertEquals(95, log.getMaxDuration());
	}

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
	 * Tests the remove task method.
	 */
	@Test
	void testRemoveTask() {
		task1 = new Task("Task 1", 35, "Description 1");
		task2 = new Task("Task 2", 95, "Description 2");
		task3 = new Task("Task 3", 80, "Description 3");

		log = new CategoryLog("Projects");

		log.addTask(task1);
		log.addTask(task2);
		log.addTask(task3);

		assertEquals("Task 1", log.getTask(0).getTaskTitle());
		assertEquals("Description 2", log.getTask(1).getTaskDetails());
		assertEquals(80, log.getTask(2).getTaskDuration());

		log.removeTask(1);
		assertEquals("Task 3", log.getTask(1).getTaskTitle());
		assertThrows(IndexOutOfBoundsException.class, () -> log.getTask(2));
	}

	/**
	 * Tests the getTasksAsArrayMethod.
	 */
	@Test
	void testGetTasksAsArray() {
		task1 = new Task("Task 1", 35, "Description 1");
		task2 = new Task("Task 2", 95, "Description 2");
		task3 = new Task("Task 3", 80, "Description 3");

		log = new CategoryLog("Projects");

		log.addTask(task1);
		log.addTask(task2);

		log2 = new CategoryLog("Homework");

		log2.addTask(task3);

		String[][] array = log.getTasksAsArray();
		assertEquals("Task 1", array[0][0]);
		assertEquals("Task 2", array[1][0]);

		assertEquals("35", array[0][1]);
		assertEquals("95", array[1][1]);

		assertEquals("Projects", array[0][2]);
		assertEquals("Projects", array[1][2]);

		String[][] array2 = log2.getTasksAsArray();
		assertEquals("Task 3", array2[0][0]);
		assertEquals("80", array2[0][1]);
		assertEquals("Homework", array2[0][2]);
	}

	/**
	 * Tests the toString method.
	 */
	@Test
	void testToString() {
		task1 = new Task("Task 1", 35, "Description 1");
		task2 = new Task("Task 2", 95, "Description 2");
		task3 = new Task("Task 3", 80, "Description 3");

		log = new CategoryLog("Projects");
		log.addTask(task1);
		log.addTask(task2);

		log2 = new CategoryLog("Homework");
		log2.addTask(task3);

		assertEquals("Category,Count,Min,Max,Average\nProjects,2,35,95,65.0\n", log.toString());
		assertEquals("Category,Count,Min,Max,Average\nHomework,1,80,80,80.0\n", log2.toString());
	}

	/**
	 * Tests the getTasks method.
	 */
	@Test
	void testGetTasks() {
		task1 = new Task("Task 1", 80, "Description 1");
		task2 = new Task("Task 2", 35, "Description 2");
		task3 = new Task("Task 3", 95, "Description 3");

		log = new CategoryLog("Projects");

		log.addTask(task1);
		log.addTask(task2);
		log.addTask(task3);

		assertEquals("Task 1", log.getTasks().getLog(0).getTaskTitle());
		assertEquals("Task 2", log.getTasks().getLog(1).getTaskTitle());
		assertEquals("Task 3", log.getTasks().getLog(2).getTaskTitle());
	}
}
