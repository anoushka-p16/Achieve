package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

class ProjectReaderTest {
	/** Valid test file. */
	private String validTest = "test-files/project1.txt";

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
		assertEquals(0, project.getCurrentLog().getTaskCount());
	}

}
