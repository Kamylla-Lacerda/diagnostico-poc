package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.MunicipioRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRegionalRepository extends JpaRepository<MunicipioRegional, Long> {
}
