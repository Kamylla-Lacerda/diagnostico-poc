package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, UUID> {
}
