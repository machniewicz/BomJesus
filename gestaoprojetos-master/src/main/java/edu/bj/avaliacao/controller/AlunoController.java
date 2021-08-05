package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bj.avaliacao.model.Aluno;
import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.service.AlunoService;
import edu.bj.avaliacao.service.DisciplinaService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/aluno/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos", alunoService.findAll());
		return "/aluno/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Aluno aluno, RedirectAttributes att) {
		alunoService.create(aluno);
		att.addFlashAttribute("success", "Aluno cadastrado com sucesso!");
		return "redirect:/alunos/cadastrar";
	}

	@ModelAttribute("disciplinas")
	public List<Disciplina> listarDisciplinas() {
		return disciplinaService.findAll();
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("aluno", alunoService.findById(id));
		return "/aluno/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Aluno aluno, RedirectAttributes att) {
		alunoService.update(aluno);
		att.addFlashAttribute("success", "Aluno editado com sucesso!");
		return "redirect:/alunos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		if (alunoService.alunoTemDisciplina(id)) {
			model.addAttribute("fail", "Aluno não removido. Tem disciplina(s) vinculado(s).");
		} else {
			alunoService.delete(id);
			model.addAttribute("success", "Aluno excluído com sucesso.");
		}
		return listar(model);
	}
}