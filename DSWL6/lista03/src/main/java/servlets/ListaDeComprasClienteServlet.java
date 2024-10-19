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

@WebServlet("/adicionar-lista-compras")
public class ListaDeComprasClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		BaseClients baseClients = BaseClients.getInstance();
		BaseProducts baseProducts = BaseProducts.getInstance();
		
		List<Cliente> clientes = baseClients.listarClientes();
		List<Produto> produtos = baseProducts.listarProdutos();
		
		try {
			Cliente cliente = clientes.get(Integer.valueOf(request.getParameter("id-cliente")) - 1);		
			try {
				Produto produto = produtos.get(Integer.valueOf(request.getParameter("id-produto")) - 1);
				cliente.adicionarProduto(produto);
				out.println("Produto adicionado a lista de compras");
			} catch (Exception e) {
				out.println("Produto não encontrado");
			}
		} catch (Exception e) {
			out.println("Cliente não encontrado");
		}
		
	}

}
