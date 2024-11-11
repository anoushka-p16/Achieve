package edu.ncsu.csc216.wolf_tracker.model.project;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.io.ProjectWriter;
import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tracker.model.util.SortedList;

/**
 * Handles a project in the WolfTracker system.
 * 
 * @author Anoushka Piduru
 */
public class Project {
	/** An ISortedList of CategoryLogs. */
	private ISortedList<CategoryLog> categoryLogs;
	/** An AllTasksLog. */
	private AllTasksLog allTasksLog;
	/** An AbstractTaskLog for the current log. */
	private AbstractTaskLog currentLog;
	/** The name of the project. */
	private String projectName;
	/** Represents if project was modified since last file save. */
	private boolean isChanged;

	/**
	 * Constructor for Project.
	 * 
	 * @param projectName the name of the project.
	 */
	public Project(String projectName) {
		if (projectName == null || projectName.isEmpty() || projectName.equals(AllTasksLog.ALL_TASKS_NAME)) {
			throw new IllegalArgumentException();
		}
		this.projectName = projectName;
		this.categoryLogs = new SortedList<CategoryLog>();
		this.allTasksLog = new AllTasksLog();
		this.currentLog = allTasksLog;
		this.isChanged = true;
	}

	/**
	 * Saves the project to a file.
	 * 
	 * @param projectFile the name of the file being saved to.
	 */
	public void saveProject(File projectFile) {
		isChanged = false;
		ProjectWriter.writeProjectFile(projectFile, this);
	}

	/**
	 * Saves the summary statistics to a file.
	 * 
	 * @param statsFile the name of the file being saved to.
	 */
	public void saveStats(File statsFile) {
		ProjectWriter.writeStatsFile(statsFile, this);
	}

	/**
	 * Getter for the project name.
	 * 
	 * @return the name of the project.
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Setter for the project name.
	 * 
	 * @param projectName the name of the project.
	 */
	private void setProjectName(String projectName) {
		// Implement
	}

	/**
	 * Determines whether the project has changed since the last save.
	 * 
	 * @return true if the project has changed, false if not.
	 */
	public boolean isChanged() {
		return false;
	}

	/**
	 * Setter for the isChanged() method.
	 * 
	 * @param isChanged the boolean value for whether the project has changed or
	 *                  not.
	 */
	public void setChanged(boolean isChanged) {
		// Implement
	}

	/**
	 * Adds a new category log.
	 * 
	 * @param categoryName the name of the category.
	 */
	public void addCategoryLog(String categoryName) {
		CategoryLog log = new CategoryLog(categoryName);
	}

	/**
	 * Getter for the list of category names.
	 * 
	 * @return a string array of category names.
	 */
	public String[] getCategoryNames() {
		return null;
	}

	/**
	 * Sets the currentLog to the AbstractTaskLog with the given name.
	 * 
	 * @param logName the name of the log.
	 */
	public void setCurrentTaskLog(String logName) {
		// Implement
	}

	/**
	 * Getter for the current log.
	 * 
	 * @return an abstract task log representing the current log.
	 */
	public AbstractTaskLog getCurrentLog() {
		return null;
	}

	/**
	 * Changes the name of the category log.
	 * 
	 * @param categoryName the new category name.
	 */
	public void editCategoryLogName(String categoryName) {
		// Implement
	}

	/**
	 * Removes a category log.
	 */
	public void removeCategoryLog() {
		// Implement
	}

	/**
	 * Adds a new task.
	 * 
	 * @param t the task to be added.
	 */
	public void addTask(Task t) {
		// Implement
	}

	/**
	 * Edits an existing task.
	 * 
	 * @param idx          the index of the task.
	 * @param taskName     the name of the task.
	 * @param taskDuration the time spent on the task.
	 * @param taskDetails  the description of the task.
	 */
	public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
		// Implement
	}

	/**
	 * Removes the task at a given index.
	 * 
	 * @param idx the index of the task.
	 */
	public void removeTask(int idx) {
		// Implement
	}

	/**
	 * Determines the most recent tasks of each category.
	 * 
	 * @return a 2D string array of the most recent tasks of each category.
	 */
	public String[][] getMostRecentTasks() {
		return null;
	}
}
