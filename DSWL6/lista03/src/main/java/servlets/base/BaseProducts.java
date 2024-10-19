package servlets.base;

import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class BaseProducts {
	private static BaseProducts instanciaUnica = null;
	private List<Produto> produtos;
	
	public BaseProducts() {
		produtos = new ArrayList<Produto>();
	}
	
	public static BaseProducts getInstance() {
		if(instanciaUnica == null) {
			instanciaUnica = new BaseProducts();
		}
		return instanciaUnica;
	}
	
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public List<Produto> listarProdutos(){
		return produtos;
	}
}
