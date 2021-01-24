package com.ricardohernani.projeto_gpmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardohernani.projeto_gpmo.domain.Referencia;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {

}
