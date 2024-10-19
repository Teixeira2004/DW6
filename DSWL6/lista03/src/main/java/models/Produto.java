package models;

import java.math.BigDecimal;

public class Produto {
	private String nome;
	private BigDecimal preco;
	private Integer id;
	
	public Produto(String nome, BigDecimal preco, Integer id) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
