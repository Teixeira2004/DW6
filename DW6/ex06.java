package com.exercicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ex06
 */
@WebServlet("/ex06")
public class ex06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> comentarios = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ex06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Comentários</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Enviar Comentário</h1>");
		response.getWriter().println("<form action='ex06' method='POST'>");
		response.getWriter().println(
				"<textarea name='comentario' rows='4' cols='50' placeholder='Comenta aí' required></textarea><br>");
		response.getWriter().println("<input type='submit' value='Enviar Comentário'>");
		response.getWriter().println("</form>");

		response.getWriter().println("<h2>Comentários Submetidos:</h2>");
		response.getWriter().println("<ul>");

		synchronized (comentarios) {
			for (String comentario : comentarios) {
				response.getWriter().println("<li>" + comentario + "</li>");
			}
		}

		response.getWriter().println("</ul>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comentario = request.getParameter("comentario");

		if (comentario != null && !comentario.isEmpty()) {
			synchronized (comentarios) {
				comentarios.add(comentario);
			}
		}

		doGet(request, response);	}

}
