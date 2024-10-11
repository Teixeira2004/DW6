package com.exercicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ex10
 */
@WebServlet("/ex10")
public class ex10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> tarefas = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ex10() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Lista de Tarefas</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Adicionar Tarefa</h1>");
		response.getWriter().println("<form action='ex10' method='POST'>");
		response.getWriter().println("Tarefa: <input type='text' name='tarefa' required><br>");
		response.getWriter().println("<input type='submit' value='Adicionar Tarefa'>");
		response.getWriter().println("</form>");

		response.getWriter().println("<h2>Tarefas Cadastradas:</h2>");
		response.getWriter().println("<ul>");

		synchronized (tarefas) {
			for (String tarefa : tarefas) {
				response.getWriter().println("<li>" + tarefa + "</li>");
			}
		}

		response.getWriter().println("</ul>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tarefa = request.getParameter("tarefa");

		if (tarefa != null && !tarefa.isEmpty()) {
			synchronized (tarefas) {
				tarefas.add(tarefa);
			}
		}

		doGet(request, response);
	}

}
