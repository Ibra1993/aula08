package com.fourcatsdev.aula08.controller;

import com.fourcatsdev.aula08.repository.CrimeRepository;
import com.fourcatsdev.aula08.repository.VitimaRepository;
import com.fourcatsdev.aula08.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

   @Autowired
   private CrimeService crimeService;

   @Autowired
    private CrimeRepository crimeRepository;

    @Autowired
    private VitimaRepository vitimaRepository;

    @GetMapping("/exibir")
    public String exibirRelatorio(Model model){

        if(crimeRepository.countCrime() == 0){

            model.addAttribute("Furto",0);
            model.addAttribute("FurtoQualificado",0);
            model.addAttribute("FurtoDeUso",0);
            model.addAttribute("Roubo",0);
            model.addAttribute("Agressao",0);
            model.addAttribute("Ameaca",0);
            model.addAttribute("Extorsao",0);
            model.addAttribute("ViolacaoDomicilio",0);


           // return "/auth/user/listagem";
            return "/listagem";

        }else{

            double furto = ((double)crimeRepository.countFurto() / (double)crimeRepository.countCrime()) * 100;
            double furtoQualificado = ((double)crimeRepository.countFurtoQualificado() / (double)crimeRepository.countCrime()) * 100;
            double furtoDeUso = ((double)crimeRepository.countFurtoDeUso() / (double)crimeRepository.countCrime()) * 100;
            double roubo = ((double)crimeRepository.countRoubo() / (double)crimeRepository.countCrime()) * 100;
            double agressao = ((double)crimeRepository.countAgressao() / (double)crimeRepository.countCrime()) * 100;
            double ameaca = ((double)crimeRepository.countAmeaca() / (double)crimeRepository.countCrime()) * 100;
            double extorsao = ((double)crimeRepository.countExtorsao() / (double)crimeRepository.countCrime()) * 100;
            double violacaoDeDomicilio = ((double)crimeRepository.countViolacaoDeDomicilio() / (double)crimeRepository.countCrime()) * 100;


            model.addAttribute("Furto", furto);
            model.addAttribute("FurtoQualificado", furtoQualificado);
            model.addAttribute("FurtoDeUso",furtoDeUso);
            model.addAttribute("Roubo", roubo);
            model.addAttribute("Agressao", agressao);
            model.addAttribute("Ameaca", ameaca);
            model.addAttribute("Extorsao", extorsao);
            model.addAttribute("ViolacaoDomicilio", violacaoDeDomicilio);


           // return "/auth/user/listagem";
            return "/listagem";

        }


    }

    @GetMapping("/andamentos-em-Analise-solucionados")
    public String ocorrenciasSolucionados(Model model){

        if(crimeRepository.countCrime() == 0){


            model.addAttribute("solucionados", 0);
            model.addAttribute("analisando", 0);

           // return "/auth/user/solucionados";
            return "/solucionados";

        }else{

           double analisando = ((double)crimeService.emAnalise() /  (double)crimeRepository.countCrime()) * 100;
           double solucionados = ((double)crimeService.emSolucionado() /  (double)crimeRepository.countCrime()) * 100;


            model.addAttribute("analisando",analisando);
            model.addAttribute("solucionados", solucionados);

            //return "/auth/user/solucionados";
            return "/solucionados";


        }

    }

    @GetMapping("/bairrosOcorrencias")
    public String relatorioBairros(Model model) {

        if(crimeRepository.countCrime() == 0) {

            model.addAttribute("Mindara",0);
            model.addAttribute("Antula",  0);
            model.addAttribute("Bandim",  0);
            model.addAttribute("Djogoro", 0);
            model.addAttribute("Pluba",  0);
            model.addAttribute("StLuzia",  0);

            model.addAttribute("Pilum",0);
            model.addAttribute("Cuntum",  0);
            model.addAttribute("bAjuda",  0);
            model.addAttribute("BMilitar", 0);
            model.addAttribute("Aeroporto",  0);
            model.addAttribute("Belem",  0);

            model.addAttribute("Bissack", 0);
            model.addAttribute("Flefe",  0);
            model.addAttribute("russio",  0);
            model.addAttribute("Luanda",  0);


          //  return "/auth/admin/regiao";
            return "/regiao";

        }else{

            double antula = ((double)crimeRepository.countAntula() / (double)crimeRepository.countCrime()) * 100;
            double mindara = ((double)crimeRepository.countMindara()/ (double)crimeRepository.countCrime()) * 100;
            double bandim = ((double)crimeRepository.countBandim() / (double)crimeRepository.countCrime()) * 100;

            double djogoro = ((double)crimeRepository.countDjogoro()/ (double)crimeRepository.countCrime()) * 100;
            double pluba = ((double)crimeRepository.countPluba()/ (double)crimeRepository.countCrime()) * 100;
            double stLuzia = ((double)crimeRepository.countStLuzia()/ (double)crimeRepository.countCrime()) * 100;


            double pilum = ((double)crimeRepository.countPilum() / (double) crimeRepository.countCrime()) * 100;

            double cuntum = ((double) crimeRepository.countCuntum() / (double)crimeRepository.countCrime()) * 100;


            double bAjuda = ((double) crimeRepository.countBajuda() / (double)crimeRepository.countCrime()) * 100;

            double bMilitar = ((double)crimeRepository.countBmilitar() / (double)crimeRepository.countCrime()) * 100;
            double aeroporto = ((double) crimeRepository.countAeroporto() /  (double)crimeRepository.countCrime()) * 100;
            double belem = ((double)crimeRepository.countBelem() / (double)crimeRepository.countCrime()) * 100;
            double bissack = ((double)crimeRepository.countBissack() / (double)crimeRepository.countCrime()) * 100;
            double flefe = ((double)crimeRepository.countFlefe() / (double)crimeRepository.countCrime()) * 100;
            double russio = ((double)crimeRepository.countRussio() / (double)crimeRepository.countCrime()) * 100;
            double luanda = ((double)crimeRepository.countLuanda() / (double)crimeRepository.countCrime()) * 100;

            model.addAttribute("Mindara", mindara);
            model.addAttribute("Antula", antula);
            model.addAttribute("Bandim", bandim);
            model.addAttribute("Djogoro", djogoro);
            model.addAttribute("Pluba",  pluba);
            model.addAttribute("StLuzia",  stLuzia);

            model.addAttribute("Pilum",pilum);
            model.addAttribute("Cuntum", cuntum);
            model.addAttribute("bAjuda", bAjuda);
            model.addAttribute("BMilitar", bMilitar);
            model.addAttribute("Aeroporto", aeroporto);
            model.addAttribute("Belem", belem);

            model.addAttribute("bissack", bissack);
            model.addAttribute("Flefe",  flefe);
            model.addAttribute("russio", russio);
            model.addAttribute("Luanda",  luanda);

            return "/regiao";

       }

    }

    @GetMapping("/exibirGenero")
    public String exibirRelatorioGenero(Model model){

        if(vitimaRepository.countVitima() == 0){


            model.addAttribute("homensCis", 0);
            model.addAttribute("mulherCis", 0);
            model.addAttribute("mulherTrans", 0);
            model.addAttribute("homenTrans", 0);
            model.addAttribute("hetero", 0);
            model.addAttribute("assexual", 0);
            model.addAttribute("bissexual", 0);

            return "/mulheresHomens";


        }else {

           double hetero = ((double)vitimaRepository.countHeterossexual()/(double)vitimaRepository.countVitima()) * 100;
            double bissexual = ((double)vitimaRepository.countBissexual()/(double)vitimaRepository.countVitima()) * 100;
            double homensCis = ((double)vitimaRepository.countHomemCisgenero()/(double)vitimaRepository.countVitima()) * 100;

            double mulherCis = ((double)vitimaRepository.countMulherCisgenero()/(double)vitimaRepository.countVitima()) * 100;
            double mulherTrans = ((double)vitimaRepository.countMulherTransgenero()/(double)vitimaRepository.countVitima()) * 100;
            double homenTrans = ((double)vitimaRepository.countHomemTransgenero()/(double)vitimaRepository.countVitima()) * 100;
            double assexual = ((double)vitimaRepository.countAssexual()/(double)vitimaRepository.countVitima()) * 100;
            double naoBinario = ((double)vitimaRepository.countNaoBinario()/(double)vitimaRepository.countVitima()) * 100;



            model.addAttribute("homensCis", homensCis);
            model.addAttribute("mulherCis", mulherCis);
            model.addAttribute("mulherTrans", mulherTrans);
            model.addAttribute("homenTrans", homenTrans);
            model.addAttribute("hetero", hetero);
            model.addAttribute("assexual", assexual);
            model.addAttribute("bissexual", bissexual);
            model.addAttribute("naoBinario", naoBinario);

            return "/mulheresHomens";
        }

    }

}
