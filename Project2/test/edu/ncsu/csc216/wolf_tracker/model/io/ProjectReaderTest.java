package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

/**
 * Tests the ProjectReader class.
 * 
 * @author Anoushka Piduru
 */
class ProjectReaderTest {
	/** Valid test file. */
	private String validTest = "test-files/project1.txt";
	/** Invalid test file. */
	private String invalidTest = "test-files/project3.txt";

	/**
	 * Tests reading a valid project file.
	 */
	@Test
	void testReadProjectFromValidFile() {
		File validFile = new File(validTest);
		assertTrue(validFile.exists());

		Project project = ProjectReader.readProjectFile(validFile);
		assertNotNull(project);

		assertEquals("CSC 216 Task Log", project.getProjectName());

		String[] categoryNames = project.getCategoryNames();
		assertEquals("All Tasks", categoryNames[0]);
		assertEquals("Debugging", categoryNames[1]);
		assertEquals("Deployment", categoryNames[2]);
		assertEquals("Design", categoryNames[3]);
		assertEquals("Documentation", categoryNames[4]);
		assertEquals("Implementation", categoryNames[5]);
		assertEquals("System Test", categoryNames[6]);
		assertEquals("Unit Test", categoryNames[7]);

		project.setCurrentTaskLog("All Tasks");
		assertEquals(14, project.getCurrentLog().getTaskCount());
		assertEquals("Read Project 2 requirements", project.getCurrentLog().getTask(0).getTaskTitle());
		assertEquals("Created CRC Cards", project.getCurrentLog().getTask(1).getTaskTitle());
		assertEquals("Transfered CRC Cards to UMLetino", project.getCurrentLog().getTask(2).getTaskTitle());
		assertEquals("Downloaded design proposal and rational template",
				project.getCurrentLog().getTask(3).getTaskTitle());
		assertEquals("Wrote design proposal and rationale", project.getCurrentLog().getTask(4).getTaskTitle());
		assertEquals("Identify 5 system tests", project.getCurrentLog().getTask(5).getTaskTitle());
		assertEquals("Created P2P2 skeleton", project.getCurrentLog().getTask(6).getTaskTitle());
		assertEquals("Added Javadoc", project.getCurrentLog().getTask(7).getTaskTitle());
		assertEquals("Implemented & Tested POJO", project.getCurrentLog().getTask(8).getTaskTitle());
		assertEquals("Implemented file reader class", project.getCurrentLog().getTask(9).getTaskTitle());
		assertEquals("Tested reader class", project.getCurrentLog().getTask(10).getTaskTitle());
		assertEquals("Debugging Reader Bug", project.getCurrentLog().getTask(11).getTaskTitle());
		assertEquals("Ran System Tests", project.getCurrentLog().getTask(12).getTaskTitle());
		assertEquals("Generated Javadoc", project.getCurrentLog().getTask(13).getTaskTitle());

		project.setCurrentTaskLog("Debugging");
		assertEquals(1, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("Deployment");
		assertEquals(0, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("Design");
		assertEquals(5, project.getCurrentLog().getTaskCount());
		assertEquals("Read Project 2 requirements", project.getCurrentLog().getTask(0).getTaskTitle());
		assertEquals(45, project.getCurrentLog().getTask(0).getTaskDuration());

		assertEquals("Created CRC Cards", project.getCurrentLog().getTask(1).getTaskTitle());
		assertEquals(27, project.getCurrentLog().getTask(1).getTaskDuration());

		project.setCurrentTaskLog("Documentation");
		assertEquals(2, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("Implementation");
		assertEquals(3, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("System Test");
		assertEquals(2, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("Unit Test");
		assertEquals(1, project.getCurrentLog().getTaskCount());

		// Test read and remove task
		project.setCurrentTaskLog("Design");
		project.getCurrentLog().removeTask(3);
		assertEquals(4, project.getCurrentLog().getTaskCount());

		project.setCurrentTaskLog("All Tasks");
		// assertEquals(13, project.getCurrentLog().getTaskCount());
		// project.getCurrentLog().removeTask(9);
		// assertEquals(12, project.getCurrentLog().getTaskCount());
		// project.setCurrentTaskLog("Unit Test");
		// assertEquals(0, project.getCurrentLog().getTaskCount());
	}

	/**
	 * Tests reading from specific invalid files.
	 */
	@Test
	void testReadProjectFromInvalidTestFile() {
		File invalidFile = new File(invalidTest);
		assertTrue(invalidFile.exists());
		assertThrows(IllegalArgumentException.class, () -> ProjectReader.readProjectFile(invalidFile));
	}
}
