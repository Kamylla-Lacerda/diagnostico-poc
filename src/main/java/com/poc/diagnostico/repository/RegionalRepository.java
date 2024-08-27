package com.poc.diagnostico.repository;

import com.poc.diagnostico.entity.Regional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegionalRepository extends JpaRepository<Regional, UUID> {
}
