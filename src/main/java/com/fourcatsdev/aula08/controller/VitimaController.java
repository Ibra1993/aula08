package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.excecao.CrimeNotFoundException;
import com.fourcatsdev.aula08.excecao.VitimaNotFoundException;
import com.fourcatsdev.aula08.modelo.*;
import com.fourcatsdev.aula08.service.EstadoCivilService;
import com.fourcatsdev.aula08.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vitima")
public class VitimaController {
    @Autowired
    private VitimaService vitimaService;

    @Autowired
    private ProfissaoService profissaoService;

    @Autowired
    private CrimeService crimeService;

    @Autowired
    private NaturalidadeService naturalidadeService;

    @Autowired
    private EstadoCivilService estadoCivilService;

    @Autowired
    private GeneroService generoService;



    @GetMapping("/novo/{id}")
    public String novaVitima(@PathVariable("id") long id, Model model){

        String pagina = "";


        try{

            Crime crime = crimeService.buscarCrimePorId(id);
            if(crime.getVitima()==null){

                Vitima vitima = new Vitima();
                vitima.setCrime(crime);

                List<Profissao> profissoes = profissaoService.listar();
                List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
                List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
                List<Genero>generos = generoService.listarGenero();


                model.addAttribute("naturalidades", naturalidades);
                model.addAttribute("estadosCivis", estadosCivis);
                model.addAttribute("generos", generos);


                model.addAttribute("profissoes", profissoes);
                model.addAttribute("novaVitima", vitima);

                pagina = "/auth/user/publica-criar-vitima";

            }else{
                List<Profissao> profissoes = profissaoService.listar();

                List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
                List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
                List<Genero>generos = generoService.listarGenero();

                model.addAttribute("profissoes", profissoes);
                model.addAttribute("novaVitima", crime.getVitima());

                model.addAttribute("naturalidades", naturalidades);
                model.addAttribute("estadosCivis", estadosCivis);
                model.addAttribute("generos", generos);

                pagina = "/auth/user/user-alterar-vitima";
            }

        } catch (CrimeNotFoundException e) {
            e.printStackTrace();
        }

        return pagina;

        /*
        List<Profissao> profissoes = profissaoService.listar();

        Vitima vitima = new Vitima();
        model.addAttribute("novaVitima", vitima);
        model.addAttribute("profissoes", profissoes);
        return "/publica-criar-vitima";
        */


    }

    @PostMapping("/gravar/{idCrime}")
    public String gravarVitima(@PathVariable("idCrime") long idCrime,
                               @ModelAttribute("novaVitima") @Valid Vitima vitima,
                               BindingResult erros, RedirectAttributes attributes,
                               Model model){

        try{

            Crime crime = crimeService.buscarCrimePorId(idCrime);
            vitima.setCrime(crime);

        } catch (CrimeNotFoundException e) {
           e.printStackTrace();
        }

   finally {

            if(erros.hasErrors()){

                List<Profissao> profissoes = profissaoService.listar();
                model.addAttribute("profissoes", profissoes);
                return "/auth/user/publica-criar-vitima";

            }

            vitimaService.salvar(vitima);
            attributes.addFlashAttribute("mensagem", "Vitima registrado com sucesso!");

            //return  "redirect:/vitima/listar";
            return  "redirect:/crime/listar";

        }
            /*
        if(erros.hasErrors()){

            List<Profissao> profissoes = profissaoService.listar();
            model.addAttribute("profissoes", profissoes);
            return "/publica-criar-vitima";

        }

        vitimaService.salvar(vitima);
        attributes.addFlashAttribute("mensagem", "Vitima registrado com sucesso!");
        //return  "redirect:/crime/novo";
        return  "redirect:/vitima/listar";
        */


    }

    @GetMapping("/listar")
    public String listarVitimas(Model model){

        List<Vitima> vitimas = vitimaService.listar();
        model.addAttribute("listarVitimas", vitimas);
        return "/auth/admin/admin-listar-vitimas";

    }

