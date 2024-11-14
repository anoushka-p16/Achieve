package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

/**
 * Handles reading and processing project files.
 * 
 * @author Anoushka Piduru
 */
public class ProjectReader {
	/**
	 * Reads project from a given file.
	 * 
	 * @param filename the file to be read from.
	 * @return the Project object which was read.
	 */
	public static Project readProjectFile(File filename) {
		String s = "";
		Project project = null;

		try {
			Scanner scnr = new Scanner(new FileInputStream(filename));
			while (scnr.hasNextLine()) {
				s += scnr.nextLine() + "\n";
			}
			scnr.close();

			String[] projectStrings = s.split("\\r?\\n");

			String lineOne = projectStrings[0].trim();
			if (!lineOne.startsWith("!")) {
				throw new IllegalArgumentException("Unable to load file.");
			}

			project = new Project(lineOne.substring(1).trim());

			for (int i = 1; i < projectStrings.length; i++) {
				String projectString = projectStrings[i].trim();

				// If the line starts with "#", it's a category name
				if (projectString.startsWith("#")) {
					String categoryName = projectString.substring(1).trim();
					project.addCategoryLog(categoryName); // Add the category directly to the project
				}

				// If the line starts with "*", it's a task description
				if (projectString.startsWith("*")) {
					processTask(project, projectString); // Process the task
				}
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		return project;
	}

	/**
	 * Processes each line of the project file.
	 * 
	 * @param project the project being read.
	 * @param line    a line of the project file.
	 */
	private static void processTask(Project project, String line) {
		String[] taskParams = line.split("\\r?\\n?[*]");
		if (taskParams.length < 3) {
			return;
		}

		String taskTitle = taskParams[0].trim();
		int taskDuration;

		try {
			taskDuration = Integer.parseInt(taskParams[1].trim());
		} catch (NumberFormatException e) {
			return;
		}

		String categoryName = taskParams[2].trim();

		String taskDetails = "";
		for (int i = 3; i < taskParams.length; i++) {
			taskDetails += taskParams[i].trim() + "\n";
		}

		Task task = new Task(taskTitle, taskDuration, taskDetails);

		project.addCategoryLog(categoryName);
		project.setCurrentTaskLog(categoryName);
		project.addTask(task);
	}
}
