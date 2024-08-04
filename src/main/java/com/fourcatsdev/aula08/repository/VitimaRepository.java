package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Vitima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitimaRepository extends JpaRepository<Vitima, Long> {

    List<Vitima> findByNumeroDoDocumentoIgnoreCase(String numeroDoDocumento);


    @Query(value = "select count(*) from vitima where genero_id = 1",  nativeQuery = true)
    long countMulherCisgenero();

    @Query(value = "select count(*) from vitima where genero_id = 2",  nativeQuery = true)
    long countMulherTransgenero();

    @Query(value = "select count(*) from vitima where genero_id = 3",  nativeQuery = true)
    long countHomemCisgenero();

    @Query(value = "select count(*) from vitima where genero_id = 4", nativeQuery = true)
    long countHomemTransgenero();

    @Query(value = "select count(*) from vitima where genero_id = 6", nativeQuery = true)
    long countHeterossexual();

    @Query(value = "select count(*) from vitima where genero_id = 7", nativeQuery = true)
    long countAssexual();

    @Query(value = "select count(*) from vitima where genero_id = 8", nativeQuery = true)
    long countBissexual();

    @Query(value = "select count(*) from vitima where genero_id = 5", nativeQuery = true)
    long countNaoBinario();

    @Query(value = "select count(*) from vitima", nativeQuery = true)
    long countVitima();



}
