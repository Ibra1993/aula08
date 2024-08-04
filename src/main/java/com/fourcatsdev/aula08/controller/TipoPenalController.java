package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.excecao.CrimeNotFoundException;
import com.fourcatsdev.aula08.modelo.Crime;
import com.fourcatsdev.aula08.modelo.TipoPenal;
import com.fourcatsdev.aula08.service.CrimeService;
import com.fourcatsdev.aula08.service.TipoPenalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tipoPenal")
public class TipoPenalController {

    @Autowired
    private TipoPenalService tipoPenalService;

    @Autowired
    private CrimeService crimeService;


    @GetMapping("/buscar-tipoPenal/{id}")
    public String novoTipoPenal(@PathVariable("id") long id, Model model){

        String pagina = "";
        try{
            Crime crime = crimeService.buscarCrimePorId(id);

            if(crime.getTipoPenal() == null){
                TipoPenal tipoPenal = new TipoPenal();
                tipoPenal.setCrime(crime);
                model.addAttribute("penal", tipoPenal);
                pagina = "/auth/user/publica-criar-tipoPenal";

            }else {
                model.addAttribute("penal", crime.getTipoPenal());
                pagina = "/auth/user/user-alterar-tipoPenal";
            }
        }catch (CrimeNotFoundException e){
            e.printStackTrace();
        }
        return pagina;
    }

    @PostMapping("/gravar-tipoPenal/{idCrime}")
    public String gravarTipoPenal(@PathVariable("idCrime") long idCrime,
                                  @ModelAttribute("penal") @Valid TipoPenal tipoPenal, BindingResult result,
                                  RedirectAttributes attributes){

        try{
            Crime crime = crimeService.buscarCrimePorId(idCrime);
             tipoPenal.setCrime(crime);

        }catch (CrimeNotFoundException e){
            e.printStackTrace();
        }
        if(result.hasErrors()){

            return "/auth/user/publica-criar-tipoPenal";

        }

        tipoPenalService.salvar(tipoPenal);
        attributes.addFlashAttribute("mensagem", "Tipo penal registrado com sucesso");

       // return "redirect:/crime/listar";
        return "redirect:/crime/listar";

    }



    @PostMapping("/alterar-tipoPenal/{idCrime}/{idTipoPenal}")
    public String alterarTipoPenal(@PathVariable("idCrime") long idCrime,
                                   @PathVariable("idTipoPenal") long idTipoPenal,
                                  @ModelAttribute("penal") @Valid TipoPenal tipoPenal, BindingResult result,
                                  RedirectAttributes attributes){

        try{
            Crime crime = crimeService.buscarCrimePorId(idCrime);
            tipoPenal.setCrime(crime);
            tipoPenal.setId(idTipoPenal);

        }catch (CrimeNotFoundException e){
            e.printStackTrace();
        }
        if(result.hasErrors()){

            return "/auth/user/user-alterar-tipoPenal";

        }

        tipoPenalService.salvar(tipoPenal);
        attributes.addFlashAttribute("mensagem", "Tipo penal alterado com sucesso");

        return "redirect:/tipoPenal/buscar-tipoPenal/"+idCrime;

    }




}
