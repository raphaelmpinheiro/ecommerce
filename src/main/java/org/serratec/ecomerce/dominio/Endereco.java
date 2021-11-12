package org.serratec.ecomerce.dominio;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
	
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	
	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String pais;
	@NotBlank
	private String CEP;
}
