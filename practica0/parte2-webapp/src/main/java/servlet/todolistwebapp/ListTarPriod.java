package servlet.todolistwebappp;

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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/listarPrioridades"})
public class ListTarPriod extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		Gson gson = new Gson();
		String prioridad = req.getParameter("prioridad");
		int numTasks = 0;
		
		// set response content type
		resp.setContentType("text/html");
		
		
		ToDoList list = gson.fromJson(new FileReader("todolist.json"), ToDoList.class);
		out.println("<h2>ToDo List - Practica 0 (parte2)</h2>");
		out.println("</br>");
		
		PriorityType prioType = null;
		String prioridadTarea = "";
		if (prioridad == null) {
			out.println("</br>");
			out.println("<h2>No has escogido ninguna prioridad!!</h2>");
			out.println("</br>");
		}else {
			switch ( prioridad ) {
					case "baja":
						prioType = PriorityType.BAJA;
						prioridadTarea = "Baja";
						break;
					case "media":
						prioType = PriorityType.MEDIA;
						prioridadTarea = "Media";
						break;
					case "alta":
						prioType = PriorityType.ALTA;
						prioridadTarea = "Alta";
						break;
				}
			
		}
		
		if (prioridad != null){
			out.println("Has escogido la prioridad: <b>"+ prioridadTarea+"</b>");
			out.println("</br>");
		}
		
		for (Task task : list.getTaskList()) {
			
			if ( task.getPriority() == prioType ) {
				out.println("</br>");
				out.println( "<b><u>Tarea</u>: </b>" + task.getName() + "<br>" );
				out.println( "<b><u>Descripcion de la tarea</u>: </b>" + task.getContext() + "<br>" );
				if ( task.getProject() != null ) {
					out.println( "<b><u>Proyecto de la tarea</u>: </b>" + task.getProject() + "<br>" );
				}
				out.println("<b><u>Prioridad</u>:  </b>" + prioridadTarea + "<br><br>");
				out.println("</br>");
				numTasks++;
			}
		}
		if ( numTasks == 0 && prioridad != null) {
			out.println("</br>");
			out.println("No hay tareas en la ToDo List con esa prioridad!!");
		}
		out.println("<h3><a href='/index.html'>Voltar</a></h3>");
	}
}