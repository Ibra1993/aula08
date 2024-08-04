package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.Genero;
import com.fourcatsdev.aula08.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;


    public List<Genero> listarGenero(){

        return generoRepository.findAll(Sort.by(Sort.Direction.ASC, "genero"));
    }


}
