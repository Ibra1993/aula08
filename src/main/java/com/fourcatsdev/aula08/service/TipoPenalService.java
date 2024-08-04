package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.TipoPenal;
import com.fourcatsdev.aula08.repository.TipoPenalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPenalService {

    @Autowired
    TipoPenalRepository tipoPenalRepository;

    public TipoPenal salvar(TipoPenal tipoPenal){

        return tipoPenalRepository.save(tipoPenal);

    }
}
