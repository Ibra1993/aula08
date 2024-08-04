package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.TipoDeCrime;
import com.fourcatsdev.aula08.repository.TipoDeCrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeCrimeService {

    @Autowired
    private TipoDeCrimeRepository tipoDeCrimeRepository;


    public List<TipoDeCrime> listarTiposDeCrime(){


        return tipoDeCrimeRepository.findAll(Sort.by(Sort.Direction.ASC, "tipoDeCrime"));

    }
}
