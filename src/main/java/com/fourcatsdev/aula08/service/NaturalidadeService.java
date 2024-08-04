package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.modelo.Naturalidade;
import com.fourcatsdev.aula08.repository.NaturalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaturalidadeService {

    @Autowired
    private NaturalidadeRepository naturalidadeRepository;

    public List<Naturalidade> listarNaturalidade(){

        return naturalidadeRepository.findAll(Sort.by(Sort.Direction.ASC, "naturalidade"));

    }


}








