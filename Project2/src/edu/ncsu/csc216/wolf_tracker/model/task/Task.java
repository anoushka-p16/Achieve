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
		setTaskTitle(taskTitle);
		setTaskDuration(taskDuration);
		setTaskDetails(taskDetails);
	}

	/**
	 * Getter for the task title.
	 * 
	 * @param taskTitle the name of the task.
	 * @return the task title.
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/**
	 * Setter for the task title.
	 * 
	 * @param taskTitle the name of the task.
	 * @throws IllegalArgumentException if task title is null or empty.
	 */
	public void setTaskTitle(String taskTitle) {
		if (taskTitle == null || taskTitle.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskTitle = taskTitle;
	}

	/**
	 * Getter for the task duration.
	 * 
	 * @return the task duration.
	 */
	public int getTaskDuration() {
		return taskDuration;
	}

	/**
	 * Setter for the task duration.
	 * 
	 * @param taskDuration the time spent on the task.
	 * @throws IllegalArgumentException if task duration is less than one minute.
	 */
	public void setTaskDuration(int taskDuration) {
		if (taskDuration < 1) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDuration = taskDuration;
	}

	/**
	 * Getter for the task details.
	 * 
	 * @return the description of the task.
	 */
	public String getTaskDetails() {
		return taskDetails;
	}

	/**
	 * Setter for the task details.
	 * 
	 * @param taskDetails the description of the task.
	 * @throws IllegalArgumentException if task details is null or empty.
	 */
	public void setTaskDetails(String taskDetails) {
		if (taskDetails == null || taskDetails.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDetails = taskDetails;
	}

	/**
	 * Adds a new category.
	 * 
	 * @param category the category to be added.
	 * @throws IllegalArgumentException if category is null or an assigned category
	 *                                  already exists.
	 */
	public void addCategory(CategoryLog category) {
		if (category == null || this.category != null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.category = category;
	}

	/**
	 * Getter for the category name.
	 * 
	 * @return the name of the category.
	 */
	public String getCategoryName() {
		if (category == null) {
			return "";
		}
		return category + "";
	}

	/**
	 * Forms a string representation of the task.
	 *
	 * @return string representation of task.
	 */
	public String toString() {
		String s = "";
		s += taskTitle + "," + taskDuration + "," + category + "\n";
		s += taskDetails;
		return s;
	}
}
