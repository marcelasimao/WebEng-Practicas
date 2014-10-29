package formats.json;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

	private List<Task> taskList = new ArrayList<Task>();

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> tasks) {
		this.taskList = tasks;
	}

	public void addTask(Task task) {
		taskList.add(task);
	}
}
