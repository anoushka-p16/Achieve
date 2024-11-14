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
 * The Project class handles a project in the WolfTracker system.
 * 
 * @author Anoushka Piduru
 */
public class Project {
	/** An ISortedList of CategoryLogs. */
	private ISortedList<CategoryLog> categoryLogs;
	/** An instance of AllTasksLog. */
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
	 * @throws IllegalArgumentException if name is invalid.
	 */
	public Project(String projectName) {
		if (projectName == null || projectName.isEmpty() || projectName.equals(AllTasksLog.ALL_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		setProjectName(projectName);
		this.categoryLogs = new SortedList<CategoryLog>();
		this.allTasksLog = new AllTasksLog();
		this.currentLog = allTasksLog;
		setChanged(true);
	}

	/**
	 * Saves the project to a file.
	 * 
	 * @param projectFile the name of the file being saved to.
	 * @throws IllegalArgumentException if projectFile is null.
	 */
	public void saveProject(File projectFile) {
		if (projectFile == null) {
			throw new IllegalArgumentException();
		}
		setChanged(false);
		ProjectWriter.writeProjectFile(projectFile, this);
	}

	/**
	 * Saves the summary statistics to a file.
	 * 
	 * @param statsFile the name of the file being saved to.
	 * @throws IllegalArgumentException if statsFile is null.
	 */
	public void saveStats(File statsFile) {
		if (statsFile == null) {
			throw new IllegalArgumentException();
		}
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
	 * @throws IllegalArgumentException if projectName is invalid.
	 */
	void setProjectName(String projectName) {
		if (projectName == null || projectName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.projectName = projectName;
	}

	/**
	 * Determines whether the project has changed since the last save.
	 * 
	 * @return true if the project has changed, false if not.
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * Setter for the isChanged() method.
	 * 
	 * @param isChanged the boolean value for whether the project has changed or
	 *                  not.
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	/**
	 * Adds a new category log.
	 * 
	 * @param categoryName the name of the category.
	 * @throws IllegalArgumentException if name is invalid.
	 */
	public void addCategoryLog(String categoryName) {
		if (categoryName == null || categoryName.isEmpty() || categoryName.equals(AllTasksLog.ALL_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < categoryLogs.size(); i++) {
			if (categoryLogs.get(i).getName().equalsIgnoreCase(categoryName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		CategoryLog log = new CategoryLog(categoryName);
		categoryLogs.add(log);
		currentLog = log;
		setChanged(true);
	}

	/**
	 * Getter for the list of category names.
	 * 
	 * @return a string array of category names.
	 */
	public String[] getCategoryNames() {
		String[] categoryNames = new String[categoryLogs.size() + 1];
		categoryNames[0] = AllTasksLog.ALL_TASKS_NAME;
		for (int i = 0; i < categoryLogs.size(); i++) {
			categoryNames[i + 1] = categoryLogs.get(i).getName();
		}
		return categoryNames;
	}

	/**
	 * Sets the currentLog to the AbstractTaskLog with the given name.
	 * 
	 * @param logName the name of the log.
	 */
	public void setCurrentTaskLog(String logName) {
		if (logName.equals(AllTasksLog.ALL_TASKS_NAME)) {
			currentLog = allTasksLog;
		} else {
			for (int i = 0; i < categoryLogs.size(); i++) {
				if (categoryLogs.get(i).getName().equalsIgnoreCase(logName)) {
					currentLog = categoryLogs.get(i);
					return;
				}
			}
			currentLog = allTasksLog;
		}
		setChanged(true);
	}

	/**
	 * Getter for the current log.
	 * 
	 * @return an abstract task log representing the current log.
	 */
	public AbstractTaskLog getCurrentLog() {
		return currentLog;
	}

	/**
	 * Changes the name of the category log.
	 * 
	 * @param categoryName the new category name.
	 * @throws IllegalArgumentException if the name is invalid or currentLog is
	 *                                  AllTasksLog.
	 */
	public void editCategoryLogName(String categoryName) {
		if (categoryName == null || categoryName.isEmpty() || categoryName.equals(AllTasksLog.ALL_TASKS_NAME)
				|| categoryLogs.contains(new CategoryLog(categoryName))) {
			throw new IllegalArgumentException("Invalid name.");
		}

		for (int i = 0; i < categoryLogs.size(); i++) {
			if (categoryLogs.get(i).getName().equalsIgnoreCase(categoryName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}

		if (currentLog instanceof AllTasksLog) {
			throw new IllegalArgumentException("The All Tasks log may not be edited.");
		}

		CategoryLog editLog = (CategoryLog) currentLog;
		editLog.setTaskLogName(categoryName);

		for (int i = 0; i < categoryLogs.size(); i++) {
			if (categoryLogs.get(i).equals(editLog)) {
				categoryLogs.remove(i);
				break;
			}
		}
		categoryLogs.add(editLog);
		currentLog = editLog;
		setChanged(true);

	}

	/**
	 * Removes a category log.
	 * 
	 * @throws IllegalArgumentException if current log is the all tasks log.
	 */
	public void removeCategoryLog() {
		if (currentLog instanceof AllTasksLog) {
			throw new IllegalArgumentException("The All Tasks log may not be deleted.");
		}

		CategoryLog removeLog = (CategoryLog) currentLog;

		for (int i = 0; i < categoryLogs.size(); i++) {
			if (categoryLogs.get(i).equals(removeLog)) {
				categoryLogs.remove(i);
				break;
			}
		}

		for (int i = allTasksLog.getTaskCount() - 1; i >= 0; i--) {
			Task task = allTasksLog.getTask(i);
			if (task.getCategoryName().equals(removeLog.getName())) {
				allTasksLog.removeTask(i);
			}
		}
		currentLog = allTasksLog;
		setChanged(true);
	}

	/**
	 * Adds a new task.
	 * 
	 * @param t the task to be added.
	 */
	public void addTask(Task t) {
		if (currentLog instanceof CategoryLog) {
			currentLog.addTask(t);
		}
		allTasksLog.addTask(t);
		setChanged(true);
	}

	/**
	 * Edits an existing task.
	 * 
	 * @param idx          the index of the task.
	 * @param taskName     the name of the task.
	 * @param taskDuration the time spent on the task.
	 * @param taskDetails  the description of the task.
	 * @throws IllegalArgumentException if any of the parameters are invalid.
	 */
	public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
		if (idx < 0 || idx >= currentLog.getTaskCount() || taskName == null || taskName.isEmpty() || taskDuration < 0
				|| taskDetails == null || taskDetails.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Task task = currentLog.getTask(idx);
		task.setTaskTitle(taskName);
		task.setTaskDuration(taskDuration);
		task.setTaskDetails(taskDetails);

		setChanged(true);
	}

	/**
	 * Removes the task at a given index.
	 * 
	 * @param idx the index of the task.
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	public void removeTask(int idx) {
		if (idx < 0 || idx >= currentLog.getTaskCount()) {
			throw new IndexOutOfBoundsException();
		}
		Task removeTask = currentLog.getTask(idx);

		currentLog.removeTask(idx);

		for (int i = 0; i < allTasksLog.getTaskCount(); i++) {
			Task task = allTasksLog.getTask(i);
			if (task.equals(removeTask)) {
				allTasksLog.removeTask(i);
				break;
			}
		}

		setChanged(true);
	}

	/**
	 * Determines the most recent tasks of each category.
	 * 
	 * @return a 2D string array of the most recent tasks of each category.
	 */
	public String[][] getMostRecentTasks() {
		String[][] recentTasks = new String[categoryLogs.size() + 1][3];

		if (allTasksLog.getTaskCount() == 0) {
			recentTasks[0][0] = "None";
			recentTasks[0][1] = "";
			recentTasks[0][2] = AllTasksLog.ALL_TASKS_NAME;
		} else {
			Task recentTask = allTasksLog.getTask(allTasksLog.getTaskCount() - 1);
			recentTasks[0][0] = recentTask.getTaskTitle();
			recentTasks[0][1] = recentTask.getTaskDuration() + "";
			recentTasks[0][2] = AllTasksLog.ALL_TASKS_NAME;
		}

		for (int i = 0; i < categoryLogs.size(); i++) {
			CategoryLog categoryLog = categoryLogs.get(i);
			if (categoryLog.getTaskCount() == 0) {
				recentTasks[i + 1][0] = "None";
				recentTasks[i + 1][1] = "";
				recentTasks[i + 1][2] = categoryLog.getName();
			} else {
				Task recentTask = categoryLog.getTask(categoryLog.getTaskCount() - 1);
				recentTasks[i + 1][0] = recentTask.getTaskTitle();
				recentTasks[i + 1][1] = recentTask.getTaskDuration() + "";
				recentTasks[i + 1][2] = categoryLog.getName();
			}
		}
		return recentTasks;
	}
}
