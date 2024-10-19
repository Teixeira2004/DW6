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
import servlets.base.BaseProducts;


@WebServlet("/remover-lista-compras")
public class RemoverProdutoClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		BaseClients baseClients = BaseClients.getInstance();
		BaseProducts baseProducts = BaseProducts.getInstance();
		
		List<Cliente> clientes = baseClients.listarClientes();
		List<Produto> produtos = baseProducts.listarProdutos();
		
		out.println("<html><body><h2>");
		try {
			Cliente cliente = clientes.get(Integer.valueOf(request.getParameter("id-cliente")) - 1);		
			try {
				Produto produto = produtos.get(Integer.valueOf(request.getParameter("id-produto")) - 1);
				cliente.getProdutos().remove(produto);
				out.println("Produto removido da lista de compras");
			} catch (Exception e) {
				out.println("Produto não encontrado");
			}
		} catch (Exception e) {
			out.println("Cliente não encontrado");
		} finally {
			out.append("</h2></body></html>");
		}
		
	}

}
