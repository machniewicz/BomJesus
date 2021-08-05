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

import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.model.Tutor;
import edu.bj.avaliacao.service.DisciplinaService;
import edu.bj.avaliacao.service.TutorService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private TutorService tutorService;
	
	@ModelAttribute("tutores")
	public List<Tutor> listarTutores() {
		return tutorService.findAll();
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Disciplina disciplina) {
		return "/disciplina/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("disciplinas", disciplinaService.findAll());
		return "/disciplina/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Disciplina disciplina, RedirectAttributes att) {
		disciplinaService.create(disciplina);
		att.addFlashAttribute("success", "Disciplina cadastrada com sucesso!");
		return "redirect:/disciplinas/cadastrar";
	}


	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("disciplina", disciplinaService.findById(id));
		return "/disciplina/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Disciplina disciplina, RedirectAttributes att) {
		disciplinaService.update(disciplina);
		att.addFlashAttribute("success", "Disciplina editado com sucesso!");
		return "redirect:/disciplinas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) { 
		disciplinaService.delete(id);
		model.addAttribute("success", "Disciplina excluída com sucesso.");
		return listar(model);
	}

}
