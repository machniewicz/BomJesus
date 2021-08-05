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
@RequestMapping("/tutores")
public class TutorController {
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@ModelAttribute("disciplinas")
	public List<Disciplina> listarDisciplinas() {
		return disciplinaService.findAll();
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Tutor tutor) {
		return "/tutor/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("tutores", tutorService.findAll());
		return "/tutor/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Tutor tutor, RedirectAttributes att) {
		tutorService.create(tutor);
		att.addFlashAttribute("success", "Tutor cadastrado com sucesso!");
		return "redirect:/tutores/cadastrar";
	}


	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("tutor", tutorService.findById(id));
		return "/tutor/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Tutor tutor, RedirectAttributes att) {
		tutorService.update(tutor);
		att.addFlashAttribute("success", "Tutor editado com sucesso!");
		return "redirect:/tutores/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		if (tutorService.tutorTemDisciplina(id)) {
			model.addAttribute("fail", "Tutor não removido. Tem disciplina(s) vinculado(s).");
		} else {
			tutorService.delete(id);
			model.addAttribute("success", "Tutor excluído com sucesso.");
		}
		return listar(model);
	}
}
