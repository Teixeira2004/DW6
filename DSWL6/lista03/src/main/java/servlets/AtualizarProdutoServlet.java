package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Produto;
import servlets.base.BaseProducts;


@WebServlet("/atualizar-produto")
public class AtualizarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		BaseProducts baseProducts = BaseProducts.getInstance();
		List<Produto> produtos = baseProducts.listarProdutos();

		out.println("<html><body><h2>");
		try {
			Produto p = produtos.get(Integer.valueOf(request.getParameter("id-produto")) - 1);
			p.setNome(request.getParameter("nome"));
			p.setPreco(new BigDecimal(request.getParameter("preco")));
			out.append("Produto atualizado com sucesso");
		} catch (Exception e) {
			out.append("Produto não encontrado");
		} finally {
			out.append("</h2></body></html>");
		}

	}

}
