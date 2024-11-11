package edu.ncsu.csc216.wolf_tracker.model.log;

/**
 * Represents one of the two possible types of task logs, All Tasks. Extends the
 * AbstractTaskLog class.
 * 
 * @author Anoushka Piduru
 */
public class AllTasksLog extends AbstractTaskLog {
	/** Constant holding the name of All Tasks. */
	public static final String ALL_TASKS_NAME = "All Tasks";

	/**
	 * Constructor for AllTasksLog.
	 */
	public AllTasksLog() {
		super(ALL_TASKS_NAME);
	}

	/**
	 * Overrides the abstract method to ensure parameter value matches the expected
	 * name.
	 * 
	 * @param taskLogName the name of the task log.
	 */
	@Override
	public void setTaskLogName(String taskLogName) {
		if (!getName().equals(taskLogName)) {
			throw new IllegalArgumentException("The All Tasks list may not be edited.");
		}
		super.setTaskLogName(taskLogName);
	}
}
