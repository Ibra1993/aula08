package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.BairroNotFoundException;
import com.fourcatsdev.aula08.modelo.Bairro;
import com.fourcatsdev.aula08.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;



    public Bairro criarBairro(Bairro bairro){

        return bairroRepository.save(bairro);

    }

    public List<Bairro> buscarTodosBairros(){

        return bairroRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeDoBairro"));
    }

    public Bairro buscarBairroPorId(Long id)throws BairroNotFoundException {

        Optional<Bairro> opt = bairroRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new BairroNotFoundException("Bairro com id: " + id + "não existe");
        }

    }

    public void apagarBairro(Long id) throws BairroNotFoundException{

        Bairro bairro = buscarBairroPorId(id);
        bairroRepository.delete(bairro);
    }

    public Bairro alterarBairro(Bairro bairro){
        return bairroRepository.save(bairro);
    }


}
