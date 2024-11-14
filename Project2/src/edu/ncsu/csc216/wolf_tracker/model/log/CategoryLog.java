package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * The CategoryLog class represents one of the two possible types of task logs,
 * a category log. This includes all the tasks added to a specific category.
 * Extends the AbstractTaskLog class.
 * 
 * @author Anoushka Piduru
 */
public class CategoryLog extends AbstractTaskLog implements Comparable<CategoryLog> {
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
	 * @return 0 if the category names match, -1 if the name is lexicographically
	 *         less than the object being compared to, or 1 if the name
	 *         lexicographically greater.
	 */
	public int compareTo(CategoryLog c) {
		if (getName().compareToIgnoreCase(c.getName()) < 0) {
			return -1;
		} else if (getName().compareToIgnoreCase(c.getName()) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Overrides the abstract class method for the CategoryLog to add itself to the
	 * Task. Abstract class' setTask() is called.
	 * 
	 * @param idx the index at which a task is being set.
	 * @param t   the Task being set.
	 */
	@Override
	public void setTask(int idx, Task t) {
		super.setTask(idx, t);
		t.addCategory(this);
	}

	/**
	 * Overrides the abstract class method for the CategoryLog to add itself to the
	 * Task. Abstract class' addTask() is called.
	 * 
	 * @param t the task to be added.
	 */
	@Override
	public void addTask(Task t) {
		super.addTask(t);
		t.addCategory(this);
	}
}
