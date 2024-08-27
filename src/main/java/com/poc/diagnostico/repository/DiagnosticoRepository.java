package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, UUID> {
}
