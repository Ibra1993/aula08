package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

    Papel findByPapel(String papel);

}
