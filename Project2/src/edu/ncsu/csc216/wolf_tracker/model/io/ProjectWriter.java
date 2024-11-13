package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

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
			pw.println("! " + project.getProjectName());

			String[] categoryLogs = project.getCategoryNames();
			for (int i = 1; i < categoryLogs.length; i++) {
				pw.println("# " + categoryLogs[i]);
			}

			for (int i = 1; i < categoryLogs.length; i++) {
				project.setCurrentTaskLog(categoryLogs[i]);
				for (int j = 0; j < project.getCurrentLog().getTaskCount(); j++) {
					Task task = project.getCurrentLog().getTask(j);
					pw.println(task.toString());
				}
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
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filename));

			String[] categoryLogs = project.getCategoryNames();

			if (categoryLogs.length > 0) {
				for (int i = 1; i < categoryLogs.length; i++) {
					String categoryName = categoryLogs[i];

					project.setCurrentTaskLog(categoryName);
					AbstractTaskLog categoryLog = project.getCurrentLog();
					pw.println(categoryLog.toString());
				}
			}
			project.setCurrentTaskLog("All Tasks");
			AbstractTaskLog allTasksLog = project.getCurrentLog();
			pw.println(allTasksLog.toString());
			pw.close();

		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
