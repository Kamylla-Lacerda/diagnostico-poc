package com.poc.diagnostico.service;

import com.poc.diagnostico.dto.DiagnosticoDTO;
import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.mapper.DiagnosticoMapper;
import com.poc.diagnostico.repository.DiagnosticoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repository;

    @Autowired
    private DiagnosticoMapper mapper;

    public List<DiagnosticoDTO> findDiagnosticosDTO(){
        return mapper.diagnosticosToDiagnosticoDTOs(repository.findAll());
    }

}
