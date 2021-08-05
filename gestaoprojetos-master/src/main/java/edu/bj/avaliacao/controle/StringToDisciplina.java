package edu.bj.avaliacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.service.DisciplinaService;

@Component
public class StringToDisciplina implements Converter<String, Disciplina> {

	@Autowired
	private DisciplinaService service;

	@Override
	public Disciplina convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}

}
