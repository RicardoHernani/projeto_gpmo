package com.ricardohernani.projeto_gpmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardohernani.projeto_gpmo.domain.Procedimento;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {

}
