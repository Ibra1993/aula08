package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

}
