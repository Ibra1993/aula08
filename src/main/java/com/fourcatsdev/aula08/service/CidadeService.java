package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.CidadeNotFoundException;
import com.fourcatsdev.aula08.modelo.Cidade;
import com.fourcatsdev.aula08.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cidade gravar(Cidade cidade){

        return cidadeRepository.save(cidade);

    }

    public List<Cidade> listar(){

       return cidadeRepository.findAll();

    }


    public Cidade buscarCidadePorId(Long id)throws CidadeNotFoundException {

        Optional<Cidade> opt = cidadeRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();

        }else{
            throw new CidadeNotFoundException("Cidade com id: " + id + "não existe");
        }

    }

    public void apagarCidade(Long id) throws CidadeNotFoundException{

        Cidade cidade = buscarCidadePorId(id);
        cidadeRepository.delete(cidade);

    }

    public Cidade alterarCidade(Cidade cidade){
        return cidadeRepository.save(cidade);
    }


}
