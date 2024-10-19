package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cliente;
import servlets.base.BaseClients;


@WebServlet("/listar-clientes")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BaseClients baseClients = BaseClients.getInstance();
		List<Cliente> clientes = baseClients.listarClientes();

		if (clientes != null && !clientes.isEmpty()) {
			out.println("<html><body>");
			out.println("<h2>Lista de Clientes</h2>");
			out.println("<table border='1'>");
			out.println("<tr><th>ID</th><th>Nome</th></tr>");

			for (Cliente cliente : clientes) {
				out.println("<tr>");
				out.println("<td>" + cliente.getId() + "</td>");
				out.println("<td>" + cliente.getNome() + "</td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("</body></html>");
		} else {
			out.println("<html><body>");
			out.println("<h2>Não há clientes cadastrados.</h2>");
			out.println("</body></html>");
		}

		out.close();

	}

}
