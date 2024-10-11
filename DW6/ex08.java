package com.exercicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ex08
 */
@WebServlet("/ex08")
public class ex08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> produtos = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ex08() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>Cadastro de Produtos</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Cadastro de Produto</h1>");
		response.getWriter().println("<form action='ex08' method='POST'>");
		response.getWriter().println("Nome: <input type='text' name='nome' required><br>");
		response.getWriter().println("Preço: <input type='text' name='preco' required><br>");
		response.getWriter().println("<input type='submit' value='Cadastrar Produto'>");
		response.getWriter().println("</form>");

		response.getWriter().println("<h2>Produtos Cadastrados:</h2>");
		response.getWriter().println("<ul>");

		synchronized (produtos) {
			for (Product produto : produtos) {
				response.getWriter().println("<li>" + produto.getNome() + " - R$ " + produto.getPreco() + "</li>");
			}
		}

		response.getWriter().println("</ul>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String precoStr = request.getParameter("preco");

		double preco = Double.parseDouble(precoStr);

		if (nome != null && !nome.isEmpty()) {
			synchronized (produtos) {
				produtos.add(new Product(nome, preco));
			}
		}

		doGet(request, response);
	}

	public class Product {
		private String nome;
		private double preco;

		public Product(String nome, double preco) {
			this.nome = nome;
			this.preco = preco;
		}

		public String getNome() {
			return nome;
		}

		public double getPreco() {
			return preco;
		}
	}
}
