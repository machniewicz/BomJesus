package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.TextoSimples;
import edu.bj.avaliacao.repository.TextoSimplesRepository;

public class TextoSimplesService {
	
	@Autowired
	private TextoSimplesRepository repositorio;

	public TextoSimples create(TextoSimples textoSimples) {
		return repositorio.save(textoSimples);
	}

	public List<TextoSimples> findAll() {
		return repositorio.findAll();
	}

	public TextoSimples findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public TextoSimples update(TextoSimples textoSimples) {
		TextoSimples entidade = repositorio.findById(textoSimples.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		TextoSimples entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}


}
