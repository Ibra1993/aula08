package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.excecao.CrimeNotFoundException;
import com.fourcatsdev.aula08.modelo.*;
import com.fourcatsdev.aula08.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/crime")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @Autowired
    private BairroService bairroService;

    @Autowired
    private DelegaciaService delegaciaService;

    @Autowired
    private AndamentoOcorrenciaService andamentoOcorrenciaService;

    @Autowired
    private TipoDeCrimeService tipoDeCrimeService;

    @Autowired
    private GeneroService generoService;


    @Autowired
    private TipoDeLocalService tipoDeLocalService;



    @GetMapping("/novo")
    public String novoCrime(Model model){

        Crime crime = new Crime();
        List<Bairro> bairros = bairroService.buscarTodosBairros();
        List<Delegacia> delegacias = delegaciaService.listarDelegacias();
        List<AndamentoOcorrencia> andamentos = andamentoOcorrenciaService.listarEstado();
        List<TipoDeCrime> tipoDeCrimes = tipoDeCrimeService.listarTiposDeCrime();
        List<Genero> generos = generoService.listarGenero();
        List<TipoDeLocal> tiposDeLocal = tipoDeLocalService.listarTiposDeLocal();



        model.addAttribute("novoCrime", crime);
        model.addAttribute("bairros", bairros);
        model.addAttribute("delegacias", delegacias);
        model.addAttribute("andamentos", andamentos);

        model.addAttribute("tipoDeCrimes", tipoDeCrimes);
        model.addAttribute("generos", generos);
        model.addAttribute("tiposDeLocal", tiposDeLocal);


        return "/auth/user/publica-criar-crime";

    }



    @PostMapping("/gravar")
    public String gravarCrime(@ModelAttribute("novoCrime") @Valid Crime crime,
                              BindingResult erros, RedirectAttributes attributes, Model model){

        if(erros.hasErrors()){

            List<Bairro> bairros = bairroService.buscarTodosBairros();
            List<Delegacia> delegacias = delegaciaService.listarDelegacias();
            List<AndamentoOcorrencia> andamentos = andamentoOcorrenciaService.listarEstado();

            model.addAttribute("bairros", bairros);
            return "/auth/user/publica-criar-crime";

        }



        crimeService.criarCrime(crime);
        attributes.addFlashAttribute("mensagem", "Crime registrado com sucesso!");
        return  "redirect:/cidade/novo";

    }

    @GetMapping("/listar")
    public String listarCrimes(Model model){


        List<Crime> crimes = crimeService.buscarTodosCrimes();
        model.addAttribute("listarCrimes", crimes);
        return "/auth/admin/admin-listar-crime";

    }

    @GetMapping("/apagar/{id}")
    public String apagarCrime(@PathVariable("id") long id, RedirectAttributes attributes){

        try{
            crimeService.apagarCrime(id);

        }catch (CrimeNotFoundException e){
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }

        return "redirect:/crime/listar";

    }


    @GetMapping("editar/{id}")
    public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes,
                             Model model){

        try{

            Crime crime = crimeService.buscarCrimePorId(id);
            model.addAttribute("objetoCrime", crime);

            List<Bairro> bairros = bairroService.buscarTodosBairros();
            model.addAttribute("bairros", bairros);

            List<Delegacia> delegacias = delegaciaService.listarDelegacias();
            model.addAttribute("delegacias", delegacias);

            List<AndamentoOcorrencia> andamentos = andamentoOcorrenciaService.listarEstado();
            model.addAttribute("andamentos", andamentos);


            List<TipoDeCrime> tipoDeCrimes = tipoDeCrimeService.listarTiposDeCrime();
            List<Genero> generos = generoService.listarGenero();
            List<TipoDeLocal> tiposDeLocal = tipoDeLocalService.listarTiposDeLocal();

            model.addAttribute("tipoDeCrimes", tipoDeCrimes);
            model.addAttribute("generos", generos);
            model.addAttribute("tiposDeLocal", tiposDeLocal);


            return "/auth/user/user-alterar-crime";

        } catch (CrimeNotFoundException e){

        attributes.addFlashAttribute("mensagemErro", e.getMessage());
    }

        return "redirect:/crime/listar";
 }


    @PostMapping("/editar/{id}")
    public String editarCrime(@PathVariable("id") long id,
                              @ModelAttribute("objetoCrime") @Valid Crime crime,
                              BindingResult erros){

        if(erros.hasErrors()){

            crime.setId(id);

            return "/auth/user/user-alterar-crime";

        }

        crimeService.alterarCrime(crime);
        return "redirect:/crime/listar";

    }


    @GetMapping("/listarFurtos")
    public  String listarTodosOsFurtos(Model model){

        List<Crime> furtos = crimeService.listarTodosFurto();
        model.addAttribute("furtos", furtos);

        return "/auth/admin/admin-listar-furtos";

    }

    @GetMapping("/listarFurtosQualificados")
    public  String listarTodosOsFurtosqualificados(Model model){

        List<Crime> furtosqualificados = crimeService.listarTodosFurtoQualificado();
        model.addAttribute("furtosQualificados", furtosqualificados);

        return "/auth/admin/admin-listar-furtosQualificados";

    }


    @GetMapping("/listarFurtosDeUso")
    public  String listarTodosOsFurtosDeUso(Model model){

        List<Crime> furtosDeUso = crimeService.listarTodosFurtoDeUso();
        model.addAttribute("furtosDeUso", furtosDeUso);

        return "/auth/admin/admin-listar-furtosDeUso";

    }

    @GetMapping("/listarRoubos")
    public  String listarTodosOsRoubos(Model model){

        List<Crime> roubos = crimeService.listarTodosRoubo();
        model.addAttribute("roubos", roubos);

        return "/auth/admin/admin-listar-roubos";

    }

    @GetMapping("/listarAgressoes")
    public  String listarTodasAgressoes(Model model){

        List<Crime> agressoes = crimeService.listarTodosAgressao();
        model.addAttribute("agressoes", agressoes);

        return "/auth/admin/admin-listar-agressoes";

    }

    @GetMapping("/listarAmeacas")
    public  String listarTodasAmeacas(Model model){

        List<Crime> ameacas = crimeService.listarTodosAmeaca();
        model.addAttribute("ameacas", ameacas);

        return "/auth/admin/admin-listar-ameacas";

    }


    @GetMapping("/extorsoes")
    public  String listarTodasExtorsoes(Model model){

        List<Crime> extorsoes = crimeService.listarTodosExtorsao();
        model.addAttribute("extorsoes", extorsoes);

        return "/auth/admin/admin-listar-extorsoes";

    }


    @GetMapping("/violacaoDomicilio")
    public  String listarTodasViolaDomicilio(Model model){

        List<Crime> violadomicilio = crimeService.listarTodosViolacaoDomicilio();
        model.addAttribute("violadomicilio", violadomicilio);

        return "/auth/admin/admin-listar-violadomicilio";

    }

/*
    @PostMapping("/buscar")
    public String buscarAndamento(Model model, @Param("numeroDoDocumento") String numeroDoDocumento) throws CrimeNotFoundException {

        if(numeroDoDocumento == null){

            return "redirect:/paginaBusca";
        }

        List<Crime> crime = crimeService.andamento(numeroDoDocumento);

        model.addAttribute("listarCrime ", crime);
        return "/admin-listar-andamento";
    }
*/
}



