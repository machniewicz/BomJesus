package edu.bj.avaliacao.model;

import java.util.Date;

import javax.persistence.*;



@SuppressWarnings("serial")
@Entity
@Table(name = "DISCIPLINA")
public class Disciplina extends AbstractModel<Long>{

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "dta_inicio", nullable = false)
	private Date dta_inicio;
	
	@Column(name = "dta_fim", nullable = false)
	private Date dta_fim;
	
	@Column(name = "situacao", nullable = false)
	private Boolean situacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nota_id")
	private Nota nota;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDta_inicio() {
		return dta_inicio;
	}

	public void setDta_inicio(Date dta_inicio) {
		this.dta_inicio = dta_inicio;
	}

	public Date getDta_fim() {
		return dta_fim;
	}

	public void setDta_fim(Date dta_fim) {
		this.dta_fim = dta_fim;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
