package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.repository.DisciplinaRepository;

public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repositorio;

	public Disciplina create(Disciplina disciplina) {
		return repositorio.save(disciplina);
	}

	public List<Disciplina> findAll() {
		return repositorio.findAll();
	}

	public Disciplina findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public Disciplina update(Disciplina disciplina) {
		Disciplina entidade = repositorio.findById(disciplina.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		Disciplina entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}


}
