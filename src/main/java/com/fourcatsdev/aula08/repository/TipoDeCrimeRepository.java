package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.TipoDeCrime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeCrimeRepository extends JpaRepository<TipoDeCrime, Long> {


}
