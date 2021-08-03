package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.Nota;
import edu.bj.avaliacao.repository.NotaRepository;

public class NotaService {
	
	@Autowired
	private NotaRepository repositorio;

	public Nota create(Nota nota) {
		return repositorio.save(nota);
	}

	public List<Nota> findAll() {
		return repositorio.findAll();
	}

	public Nota findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public Nota update(Nota nota) {
		Nota entidade = repositorio.findById(nota.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		Nota entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}


}
