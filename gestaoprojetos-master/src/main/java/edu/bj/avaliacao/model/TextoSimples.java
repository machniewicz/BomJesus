package edu.bj.avaliacao.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TEXTO_SIMPLES")
public class TextoSimples extends AbstractModel<Long> {

	@Column(name = "titulo", length = 30)
	private String titulo;

	@Column(name = "texto_material", length = 150)
	private String texto_material;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto_material() {
		return texto_material;
	}

	public void setTexto_material(String texto_material) {
		this.texto_material = texto_material;
	}

}
