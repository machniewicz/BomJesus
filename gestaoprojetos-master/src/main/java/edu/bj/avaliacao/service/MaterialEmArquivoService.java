package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.MaterialEmArquivo;
import edu.bj.avaliacao.repository.MaterialEmArquivoRepository;

public class MaterialEmArquivoService {
	
	@Autowired
	private MaterialEmArquivoRepository repositorio;

	public MaterialEmArquivo create(MaterialEmArquivo material) {
		return repositorio.save(material);
	}

	public List<MaterialEmArquivo> findAll() {
		return repositorio.findAll();
	}

	public MaterialEmArquivo findById(Long id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
	}

	public MaterialEmArquivo update(MaterialEmArquivo material) {
		MaterialEmArquivo entidade = repositorio.findById(material.getId())
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		return repositorio.save(entidade);
	}

	public void delete(Long id) {
		MaterialEmArquivo entidade = repositorio.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Nenhum registro para esse ID!"));
		repositorio.delete(entidade);

	}


}
