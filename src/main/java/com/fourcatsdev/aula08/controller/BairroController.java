package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.Bairro;
import com.fourcatsdev.aula08.service.BairroService;
import com.fourcatsdev.aula08.service.CidadeService;
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
@RequestMapping("/bairro")
public class BairroController {


    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private BairroService bairroService;


    @GetMapping("/novo")
    public String novoBairro(Model model){

        Bairro bairro = new Bairro();
        model.addAttribute("novoBairro", bairro);

        return "/auth/user/publica-criar-bairro";

    }

    @PostMapping("/gravar")
    public String gravarBairro(@ModelAttribute("novoBairro") @Valid Bairro bairro,
                               BindingResult erros, RedirectAttributes attributes){


        if(erros.hasErrors()){

            return "/auth/user/publica-criar-bairro";
        }

        bairroService.criarBairro(bairro);
        attributes.addFlashAttribute("mensagem", "Bairro salvo com sucesso!");

        return "/auth/user/publica-index";

    }


}
