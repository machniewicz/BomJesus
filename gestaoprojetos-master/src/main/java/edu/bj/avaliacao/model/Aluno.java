package edu.bj.avaliacao.model;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ALUNO")
public class Aluno extends AbstractModel<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "matricula", nullable = false, length = 10)
	private String matricula;

	@Column(name = "senha", nullable = false, length = 15)
	private String senha;

	@OneToMany(mappedBy = "aluno")
	private List<Disciplina> disciplinas;

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
