package com.exercicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ex02
 */
@WebServlet("/ex02")
public class ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ex02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");

		response.setContentType("text/html");

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Bem-vindo</title></head>");
		response.getWriter().println("<body>");
		if (nome != null && !nome.isEmpty()) {
			response.getWriter().println("<h1>Fala, " + nome + "!</h1>");
		} else {
			response.getWriter().println("<h1>Aoba</h1>");
		}
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
