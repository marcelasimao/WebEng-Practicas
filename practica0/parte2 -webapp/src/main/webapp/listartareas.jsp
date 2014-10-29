
<%@page import="servlet.todolistwebappp"%>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="import todolistjava.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="import com.google.gson.Gson"%>

<html>
    <head>
        <title>ToDo List - Practica 0 (parte2)</title>
        <link href="CSS/montagem.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
            <div>
                <h1>
                   Listar Tareas
                </h1>
            </div>
                  <div>
                    <% 
                        int numTasks = 0;
                        Gson gson = new Gson();
                     	ToDoList list = gson.fromJson(new FileReader("todolist.json"), ToDoList.class) 
                            request.getAttribute("qualquerUm");
                        for (Task task : list.getTaskList()) {
                    %>
                    <tr>
                        <td>
                           <b>Tarea: </b>
                        </td>
                        <td>
                            <%=task.getName()%> 
                        </td>
                         <td>
                           <b>Descripcion de la tarea: </b>
                        </td>
                        <td>
                            <%=task.getContext()%> 
                        </td>
                        <td>
                           <b>Prioridad </b>
                        </td>
                        <td>
                            <%=task.getPriority()%> 
                        </td>                                           		
							<% numTasks++;%>
						<% }%>
						<% if ( numTasks == 0 ) {
							out.println("<h4>No hay tareas en la ToDo List</h4>"); %>
						 <% }%>
                        <td>
                            <a href="/index">
                                <span>Voltar</span>
                            </a>
                        </td>
                    </tr>
                    <% }%>
            </div>
        <div id="rodape"><!-- Rodabé -->
            <hr/>
            <footer>Marcela Simao - NIP: 707353</footer>
        </div>
    </body>
</html>