    @PostMapping("/buscar")
    public String buscarVitima(Model model, @Param("numeroDoDocumento") String numeroDoDocumento) {

        if(numeroDoDocumento == null){

            return "redirect:/vitima/listar";
        }

        List<Vitima> vitimas = vitimaService.buscarPorNumeroDeDocumento(numeroDoDocumento);
        model.addAttribute("listarVitimas", vitimas);
        return "/auth/admin/admin-listar-vitimas";
    }

    @GetMapping("/apagar/{id}")
    public String apagarVitima(@PathVariable("id") long id, RedirectAttributes attributes){


        try{
            vitimaService.apagarVitima(id);
        }catch (VitimaNotFoundException e){

            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }

        return "redirect:/vitima/listar";
    }

    @GetMapping("editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes,
                             Model model){
        try {
            Vitima vitima = vitimaService.buscarVitimaPorId(id);
            model.addAttribute("objetoVitima", vitima);

            List<Profissao> profissoes = profissaoService.listar();
            model.addAttribute("profissoes", profissoes);

            List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
            List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
            List<Genero>generos = generoService.listarGenero();
            model.addAttribute("naturalidades", naturalidades);
            model.addAttribute("estadosCivis", estadosCivis);
            model.addAttribute("generos", generos);


            return "/auth/user/user-alterar-vitima";

        } catch (VitimaNotFoundException e){

            attributes.addFlashAttribute("mensagemErro", e.getMessage());


        }
        return "redirect:/vitima/listar";
        //return "/";

    }

    @PostMapping("/editar/{id}")
    public String editarVitima(@PathVariable("id") long id,
                               @ModelAttribute("objetoVitima") @Valid Vitima vitima, BindingResult erros, Model model){

        if(erros.hasErrors()){
            vitima.setId(id);
            List<Profissao> profissoes = profissaoService.listar();
            model.addAttribute("profissoes", profissoes);

            List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
            List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
            List<Genero>generos = generoService.listarGenero();
            model.addAttribute("naturalidades", naturalidades);
            model.addAttribute("estadosCivis", estadosCivis);
            model.addAttribute("generos", generos);

            return "/auth/user/user-alterar-vitima";
        }

        vitimaService.alterarVitimaa(vitima);
        return "redirect:/vitima/listar";
    }



    @PostMapping("/alterar-vitima/{idCrime}/{idVitima}")
    public String alterarVitima(@PathVariable("idCrime") long idCrime,
                                @PathVariable("idVitima") long idVitima,
                                @ModelAttribute("novaVitima") @Valid Vitima vitima,
                                BindingResult result,
                                RedirectAttributes attributes, Model model){



        try{
            Crime crime = crimeService.buscarCrimePorId(idCrime);
            vitima.setCrime(crime);
            vitima.setId(idVitima);

        } catch (CrimeNotFoundException e) {
            e.printStackTrace();
        }

        if(result.hasErrors()){

            List<Profissao> profissoes = profissaoService.listar();
            model.addAttribute("profissoes", profissoes);

            List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
            List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
            List<Genero>generos = generoService.listarGenero();
            model.addAttribute("naturalidades", naturalidades);
            model.addAttribute("estadosCivis", estadosCivis);
            model.addAttribute("generos", generos);

            return "/auth/user/user-alterar-vitima";


        }

        List<Profissao> profissoes = profissaoService.listar();
        model.addAttribute("profissoes", profissoes);

        List<Naturalidade> naturalidades = naturalidadeService.listarNaturalidade();
        List<EstadoCivil> estadosCivis = estadoCivilService.listarEstadoCivil();
        List<Genero>generos = generoService.listarGenero();
        model.addAttribute("naturalidades", naturalidades);
        model.addAttribute("estadosCivis", estadosCivis);
        model.addAttribute("generos", generos);


        vitimaService.salvar(vitima);
        attributes.addFlashAttribute("mensagem", "Vitima alterado com sucesso");
        return "redirect:/vitima/novo/"+idCrime;
    }


}







