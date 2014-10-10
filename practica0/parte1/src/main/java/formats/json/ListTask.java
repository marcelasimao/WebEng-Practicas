package formats.json;

import java.io.FileReader;

import com.google.gson.Gson;

import static formats.json.PriorityType.*;


class ListTask {
	public final static String DEFAULT_FILE_NAME = "todolist.json";

	// Iterates though all people in the AddressBook and prints info about them.
	static void Print(ToDoList todolist) {
		for (Task task : todolist.getTaskList()) {
			
			System.out.println("  Task: " + task.getName());
			System.out.println("  Context: " + task.getContext());
			System.out.println("  Project: " + task.getProject());
			System.out.print("  Priority: ");

			switch (task.getPriority()) {
				case BAJA:
					System.out.println("  BAJA\n");
					break;
				case MEDIA:
					System.out.println("  MEDIA\n");
					break;
				case ALTA:
					System.out.println("  ALTA\n");
					break;
			}
		}
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing address book.
		ToDoList todolist = gson.fromJson(new FileReader(
				filename), ToDoList.class);

		Print(todolist);
	}
}