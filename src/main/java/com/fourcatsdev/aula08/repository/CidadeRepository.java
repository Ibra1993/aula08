package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
