package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.AndamentoOcorrencia;
import com.fourcatsdev.aula08.repository.AndamentoOcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AndamentoOcorrenciaService {
    @Autowired
    private AndamentoOcorrenciaRepository andamentoOcorrenciaRepository;

    public AndamentoOcorrencia salvar(AndamentoOcorrencia andamentoOcorrencia){

       return andamentoOcorrenciaRepository.save(andamentoOcorrencia);

    }
    public List<AndamentoOcorrencia> listarEstado(){

        return andamentoOcorrenciaRepository.findAll(Sort.by(Sort.Direction.ASC, "estado"));
    }
}
