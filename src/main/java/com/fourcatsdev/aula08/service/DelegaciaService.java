package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.Delegacia;
import com.fourcatsdev.aula08.repository.DelegaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelegaciaService {

    @Autowired
    private DelegaciaRepository delegaciaRepository;

    public Delegacia salvarDelegacia(Delegacia delegacia){

        return delegaciaRepository.save(delegacia);
    }

    public List<Delegacia> listarDelegacias(){

        return delegaciaRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeDaDelegacia"));

    }
}
