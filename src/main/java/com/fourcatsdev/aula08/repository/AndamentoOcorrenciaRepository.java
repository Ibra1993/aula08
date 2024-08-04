package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.AndamentoOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndamentoOcorrenciaRepository extends JpaRepository<AndamentoOcorrencia, Long> {

}
