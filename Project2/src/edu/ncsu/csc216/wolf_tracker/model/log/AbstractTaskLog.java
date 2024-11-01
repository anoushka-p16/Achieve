package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;

/**
 * An abstract class representing a log of tasks. Extended by classes
 * representing the two possible types of task logs: AllTasksLog and
 * CategoryLog.
 * 
 * @author Anoushka Piduru
 */
public abstract class AbstractTaskLog {
	/** Represents the name of the task log. */
	private String taskLogName;

	/**
	 * Constructor for abstract task log.
	 * 
	 * @param taskListName the name of the task list.
	 */
	public AbstractTaskLog(String taskListName) {
		// Implement
	}

	/**
	 * Getter for task log name.
	 * 
	 * @return the name of the task log.
	 */
	public String getName() {
		return null;
	}

	/**
	 * Setter for task log name.
	 * 
	 * @param taskLogName the name of the task log.
	 */
	public void setTaskLogName(String taskLogName) {
		// Implement
	}

	/**
	 * Getter for task log.
	 * 
	 * @return a list of tasks.
	 */
	public ILogList<Task> getTasks() {
		return null;
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
	 * Sets the task at a specific index.
	 * 
	 * @param idx the index to hold the task.
	 * @param t   the task to be added.
	 */
	public void setTask(int idx, Task t) {
		// Implement
	}

	/**
	 * Removes the task at a specified index.
	 * 
	 * @param idx the index of the task to be removed.
	 * @return the task which was removed.
	 */
	public Task removeTask(int idx) {
		return null;
	}

	/**
	 * Returns the task at a specified index.
	 * 
	 * @param idx the index of the task.
	 * @return the task at the specified index.
	 */
	public Task getTask(int idx) {
		return null;
	}

	/**
	 * Determines the number of tasks added.
	 * 
	 * @return the number of tasks.
	 */
	public int getTaskCount() {
		return 0;
	}

	/**
	 * Determines the minimum duration recorded in the log.
	 * 
	 * @return the minimum time spent on a task.
	 */
	public int getMinDuration() {
		return 0;
	}

	/**
	 * Determines the maximum duration recorded in the log.
	 * 
	 * @return the maximum time spent on a task.
	 */
	public int getMaxDuration() {
		return 0;
	}

	/**
	 * Calculates the average duration from task log.
	 * 
	 * @return the average time spent on a task.
	 */
	public double getAvgDuration() {
		return 0;
	}

	/**
	 * Generates a 2D string representation of the task log.
	 * 
	 * @return a 2D string representation of the task log.
	 */
	public String[][] getTasksAsArray() {
		return null;
	}

	/**
	 * Returns a string representation of the task log.
	 * 
	 * @return string representation of task log.
	 */
	public String toString() {
		return null;
	}
}
