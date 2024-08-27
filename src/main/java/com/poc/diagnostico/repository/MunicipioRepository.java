package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
}
