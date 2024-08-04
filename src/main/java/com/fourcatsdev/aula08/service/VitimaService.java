package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.VitimaNotFoundException;
import com.fourcatsdev.aula08.modelo.Vitima;
import com.fourcatsdev.aula08.repository.VitimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VitimaService {

    @Autowired
    private VitimaRepository vitimaRepository;

    public Vitima salvar(Vitima vitima){

        return vitimaRepository.save(vitima);
    }

    public List<Vitima> listar(){

        return vitimaRepository.findAll();
    }

    public Vitima buscarVitimaPorId(Long id) throws VitimaNotFoundException {

        Optional<Vitima> opt = vitimaRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();

        }else {

            throw new VitimaNotFoundException("Vítima com id: " + id + "não existe");
        }

    }


    public void apagarVitima(Long id) throws VitimaNotFoundException{

        Vitima vitima = buscarVitimaPorId(id);
        vitimaRepository.delete(vitima);
    }


    public Vitima alterarVitimaa(Vitima vitima){

        return vitimaRepository.save(vitima);
    }


    public List<Vitima> buscarPorNumeroDeDocumento(String numeroDoDocumento){

        return vitimaRepository.findByNumeroDoDocumentoIgnoreCase(numeroDoDocumento);
    }

}
