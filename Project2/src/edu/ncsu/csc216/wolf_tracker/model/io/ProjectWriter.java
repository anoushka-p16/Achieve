package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

/**
 * Handles writing projects and summary statistics to files.
 * 
 * @author Anoushka Piduru
 */
public class ProjectWriter {
	/**
	 * Writes project information to a given file.
	 * 
	 * @param filename the file being written to.
	 * @param project  the project being written.
	 */
	public static void writeProjectFile(File filename, Project project) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));
			pw.println("!" + project.getProjectName());
			String[] categoryLogs = project.getCategoryNames();
			for (int i = 0; i < categoryLogs.length; i++) {
				pw.println("#" + categoryLogs[i]);
			}

			for (int i = 0; i < project.getCurrentLog().getTaskCount(); i++) {
				Task task = project.getCurrentLog().getTask(i);
				pw.print(task.toString());
			}
			pw.close();

		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}

	/**
	 * Writes summary statistics of a project to a given file.
	 * 
	 * @param filename the file being written to.
	 * @param project  the project for which summary statistics are calculated.
	 */
	public static void writeStatsFile(File filename, Project project) {
		// Implement
	}
}
