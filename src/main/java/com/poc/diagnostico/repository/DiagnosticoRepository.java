package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long>, JpaSpecificationExecutor<Diagnostico> {
}
