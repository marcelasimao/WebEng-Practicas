package formats.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.google.gson.Gson;

import static formats.json.PriorityType.*;


public class AddTask {
	
	public final static String DEFAULT_FILE_NAME = "todolist.json";

	// This function fills in a Task message based on user input.
	static Task PromptForTask(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		Task task = new Task();

		stdout.print("Enter task: ");
		task.setName(stdin.readLine());

		stdout.print("Enter context: ");
		task.setContext(stdin.readLine());

		stdout.print("Enter project: ");
		task.setProject(stdin.readLine());

		stdout.print("Priority baja, media o alta? ");
		String priority = stdin.readLine();
		if (priority.equals("baja")) {
			task.setPriority(BAJA);
		} else if (priority.equals("media")) {
			task.setPriority(MEDIA);
		} else if (priority.equals("alta")) {
			task.setPriority(ALTA);
		} else {
			stdout.println("Unknown priority.  Using default.");
			task.setPriority(BAJA);
		}

		return task;
	}

	// Main function: Reads the entire address book from a file,
	// adds one Task based on user input, then writes it back out to the same
	// file.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename=args[0];
		}

		ToDoList todolist = new ToDoList();
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			todolist = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		// Add an address.
		todolist.addTask(PromptForTask(new BufferedReader(
				new InputStreamReader(System.in)), System.out));

		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(todolist));
		output.close();
	}
}
