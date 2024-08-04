package com.fourcatsdev.aula08.repository;


import com.fourcatsdev.aula08.modelo.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

}
