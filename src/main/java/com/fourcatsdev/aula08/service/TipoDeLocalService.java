package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.TipoDeLocal;
import com.fourcatsdev.aula08.repository.TipoDeLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeLocalService {

    @Autowired
    private TipoDeLocalRepository tipoDeLocalRepository;


    public List<TipoDeLocal> listarTiposDeLocal(){

        return tipoDeLocalRepository.findAll(Sort.by(Sort.Direction.ASC, "tipoDeLocal"));

    }


}




