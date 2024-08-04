package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Naturalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturalidadeRepository extends JpaRepository<Naturalidade, Long> {

}
