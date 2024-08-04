package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.RegiaoNotFoundException;
import com.fourcatsdev.aula08.modelo.Regiao;
import com.fourcatsdev.aula08.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public Regiao CriarRegiao(Regiao regiao){

         return regiaoRepository.save(regiao);


    }

    public List<Regiao> buscarTodosRegioes(){
       return regiaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeDaRegiao"));

        //return regiaoRepository.findAll();
    }


    public Regiao buscarRegiaoPorId(Long id)throws RegiaoNotFoundException {


        Optional<Regiao> opt = regiaoRepository.findById(id);
        if (opt.isPresent()) {

            return opt.get();

        } else {

            throw new RegiaoNotFoundException("Regiao com id : " + id + " não existe");
        }


    }

    public void apagarRegiao(Long id) throws RegiaoNotFoundException {
        Regiao regiao = buscarRegiaoPorId(id);
        regiaoRepository.delete(regiao);
    }


    public Regiao alterarRegiao(Regiao regiao){

        return regiaoRepository.save(regiao);
    }

}
