package com.example.network.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Produto {
	
	@Id
	@Indexed(unique=true)
	private Long id;

    @NotBlank
    @Size(max=30)
    private String nome;
    
    private Double preco;
    
    private int quantidade;
    
    @NotBlank
    @Size(max=30)
    private String marca;
    
    public Produto() {
        super();
    }


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + ", marca="
				+ marca + "]";
	}

	
    
    
}
