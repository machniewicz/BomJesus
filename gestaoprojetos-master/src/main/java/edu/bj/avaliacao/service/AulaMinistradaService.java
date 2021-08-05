package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.AulaMinistrada;
import edu.bj.avaliacao.repository.AulaMinistradaRepository;

public class AulaMinistradaService {
	
	@Autowired
	private AulaMinistradaRepository repositorio;

	public AulaMinistrada create(AulaMinistrada aulaMinistrada) {
		return repositorio.save(aulaMinistrada);
	}

	public List<AulaMinistrada> findAll() {
		return repositorio.findAll();
	}

	public AulaMinistrada findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public AulaMinistrada update(AulaMinistrada aulaMinistrada) {
		AulaMinistrada entidade = repositorio.findById(aulaMinistrada.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		AulaMinistrada entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}


}
