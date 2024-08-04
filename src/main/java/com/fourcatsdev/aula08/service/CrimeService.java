package com.fourcatsdev.aula08.service;

import com.fourcatsdev.aula08.excecao.CrimeNotFoundException;
import com.fourcatsdev.aula08.modelo.Crime;
import com.fourcatsdev.aula08.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;


    public Crime criarCrime(Crime crime){

       return crimeRepository.save(crime);

    }

    public List<Crime> buscarTodosCrimes(){
        return crimeRepository.findAll();
    }

    public Crime buscarCrimePorId(Long id)throws CrimeNotFoundException {

        Optional<Crime> opt = crimeRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new CrimeNotFoundException("Crime com id: " + id + "não existe");
        }

    }

    public void apagarCrime(Long id) throws CrimeNotFoundException{

        Crime crime = buscarCrimePorId(id);
        crimeRepository.delete(crime);
    }


public Crime alterarCrime(Crime crime){
        return crimeRepository.save(crime);
}


public List<Crime> listarTodosFurto(){

    List<Crime> result = crimeRepository.listadeFurto();
    return result;
}

    public List<Crime> listarTodosFurtoQualificado(){

        List<Crime> result = crimeRepository.listadeFurtoQualificado();
        return  result;
    }

    public List<Crime> listarTodosFurtoDeUso(){

        List<Crime> result = crimeRepository.listadeFurtoDeUso();
        return result;
    }

    public List<Crime> listarTodosRoubo(){

        List<Crime> result = crimeRepository.listadeRoubo();
        return result;
    }

    public List<Crime> listarTodosAgressao(){

        List<Crime> result =crimeRepository.listadeAgressao();
        return result;
    }

    public List<Crime> listarTodosAmeaca(){

        return crimeRepository.listadeAmeaca();

    }


    public List<Crime> listarTodosExtorsao(){

          List<Crime> result = crimeRepository.listadeExtorsao();
        return result;
    }

    public List<Crime> listarTodosViolacaoDomicilio(){

        List<Crime> result = crimeRepository.listadeViolacaoDeDomicilio();
        return result;
    }


    public long emAnalise(){

        List<Crime> cri = crimeRepository.findByCrimeAnalise();
        long t = cri.size();

    return t;

    }


    public long emSolucionado(){


        List<Crime> cri = crimeRepository.findByCrimeSolucionado();
        long t = cri.size();

        return t;

    }

/*
    public List<Crime> andamento(String numeroDoDocumento) throws CrimeNotFoundException {

        List<Crime> cri = crimeRepository.findAll();

        int i = 0;

        for(Crime per : cri){

            if(per.getVitima().getNumeroDoDocumento().equals(numeroDoDocumento)){

                return (List<Crime>) per;

            }else{
                throw new CrimeNotFoundException("Crime com número de documento: " + numeroDoDocumento + "não existe");
            }

        }

        return null;
    }
*/
}
