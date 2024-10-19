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
import models.Produto;
import servlets.base.BaseClients;


@WebServlet("/listar-produtos-cliente")
public class ListarProdutosClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		BaseClients baseClients = BaseClients.getInstance();
		 List<Cliente> clientes = baseClients.listarClientes();
		 
		 try {
			 Cliente c = clientes.get(Integer.valueOf(request.getParameter("id-cliente")) - 1);
			 List<Produto> produtos = c.getProdutos();
			 if (produtos != null && !produtos.isEmpty()) {
					out.println("<html><body>");
					out.println("<h2>Lista de Produtos do cliente " + c.getNome()+ " </h2>");
					out.println("<table border='1'>");
					out.println("<tr><th>ID</th><th>Nome</th><th>Preço</th></tr>");

					for (Produto produto : produtos) {
						out.println("<tr>");
						out.println("<td>" + produto.getId() + "</td>");
						out.println("<td>" + produto.getNome() + "</td>");
						out.println("<td>" + produto.getPreco() + "</td>");
						out.println("</tr>");
					}

					out.println("</table>");
					out.println("</body></html>");
				} else {
					out.println("<html><body>");
					out.println("<h2>Não há produtos na lista de compras do cliente.</h2>");
					out.println("</body></html>");
				}
				
				out.close();
		 } catch (Exception e) {
			out.println("<html><body><p>Cliente não encontrado</p></body></html>");
		}
	}

}
