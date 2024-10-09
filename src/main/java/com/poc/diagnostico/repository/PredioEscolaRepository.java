package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.entity.PredioEscola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PredioEscolaRepository extends JpaRepository<PredioEscola, Long>, JpaSpecificationExecutor<PredioEscola> {
}
