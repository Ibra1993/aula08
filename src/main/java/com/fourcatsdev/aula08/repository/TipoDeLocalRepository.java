package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.TipoDeLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeLocalRepository extends JpaRepository<TipoDeLocal, Long> {

}
