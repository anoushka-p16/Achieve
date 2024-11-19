package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

/**
 * The AbstractTaskLog class is an abstract class representing a log of tasks.
 * Extended by classes representing the two possible types of task logs:
 * AllTasksLog and CategoryLog.
 * 
 * @author Anoushka Piduru
 */
public abstract class AbstractTaskLog {
	/** Represents the name of the task log. */
	private String taskLogName;
	/** The ILogList of tasks. */
	private ILogList<Task> list;

	/**
	 * Constructor for abstract task log.
	 * 
	 * @param taskListName the name of the task list.
	 * @throws IllegalArgumentException if task list name is null or empty.
	 */
	public AbstractTaskLog(String taskListName) {
		if (taskListName == null || taskListName.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}
		setTaskLogName(taskListName);
		list = new LogList<Task>();
	}

	/**
	 * Getter for task log name.
	 * 
	 * @return the name of the task log.
	 */
	public String getName() {
		return taskLogName;
	}

	/**
	 * Setter for task log name.
	 * 
	 * @param taskLogName the name of the task log.
	 */
	public void setTaskLogName(String taskLogName) {
		this.taskLogName = taskLogName;
	}

	/**
	 * Getter for task log.
	 * 
	 * @return a list of tasks.
	 */
	public ILogList<Task> getTasks() {
		return list;
	}

	/**
	 * Adds a new task.
	 * 
	 * @param t the task to be added.
	 */
	public void addTask(Task t) {
		list.addLog(t);
	}

	/**
	 * Sets the task at a specific index.
	 * 
	 * @param idx the index to hold the task.
	 * @param t   the task to be added.
	 */
	public void setTask(int idx, Task t) {
		list.setLog(idx, t);
	}

	/**
	 * Removes the task at a specified index.
	 * 
	 * @param idx the index of the task to be removed.
	 * @return the task which was removed.
	 */
	public Task removeTask(int idx) {
		return list.removeLog(idx);
	}

	/**
	 * Returns the task at a specified index.
	 * 
	 * @param idx the index of the task.
	 * @return the task at the specified index.
	 */
	public Task getTask(int idx) {
		return list.getLog(idx);
	}

	/**
	 * Determines the number of tasks added.
	 * 
	 * @return the number of tasks.
	 */
	public int getTaskCount() {
		return list.size();
	}

	/**
	 * Determines the minimum duration recorded in the log.
	 * 
	 * @return the minimum time spent on a task.
	 */
	public int getMinDuration() {
		if (getTaskCount() == 0) {
			return 0;
		}
		int min = list.getLog(0).getTaskDuration();
		for (int i = 1; i < getTaskCount(); i++) {
			if (list.getLog(i).getTaskDuration() < min) {
				min = list.getLog(i).getTaskDuration();
			}
		}
		return min;
	}

	/**
	 * Determines the maximum duration recorded in the log.
	 * 
	 * @return the maximum time spent on a task.
	 */
	public int getMaxDuration() {
		if (getTaskCount() == 0) {
			return 0;
		}
		int max = list.getLog(0).getTaskDuration();
		for (int i = 1; i < getTaskCount(); i++) {
			if (list.getLog(i).getTaskDuration() > max) {
				max = list.getLog(i).getTaskDuration();
			}
		}
		return max;
	}

	/**
	 * Calculates the average duration from task log.
	 * 
	 * @return the average time spent on a task.
	 */
	public double getAvgDuration() {
		if (getTaskCount() == 0) {
			return 0;
		}
		int average = 0;
		for (int i = 0; i < getTaskCount(); i++) {
			average += list.getLog(i).getTaskDuration();
		}
		double avg = (double) average / getTaskCount();

		avg = Math.round(avg * 10.0) / 10.0;
		return avg;
	}

	/**
	 * Generates a 2D string representation of the task log.
	 * 
	 * @return a 2D string representation of the task log.
	 */
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[getTaskCount()][3];
		for (int i = 0; i < getTaskCount(); i++) {
			taskArray[i][0] = list.getLog(i).getTaskTitle();
			taskArray[i][1] = list.getLog(i).getTaskDuration() + "";
			taskArray[i][2] = list.getLog(i).getCategoryName();
		}
		return taskArray;
	}

	/**
	 * Returns a string representation of the task log.
	 * 
	 * @return string representation of task log.
	 */
	public String toString() {
		String minDuration = "";
		if (getMinDuration() == 0) {
			minDuration += "";
		} else {
			minDuration = getMinDuration() + "";
		}

		String maxDuration = "";
		if (getMaxDuration() == 0) {
			maxDuration += "";
		} else {
			maxDuration = getMaxDuration() + "";
		}

		String avgDuration = "";
		if (getAvgDuration() == 0) {
			avgDuration += "";
		} else {
			avgDuration = getAvgDuration() + "";
		}

		String s = "";
		s += getName() + "," + getTaskCount() + "," + minDuration + "," + maxDuration + "," + avgDuration;
		return s;
	}
}
