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


@WebServlet("/remover-cliente")
public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BaseClients baseClients = BaseClients.getInstance();
		List<Cliente> clientes = baseClients.listarClientes();
		 
		out.println("<html><body><h2>");
		try {
			Cliente c = clientes.get(Integer.valueOf(request.getParameter("id-cliente")) - 1);
			if(clientes.remove(c)) {
				out.println("Cliente removido com sucesso");
			} else {
				out.println("Erro ao remover o cliente");
			}
		} catch (Exception e) {
			out.println("Cliente não encontrado");
		} finally {
			out.append("</h2></body></html>");
		}
	}

}
