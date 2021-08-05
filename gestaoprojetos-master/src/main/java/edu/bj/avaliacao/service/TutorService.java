package edu.bj.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bj.avaliacao.exception.ResouceNotFoundException;
import edu.bj.avaliacao.model.Tutor;
import edu.bj.avaliacao.repository.TutorRepository;

@Service
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
	
	// Verifica se Tutor tem alguma Disciplina vinculada
		public boolean tutorTemDisciplina(Long id) {
			if(findById(id).getDisciplina().equals(null)) {
				return false;
			}
			return true;
		}

}
