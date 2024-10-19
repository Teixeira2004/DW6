package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Produto;
import servlets.base.BaseProducts;


@WebServlet("/listar-produtos")
public class ListarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		BaseProducts baseProducts = BaseProducts.getInstance();
		List<Produto> produtos = baseProducts.listarProdutos();
		
		if (produtos != null && !produtos.isEmpty()) {
			out.println("<html><body>");
			out.println("<h2>Lista de Produtos</h2>");
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
			out.println("<h2>Não há produtos cadastrados.</h2>");
			out.println("</body></html>");
		}
		
		out.close();
	}

}
