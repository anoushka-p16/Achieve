package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the AllTasksLog class.
 * 
 * @author Anoushka Piduru
 */
class AllTasksLogTest {
	/** Category instance for testing. */
	private AllTasksLog log;

	/**
	 * Tests the AllTasksLog object construction.
	 */
	@Test
	void testAllTasksLogConstruction() {
		log = new AllTasksLog();
		assertNotNull(log);
		assertEquals("All Tasks", log.getName());
	}

	/**
	 * Tests the setTaskLogName method.
	 */
	@Test
	void testSetTaskLogName() {
		log = new AllTasksLog();

		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			log.setTaskLogName("Other Tasks");
		});

		assertEquals("The All Tasks list may not be edited.", e.getMessage());
	}

}
