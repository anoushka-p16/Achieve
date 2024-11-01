package edu.ncsu.csc216.wolf_tracker.model.task;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

/**
 * Handles a task in the WolfTracker system.
 * 
 * @author Anoushka Piduru
 */
public class Task {
	/** Name of the task. */
	private String taskTitle;
	/** Time spent on the task. */
	private int taskDuration;
	/** The task description. */
	private String taskDetails;
	/** Category the task belongs to. */
	private CategoryLog category;

	/**
	 * Constructor for Task.
	 * 
	 * @param taskTitle    the name of the task.
	 * @param taskDuration the time spent on the task.
	 * @param taskDetails  the task description.
	 */
	public Task(String taskTitle, int taskDuration, String taskDetails) {
		// Implement
	}

	/**
	 * Getter for the task title.
	 * 
	 * @param taskTitle the name of the task.
	 * @return the task title.
	 */
	public String getTaskTitle() {
		return null;
	}

	/**
	 * Setter for the task title.
	 * 
	 * @param taskTitle the name of the task.
	 */
	public void setTaskTitle(String taskTitle) {
		// Implement
	}

	/**
	 * Getter for the task duration.
	 * 
	 * @return the task duration.
	 */
	public int getTaskDuration() {
		return 0;
	}

	/**
	 * Setter for the task duration.
	 * 
	 * @param taskDuration the time spent on the task.
	 */
	public void setTaskDuration(int taskDuration) {
		// Implement
	}

	/**
	 * Getter for the task details.
	 * 
	 * @return the description of the task.
	 */
	public String getTaskDetails() {
		return null;
	}

	/**
	 * Setter for the task details.
	 * 
	 * @param taskDetails the description of the task.
	 */
	public void setTaskDetails(String taskDetails) {
		// Implement
	}

	/**
	 * Adds a new category.
	 * 
	 * @param category the category to be added.
	 */
	public void addCategory(CategoryLog category) {
		// Implement
	}

	/**
	 * Getter for the category name.
	 * 
	 * @return the name of the category.
	 */
	public String getCategoryName() {
		return null;
	}

	/**
	 * Forms a string representation of the task.
	 * 
	 * @return string representation of task.
	 */
	public String toString() {
		return null;
	}
}
