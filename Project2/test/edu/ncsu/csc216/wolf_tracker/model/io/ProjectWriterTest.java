package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the ProjectWriter class.
 * 
 * @author Anoushka Piduru
 */
class ProjectWriterTest {
	/** String representing the valid file path. */
	private String validStats = "test-files/expected_stats.txt";
	/** String representing valid file path. */
	private String validProject = "test-files/project1.txt";
	/** Instance of Project for testing. */
	private Project project;

	/**
	 * Tests the writeProjectFile method.
	 */
	@Test
	void testWriteProjectFile() {
		File validFile = new File(validProject);
		assertTrue(validFile.exists());

		project = new Project("CSC116");

		project.addCategoryLog("CSC");

		project.addTask(new Task("Task 1", 60, "Description 1"));
		project.addTask(new Task("Task 2", 60, "Description 2"));
		project.addTask(new Task("Task 3", 60, "Description 3"));
		assertEquals(3, project.getCurrentLog().getTaskCount());

		File validFile2 = new File("project_test.txt");
		ProjectWriter.writeProjectFile(validFile2, project);
	}

	/**
	 * Tests the writeStatsFile method.
	 */
	@Test
	void testWriteStatsFile() {
		File validFile = new File(validStats);
		assertTrue(validFile.exists());

		project = new Project("CSC116");
		project.addCategoryLog("CSC");

		project.addTask(new Task("Task 1", 60, "Description 1"));
		project.addTask(new Task("Task 2", 60, "Description 2"));
		project.addTask(new Task("Task 3", 60, "Description 3"));
		assertEquals(3, project.getCurrentLog().getTaskCount());

		File validFile2 = new File("stats_test.txt");
		ProjectWriter.writeStatsFile(validFile2, project);
	}

	/**
	 * Tests construction of ProjectWriter.
	 */
	@Test
	void testProjectWriterConstruction() {
		ProjectWriter projectWriter = new ProjectWriter();
		assertTrue(projectWriter instanceof ProjectWriter);
	}

}
