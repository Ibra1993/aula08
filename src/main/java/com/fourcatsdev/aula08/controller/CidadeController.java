package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.excecao.CidadeNotFoundException;
import com.fourcatsdev.aula08.modelo.Bairro;
import com.fourcatsdev.aula08.modelo.Cidade;
import com.fourcatsdev.aula08.modelo.Regiao;
import com.fourcatsdev.aula08.service.BairroService;
import com.fourcatsdev.aula08.service.CidadeService;
import com.fourcatsdev.aula08.service.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private RegiaoService regiaoService;

    @Autowired
    private BairroService bairroService;

    @GetMapping("/novo")
    public String novaCidade(Model model){

        List<Bairro> bairros = bairroService.buscarTodosBairros();
        List<Regiao> regioes = regiaoService.buscarTodosRegioes();

        Cidade cidade = new Cidade();
        model.addAttribute("novoCidade", cidade);
        model.addAttribute("bairros", bairros);
        model.addAttribute("regioes", regioes);

        return "/auth/user/publica-criar-cidade";

    }

    @PostMapping("/gravar")
    public String gravarCidade(@ModelAttribute("novoCidade") @Valid Cidade cidade,
                               BindingResult erros, RedirectAttributes attributes, Model model){
        if(erros.hasErrors()){
            List<Bairro> bairros = bairroService.buscarTodosBairros();
            model.addAttribute("bairros", bairros);
            return "/auth/user/publica-criar-cidade";
        }

        cidadeService.gravar(cidade);
        attributes.addFlashAttribute("mensagem", "Cidade salvo com sucesso!");
        //return "/publica-index";
        return "redirect:/crime/listar";


    }


    @GetMapping("/listar")
    public String listarCidades(Model model){

        List<Cidade> cidades = cidadeService.listar();
        model.addAttribute("listaCidades",cidades);

        return "/auth/admin/admin-listar-cidade";

    }

    @GetMapping("/apagar/{id}")
    public String apagarCidadeo(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            cidadeService.apagarCidade(id);
        } catch (CidadeNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/cidade/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes, Model model){

        try{

           Cidade cidade = cidadeService.buscarCidadePorId(id);
            model.addAttribute("objetoCidade", cidade);

            List<Bairro> bairros = bairroService.buscarTodosBairros();

            model.addAttribute("bairros", bairros);
            return "/auth/user/admin-alterar-cidade";


        } catch(CidadeNotFoundException e){

            attributes.addFlashAttribute("mensagemErro", e.getMessage());

        }

        return "redirect:/cidade/listar";
    }


    @PostMapping("/editar/{id}")
    public String editarCidade(@PathVariable("id") long id,
                               @ModelAttribute("objetoCidade") @Valid Cidade cidade,
                               BindingResult erros, Model model) {
        if(erros.hasErrors()){
            cidade.setId(id);
            List<Bairro> bairros = bairroService.buscarTodosBairros();
            model.addAttribute("bairros", bairros);
            return "/auth/user/admin-alterar-cidade";

        }

        cidadeService.alterarCidade(cidade);
        return "redirect:/cidade/listar";

    }



}
