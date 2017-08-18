package com.crud.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.financeiro.model.Entidade;
import com.crud.financeiro.respository.Entidades;
import com.crud.financeiro.service.EntidadesService;

@Controller
@RequestMapping("/entidades")
public class EntidadesController {

	private static final String INDEX = "entidade/CadastrarEntidade";
	
	@Autowired
	private Entidades entidades;
	
	@Autowired
	private EntidadesService entidadesService;

	@RequestMapping(value = "/novo")
	public String novo(Entidade entidade) {
		return INDEX;
	}

	@RequestMapping(value = "/novo" , method = RequestMethod.POST)
	public String salvar(@Valid Entidade entidade, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()){
			System.out.println("Teve algum erro! " + result.getAllErrors());
			
			//TODO: mostrar mensagem de erro
			return novo(entidade);
		}
		
		if (!StringUtils.isEmpty(entidade.getCodigo())) {
			attributes.addFlashAttribute("mensagem", "Entidade alterada com sucesso");
		}else{
			attributes.addFlashAttribute("mensagem", "Entidade salva com sucesso");
		}		
		
		
		entidadesService.salvar(entidade);	
		
		return "redirect:/entidades/novo";
	}
	
	@RequestMapping //method GET pois é default
	public ModelAndView pesquisar(Entidade entidade) {
		ModelAndView mv = new ModelAndView("entidade/PesquisarEntidade");
        mv.addObject("entidades", entidades.porNome(entidade.getNome()));
        return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Entidade entidade) {
		ModelAndView mv = new ModelAndView(INDEX);
		mv.addObject(entidade);
		return mv;
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable("codigo") Long codigo) {
		entidadesService.remover(codigo);
		return "redirect:/entidades";
	}
	
}
