package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.Profissao;
import com.fourcatsdev.aula08.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/profissao")
public class ProfissaoController {

    @Autowired
    private ProfissaoService profissaoService;

    @GetMapping("/novo")
    public String novaProfissao(Model model){

        Profissao profissao = new Profissao();
        model.addAttribute("novaProfissao", profissao);
        return "/auth/user/publica-criar-profissao";

    }

    @PostMapping("/gravar")
    public String salvarProfissao(@ModelAttribute("novaProfissao") @Valid Profissao profissao,
                                  BindingResult erros, RedirectAttributes attributes){

        if(erros.hasErrors()){

            return "/auth/user/publica-criar-profissao";
        }

        profissaoService.salvarProfissao(profissao);
        attributes.addFlashAttribute("mensagem", "Profissão registrado com sucesso!");
        return "/auth/user/publica-index";

    }

}
