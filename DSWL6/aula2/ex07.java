package com.exercicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class ex07
 */
@WebServlet("/ex07")
public class ex07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> mapContador = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ex07() {
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
		String nome = request.getParameter("nome");

		if (nome != null && !nome.isEmpty()) {
			synchronized (mapContador) {
				mapContador.put(nome, mapContador.getOrDefault(nome, 0) + 1);
			}
		}

		response.setContentType("text/html");

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Acessos por Usuário</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Contador de Acessos</h1>");
		response.getWriter().println("<ul>");

		synchronized (mapContador) {
			for (String usuario : mapContador.keySet()) {
				response.getWriter().println("<li>" + usuario + ": " + mapContador.get(usuario) + " acessos</li>");
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
		doGet(request, response);
	}

}
