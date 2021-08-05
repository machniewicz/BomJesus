package edu.bj.avaliacao.model;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "AULA_MINISTRADA")
public class AulaMinistrada extends AbstractModel<Long> {

	@Column(name = "titulo", nullable = false, length = 30)
	private String titulo;

	@Column(name = "descricao", length = 100)
	private String descricao;

	@Column(name = "data")
	private Date data;

	@OneToOne
	@JoinColumn(name = "material_em_arquivo_id")
	private MaterialEmArquivo material_em_arquivo;

	@OneToOne
	@JoinColumn(name = "texto_simples_id")
	private TextoSimples texto_simples;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public MaterialEmArquivo getMaterial_em_arquivo() {
		return material_em_arquivo;
	}

	public void setMaterial_em_arquivo(MaterialEmArquivo material_em_arquivo) {
		this.material_em_arquivo = material_em_arquivo;
	}

	public TextoSimples getTexto_simples() {
		return texto_simples;
	}

	public void setTexto_simples(TextoSimples texto_simples) {
		this.texto_simples = texto_simples;
	}

}
