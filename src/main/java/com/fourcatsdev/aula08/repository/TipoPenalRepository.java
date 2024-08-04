package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.TipoPenal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TipoPenalRepository extends JpaRepository<TipoPenal, Long> {



}
