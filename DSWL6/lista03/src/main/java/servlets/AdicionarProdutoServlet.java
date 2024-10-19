package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Produto;
import servlets.base.BaseProducts;


@WebServlet("/adicionar-produto")
public class AdicionarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseProducts baseProducts = BaseProducts.getInstance();
		List<Produto> produtos = baseProducts.listarProdutos();
		
		produtos.add(new Produto(request.getParameter("nome"), new BigDecimal(request.getParameter("preco")), (produtos.size() + 1)));
		
		response.getWriter().println("Produto adicionado com sucesso!");
	} 

}
