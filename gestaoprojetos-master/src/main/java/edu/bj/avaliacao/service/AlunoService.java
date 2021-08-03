package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.Aluno;
import edu.bj.avaliacao.repository.AlunoRepository;

public class AlunoService {

	@Autowired
	private AlunoRepository repositorio;

	public Aluno create(Aluno aluno) {
		return repositorio.save(aluno);
	}

	public List<Aluno> findAll() {
		return repositorio.findAll();
	}

	public Aluno findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public Aluno update(Aluno aluno) {
		Aluno entidade = repositorio.findById(aluno.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		Aluno entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}

}
