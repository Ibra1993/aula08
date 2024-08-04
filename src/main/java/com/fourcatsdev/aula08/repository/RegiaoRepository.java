package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {


}
