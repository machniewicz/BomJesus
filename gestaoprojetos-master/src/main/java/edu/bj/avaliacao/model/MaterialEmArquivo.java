package edu.bj.avaliacao.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "MATERIAL_EM_ARQUIVO")
public class MaterialEmArquivo extends AbstractModel<Long> {

	@Column(name = "titulo", length = 30)
	private String titulo;

	@Column(name = "arquivo", length = 50)
	private String arquivo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

}
