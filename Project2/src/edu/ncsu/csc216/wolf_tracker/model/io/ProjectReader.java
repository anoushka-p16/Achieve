package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * The ProjectReader class handles the reading and processing of project files.
 * 
 * @author Anoushka Piduru
 */
public class ProjectReader {
	/**
	 * Reads project from a given file.
	 * 
	 * @param filename the file to be read from.
	 * @return the Project object created from file processing.
	 * @throws IllegalArgumentException if file was unable to load.
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

				if (projectString.startsWith("#")) {
					String categoryName = projectString.substring(1).trim();
					project.addCategoryLog(categoryName);
				}

				if (projectString.startsWith("*")) {
					processTask(project, projectStrings, i);
				}
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		project.setCurrentTaskLog("All Tasks");
		return project;
	}

	/**
	 * Processes each line of the project file.
	 * 
	 * @param project        the project being read.
	 * @param projectStrings the string array of each line of the project file.
	 * @param idx            the current starting index of the projectStrings array.
	 */
	private static void processTask(Project project, String[] projectStrings, int idx) {
		String taskLine = projectStrings[idx].substring(1).trim();
		String[] taskParams = taskLine.split(",");
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
		String[] categoryNames = project.getCategoryNames();
		boolean found = false;
		for (int i = 0; i < categoryNames.length; i++) {
			if (categoryName.equals(categoryNames[i])) {
				found = true;
			}
		}
		if (!found) {
			throw new IllegalArgumentException();
		}
		String taskDetails = processDetails(projectStrings, idx + 1);

		project.setCurrentTaskLog(categoryName);
		Task task = new Task(taskTitle, taskDuration, taskDetails);
		project.addTask(task);
	}

	/**
	 * Processes each line of the task's details.
	 * 
	 * @param projectStrings the string array of each line of the project.
	 * @param idx            the current starting index of the projectStrings array.
	 * @return the taskDetails as a string.
	 */
	private static String processDetails(String[] projectStrings, int idx) {
		String details = "";
		for (int i = idx; i < projectStrings.length; i++) {
			String line = projectStrings[i].trim();
			if (line.startsWith("*") || line.startsWith("#")) {
				break;
			}
			details += line + "\n";
		}
		return details.trim();
	}
}
