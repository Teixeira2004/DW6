package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cliente;
import servlets.base.BaseClients;

@WebServlet("/adicionar-cliente")
public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String nome = request.getParameter("nome");

		BaseClients baseClients = BaseClients.getInstance();
		List<Cliente> clientes = baseClients.listarClientes();

		int clienteId = clientes.size() + 1;

		Cliente cliente = new Cliente(nome, clienteId);
		clientes.add(cliente);

		response.getWriter().println("<html><body><h2>Cliente adicionado com sucesso!</h2></body></html>");
	}

}
