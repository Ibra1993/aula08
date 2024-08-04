package com.fourcatsdev.aula08.Component;


import com.fourcatsdev.aula08.modelo.Papel;
import com.fourcatsdev.aula08.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarregadoraDados implements CommandLineRunner {

    @Autowired
    private PapelRepository papelRepository;


    @Override
    public void run(String... args) throws Exception {

        String[] papeis = {"ADMIN", "USER"};
        for(String papelString: papeis){

            Papel papel = papelRepository.findByPapel(papelString);
            if(papel == null){
                papel = new Papel(papelString);
                papelRepository.save(papel);
            }

        }

    }


}



