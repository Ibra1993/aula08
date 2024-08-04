package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.Delegacia;
import com.fourcatsdev.aula08.service.DelegaciaService;
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
@RequestMapping("/delegacia")
public class DelegaciaController {

    @Autowired
    private DelegaciaService delegaciaService;


    @GetMapping("/novo")
    public String novaDelegacia(Model model){

        Delegacia delegacia = new Delegacia();
        model.addAttribute("novaDelegacia", delegacia);
        return "/auth/user/publica-criar-delegacia";
    }

    @PostMapping("/gravar")
    public String salvarDelegacia(@ModelAttribute("novaDelegacia") @Valid Delegacia delegacia,
                                  BindingResult erros, RedirectAttributes attributes){

        if(erros.hasErrors()){
            return "/auth/user/publica-criar-delegacia";
        }

        delegaciaService.salvarDelegacia(delegacia);
        attributes.addFlashAttribute("mensagem", "Delegacia registrada com sucesso!");
       return "/auth/user/publica-index";

    }
}
