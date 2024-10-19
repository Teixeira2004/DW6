package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private Integer id;
	private List<Produto> produtos;

	public Cliente(String nome, Integer id) {
		super();
		this.nome = nome;
		this.id = id;
		this.produtos = new ArrayList<Produto>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return this.produtos;
	}
	
	
}
