package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.ProfissaoNotFoundException;
import com.fourcatsdev.aula08.modelo.Profissao;
import com.fourcatsdev.aula08.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public Profissao salvarProfissao(Profissao profissao){

        return profissaoRepository.save(profissao);

    }

    public List<Profissao> listar(){

        return profissaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeDaProfissao"));

    }

    public Profissao buscarProfissaoPorId(Long id) throws ProfissaoNotFoundException {

        Optional<Profissao> opt = profissaoRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();

        }else{
            throw  new ProfissaoNotFoundException("Profissão com id: " + id + "não existe");
        }

    }

    public void apagarProfissao(Long id) throws ProfissaoNotFoundException{

        Profissao profissao = buscarProfissaoPorId(id);
        profissaoRepository.delete(profissao);
    }

    public Profissao alterarProfissao(Profissao profissao){

        return profissaoRepository.save(profissao);
    }

}
