package com.crud.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.financeiro.model.Situacao;
import com.crud.financeiro.model.Tipo;
import com.crud.financeiro.model.Titulo;
import com.crud.financeiro.respository.Entidades;
import com.crud.financeiro.respository.TiposDePagamentos;
import com.crud.financeiro.respository.Titulos;
import com.crud.financeiro.service.TitulosService;

@Controller
@RequestMapping("/titulos")
public class TitulosController {

	private static final String INDEX = "titulo/CadastrarTitulo";
	
	@Autowired
	private Entidades entidades	;
	
	@Autowired
	private Titulos titulos	;
	
	@Autowired
	private TiposDePagamentos tiposDePagamentos	;
	
	@Autowired
	private TitulosService titulosService;
	
	@RequestMapping(value = "/novo")
	public ModelAndView novo(Titulo titulo) {
		ModelAndView mv = new ModelAndView(INDEX);
		mv.addObject("listaDeEntidades", entidades.findAll());
		mv.addObject("todosOsTipos", Tipo.values());
		mv.addObject("todasAsSituacoes", Situacao.values());
		mv.addObject("tiposDePagamentos", tiposDePagamentos.findAll());
		return mv;
	}
	
    @RequestMapping(value = "/novo" , method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Titulo titulo, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()){
			System.out.println("Teve algum erro! " + result.getAllErrors());
			
			//TODO: mostrar mensagem de erro
			return novo(titulo);
		}
		
		if (!StringUtils.isEmpty(titulo.getCodigo())) {
			attributes.addFlashAttribute("mensagem", "Titulo alterado com sucesso");
		}else{
			attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso");
		}
    	
		titulosService.salvar(titulo);
		
		return new ModelAndView("redirect:/titulos/novo");
	}
	
    @RequestMapping
	public ModelAndView pesquisar(Titulo titulo) {
		ModelAndView mv = new ModelAndView("titulo/PesquisarTitulo");
		
		mv.addObject("listaEntidades", entidades.findAll());
		
		String descricao = titulo.getDescricao() == null ? "%" : titulo.getDescricao();
		
        mv.addObject("titulos", titulos.filtrados(descricao, titulo.getEntidade()));
        
        mv.addObject("tiposDePagamentos", tiposDePagamentos.findAll());
        
       // mv.addObject("titulos", titulos.filtrados(descricao, titulo.getTipoDePagamento()));
        
        return mv;
	}
}
