package servlet.todolistwebapp;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import com.google.gson.Gson;
import todolistjava.*;


@WebServlet(name ="ListTareas",urlPatterns = { "/listarTareas"})
public class ListTareas extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		int numTasks = 0;

		// set response content type
		response.setContentType("text/html");

		//ler os objetos JSON e carregá-los como objetos Java
		ToDoList list = gson.fromJson(new FileReader("todolist.json"), ToDoList.class);

		out.println("<h2>ToDo List - Practica 0 (parte2)</h2>");
		
		for ( Task task : list.getTaskList()) {
			out.println("</br>");
			out.println( "<b><u>Tarea</u></b>: " + task.getName() + "<br>" );
			out.println( "<b><u>Descripcion de la tarea</u></b>: " + task.getContext() + "<br>" );
			out.println( "<b><u>Proyecto de la tarea</u></b>: " + task.getProject() + "<br>" );
			out.println( "<b><u>Prioridad</u></b>: " + task.getPriority()+ "<br>" );

			numTasks++;
		}
		if ( numTasks == 0 ) {
			out.println("<h4>No hay tareas en la ToDo List</h4>");
		}
		out.println("<h3><a href='/index.html'>Voltar</a></h3>");
	}
	
}