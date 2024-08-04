package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.AndamentoOcorrencia;
import com.fourcatsdev.aula08.service.AndamentoOcorrenciaService;
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
@RequestMapping("/andamento")
public class AndamentoOcorrenciaController {

    @Autowired
    private AndamentoOcorrenciaService andamentoOcorrenciaService;

    @GetMapping("/novo")
    public String novoAndamento(Model model){

        AndamentoOcorrencia andamento = new AndamentoOcorrencia();
        model.addAttribute("novoAndamento", andamento);
        return "/auth/user/publica-criar-andamento";
    }


    @PostMapping("/gravar")
    public String salvarAndamento(@ModelAttribute("novoAndamento") @Valid AndamentoOcorrencia andamento,
                                  BindingResult erros, RedirectAttributes attributes){

        if (erros.hasErrors()){

            return "/auth/user/publica-criar-andamento";
        }

        andamentoOcorrenciaService.salvar(andamento);
        attributes.addFlashAttribute("mensagem", "Andamento registrado com sucesso!");
        return "/auth/user/publica-index";
    }
}
