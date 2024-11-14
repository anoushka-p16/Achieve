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
		assertEquals(45, project.getCurrentLog().getTask(0).getTaskDuration());

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
