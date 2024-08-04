package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.modelo.Cidade;
import com.fourcatsdev.aula08.modelo.Regiao;
import com.fourcatsdev.aula08.service.CidadeService;
import com.fourcatsdev.aula08.service.RegiaoService;
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
import java.util.List;

@Controller
@RequestMapping("/regiao")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;

    @Autowired
    private CidadeService cidadeService;


    @GetMapping("/novo")
    public String novaRegiao(Model model){

        List<Cidade> cidades = cidadeService.listar();

        Regiao regiao = new Regiao();

        model.addAttribute("novaRegiao", regiao);
        model.addAttribute("cidades", cidades);

        return "/auth/user/publica-criar-nova-regiao";

    }


    @PostMapping("/gravar")
    public String gravarRegiao(@ModelAttribute("novaRegiao") @Valid Regiao regiao,
                               BindingResult erros, RedirectAttributes attributes, Model model){

        if(erros.hasErrors()){

            List<Cidade> cidades = cidadeService.listar();
            model.addAttribute("cidades", cidades);
            return "/auth/user/publica-criar-nova-regiao";

        }

        regiaoService.CriarRegiao(regiao);
        attributes.addFlashAttribute("mensagem", "Região salvo com sucesso!");

        return "redirect:/cidade/novo";

    }
/*
    @GetMapping("/listar")
    public String listarRegiao(Model model){

        List<Regiao> regioes = regiaoService.buscarTodosRegioes();
        model.addAttribute("listaRegioes",regioes);
        return "/auth/admin/admin-listar-regiao";


    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes, Model model){

        try{

            Regiao regiao = regiaoService.buscarRegiaoPorId(id);
            model.addAttribute("objetoRegiao", regiao);
            List<Cidade> cidades = cidadeService.listar();
            model.addAttribute("cidades", cidades);
            return "/auth/user/admin-alterar-regiao";


        } catch(RegiaoNotFoundException e){

            attributes.addFlashAttribute("mensagemErro", e.getMessage());

        }

         return "redirect:/regiao/listar";
    }

    @PostMapping("/editar/{id}")
    public String editarRegiao(@PathVariable("id") long id,
                                  @ModelAttribute("objetoRegiao") @Valid Regiao regiao,
                                  BindingResult erros, Model model) {
        if(erros.hasErrors()){
            regiao.setId(id);
            List<Cidade> cidades = cidadeService.listar();
            model.addAttribute("cidades",cidades);
            return "/auth/user/admin-alterar-regiao";

        }

        regiaoService.alterarRegiao(regiao);
        return "redirect:/regiao/listar";

    }


    @GetMapping("/apagar/{id}")
    public String apagarRegiao(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            regiaoService.apagarRegiao(id);
        } catch (RegiaoNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/regiao/listar";
    }

*/


}
