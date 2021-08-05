package edu.bj.avaliacao.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TUTOR")
public class Tutor extends AbstractModel<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "codigo_funcionario", nullable = false)
	private Integer codigo_funcionario;

	@Column(name = "senha", nullable = false, length = 50)
	private String senha;

	@OneToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodigo_funcionario() {
		return codigo_funcionario;
	}

	public void setCodigo_funcionario(Integer codigo_funcionario) {
		this.codigo_funcionario = codigo_funcionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
