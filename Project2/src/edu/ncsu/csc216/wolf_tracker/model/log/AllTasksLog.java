package edu.ncsu.csc216.wolf_tracker.model.log;

/**
 * The AllTasksLog class represents one of the two possible types of task logs,
 * All Tasks. This includes all tasks, regardless of category. Extends the
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
	 * @throws IllegalArgumentException if the log name is not "All Tasks".
	 */
	@Override
	public void setTaskLogName(String taskLogName) {
		if (!ALL_TASKS_NAME.equals(taskLogName)) {
			throw new IllegalArgumentException("The All Tasks log may not be edited.");
		}
		super.setTaskLogName(taskLogName);
	}
}
