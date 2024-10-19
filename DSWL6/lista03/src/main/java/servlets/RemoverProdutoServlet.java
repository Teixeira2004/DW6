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


@WebServlet("/remover-produto")
public class RemoverProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		BaseProducts baseProducts = BaseProducts.getInstance();
		List<Produto> produtos = baseProducts.listarProdutos();
		
		out.println("<html><body><h2>");
		try {
			Produto p = produtos.get(Integer.valueOf(request.getParameter("id-produto")) - 1);
			if(produtos.remove(p)) {
				out.println("Produto removido com sucesso");
			} else {
				out.println("Erro ao remover o Produto");
			}
		} catch (Exception e) {
			out.println("Produto não encontrado");
		} finally {
			out.append("</h2></body></html>");
		}
	}

}
