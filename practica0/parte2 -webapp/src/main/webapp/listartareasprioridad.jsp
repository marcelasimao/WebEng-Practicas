int numTasks = 0;
PriorityType prioType = null;
			String prioridadTarea = "";
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
			
			for (Task task : list.getTaskList()) {
				
				if ( task.getPriority() == prioType ) {
					
					out.println( "<b>Tarea: </b>" + task.getName() + "<br>" );
					out.println( "<b>Descripcion de la tarea: </b>" + task.getContext() + "<br>" );
				
					if ( task.getProject() != null ) {
						out.println( "<b>Proyecto de la tarea: </b>" + task.getProject() + "<br>" );
					}
					
					out.println("<b>Prioridad:  </b>" + prioridadTarea + "<br><br>");
					
					numTasks++;
					
				}
				
			}
			
			if ( numTasks == 0 ) {
				out.println("No hay tareas en la ToDo List con esa prioridad: " + prioridadTarea +".");
			}