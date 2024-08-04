package com.fourcatsdev.aula08.repository;

import com.fourcatsdev.aula08.modelo.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {


   // List<Crime> findByTipoDeCrimeIgnoreCase(String tipoDeCrime);

    @Query(nativeQuery = true, value = "select * from crime c where c.andamentoocorrencia_id=1")
    List<Crime> findByCrimeAnalise();

    @Query(nativeQuery = true, value = "select * from crime c where c.andamentoocorrencia_id=2")
    List<Crime> findByCrimeSolucionado();


    @Query(value = "select count(*) from crime where bairro_id = 1", nativeQuery = true)
    long countAntula();

    @Query(value = "select count(*) from crime where bairro_id = 2", nativeQuery = true)
    long countBandim();

    @Query(value = "select count(*) from crime where bairro_id = 3", nativeQuery = true)
    long countMindara();

    @Query(value = "select count(*) from crime where bairro_id = 4", nativeQuery = true)
    long countDjogoro();

    @Query(value = "select count(*) from crime where bairro_id = 5", nativeQuery = true)
    long countPluba();

    @Query(value = "select count(*) from crime where bairro_id = 6", nativeQuery = true)
    long countStLuzia();

    @Query(value = "select count(*) from crime where bairro_id = 7", nativeQuery = true)
    long countPilum();

    @Query(value = "select count(*) from crime where bairro_id = 8", nativeQuery = true)
    long countCuntum();


    @Query(value = "select count(*) from crime where bairro_id = 9", nativeQuery = true)
    long countBajuda();

    @Query(value = "select count(*) from crime where bairro_id = 10", nativeQuery = true)
    long countBmilitar();

    @Query(value = "select count(*) from crime where bairro_id = 11", nativeQuery = true)
    long countAeroporto();

    @Query(value = "select count(*) from crime where bairro_id = 12", nativeQuery = true)
    long countBelem();

    @Query(value = "select count(*) from crime where bairro_id = 13", nativeQuery = true)
    long countBissack();

    @Query(value = "select count(*) from crime where bairro_id = 14", nativeQuery = true)
    long countRussio();

    @Query(value = "select count(*) from crime where bairro_id = 15", nativeQuery = true)
    long countFlefe();


    @Query(value = "select count(*) from crime where bairro_id = 16", nativeQuery = true)
    long countLuanda();

    @Query(value = "select count(*) from crime where tipodecrime_id = 1", nativeQuery = true)
    long countFurto();

   @Query(value = "select count(*) from crime where tipodecrime_id = 2", nativeQuery = true)
    long countFurtoQualificado();

    @Query(value = "select count(*) from crime where tipodecrime_id = 3", nativeQuery = true)
    long countFurtoDeUso();

    @Query(value = "select count(*) from crime where tipodecrime_id = 4", nativeQuery = true)
    long countRoubo();

    @Query(value = "select count(*) from crime where tipodecrime_id = 5", nativeQuery = true)
    long countAgressao();

    @Query(value = "select count(*) from crime where tipodecrime_id = 6", nativeQuery = true)
    long countAmeaca();

    @Query(value = "select count(*) from crime where tipodecrime_id = 7", nativeQuery = true)
    long countExtorsao();

    @Query(value = "select count(*) from crime where tipodecrime_id = 8", nativeQuery = true)
    long countViolacaoDeDomicilio();

    // ===========================================

    @Query(value = "SELECT * FROM crime c where c.tipodecrime_id = 1", nativeQuery = true)
    List<Crime> listadeFurto();

   @Query(value = "SELECT * FROM crime c where c.tipodecrime_id = 2", nativeQuery = true)
    List<Crime> listadeFurtoQualificado();

    @Query(value = "SELECT * FROM  crime c where c.tipodecrime_id = 3", nativeQuery = true)
    List<Crime> listadeFurtoDeUso();

    @Query(value = "SELECT * FROM  crime c where c.tipodecrime_id = 4", nativeQuery = true)
    List<Crime> listadeRoubo();
    @Query(value ="SELECT * FROM  crime c where c.tipodecrime_id = 5", nativeQuery = true)
    List<Crime> listadeAgressao();

    @Query(value = "SELECT * FROM  crime c where c.tipodecrime_id = 6", nativeQuery = true)
    List<Crime> listadeAmeaca();

    @Query(value = "SELECT * FROM crime c where c.tipodecrime_id = 7",nativeQuery = true)
    List<Crime> listadeExtorsao();

    @Query(value = "SELECT * FROM crime c where c.tipodecrime_id = 8",nativeQuery = true)
    List<Crime> listadeViolacaoDeDomicilio();

    @Query(value = "select count(*) from crime", nativeQuery = true)
    long countCrime();





}
