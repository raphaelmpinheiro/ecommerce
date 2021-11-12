package org.serratec.ecomerce.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity//TODO: Verificar os relacionamentos e Mapeamentos de Colunas
public class Pedido {
		
	public Pedido(Produto produto, Cliente cliente) {
		this.produtos = new ArrayList<Produto>();
		this.produtos.add(produto);		
		this.cliente = cliente;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime dataPedido;
	
	private BigDecimal valorFinal;
	
	//Quantidade de produtos
	public int getTotalProdutos() {
		return produtos.size() + 1;
	}
	
	public void setProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	private LocalDateTime dataEnvio;
	
	private LocalDateTime dataEntrega;
	
	@OneToMany
	//1 pedido vai ter muitos produtos
	//Ter uma classe intermediária entre Produto e pedido.
	private List<Produto> produtos;
	
//	//Relacionamennto one to one
    private Cliente cliente;

	public BigDecimal getTotalValor() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Produto produto: this.produtos) {				
			valorTotal = valorTotal.add(produto.getValorUnitario()); 			
		}
		return valorTotal;
	}
	
}
