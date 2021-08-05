package edu.bj.avaliacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.bj.avaliacao.model.Aluno;
import edu.bj.avaliacao.service.AlunoService;

@Component
public class StringToAluno implements Converter<String, Aluno> {

	@Autowired
	private AlunoService service;

	@Override
	public Aluno convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}

}
