package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.EstadoCivil;
import com.fourcatsdev.aula08.repository.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoCivilService {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;


    public List<EstadoCivil> listarEstadoCivil(){

        return estadoCivilRepository.findAll(Sort.by(Sort.Direction.ASC, "matrimonio"));

    }

}
