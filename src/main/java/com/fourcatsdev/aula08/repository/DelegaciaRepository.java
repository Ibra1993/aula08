package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Delegacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegaciaRepository extends JpaRepository<Delegacia, Long>{

}
