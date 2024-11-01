package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Represents one of the two possible types of task logs, a category log.
 * Extends the AbstractTaskLog class.
 * 
 * @author Anoushka Piduru
 */
public class CategoryLog extends AbstractTaskLog {
	/**
	 * Constructor for CategoryLog.
	 * 
	 * @param categoryName the name of the category.
	 */
	public CategoryLog(String categoryName) {
		super(categoryName);
	}

	/**
	 * Compares the names of the category logs, ignoring case.
	 * 
	 * @param c the category log being compared to.
	 * @return 0 if the category names match, 1 if not.
	 */
	public int compareTo(CategoryLog c) {
		return 0;
	}

	/**
	 * Overrides the abstract class method. Abstract class' setTask() is called. The
	 * CategoryLog will add itself to the Task.
	 * 
	 * @param idx the index at which a task is being set.
	 * @param t   the Task being set.
	 */
	@Override
	public void setTask(int idx, Task t) {
		// Implement
	}

	/**
	 * Overrides the abstract class method. Abstract class' addTask() is called. The
	 * CategoryLog will add itself to the Task.
	 * 
	 * @param t the task to be added.
	 */
	@Override
	public void addTask(Task t) {
		// Implement
	}
}
