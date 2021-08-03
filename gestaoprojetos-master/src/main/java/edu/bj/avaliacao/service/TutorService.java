package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.Tutor;
import edu.bj.avaliacao.repository.TutorRepository;

public class TutorService {

	@Autowired
	private TutorRepository repositorio;

	public Tutor create(Tutor tutor) {
		return repositorio.save(tutor);
	}

	public List<Tutor> findAll() {
		return repositorio.findAll();
	}

	public Tutor findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public Tutor update(Tutor tutor) {
		Tutor entidade = repositorio.findById(tutor.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		Tutor entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}

}
