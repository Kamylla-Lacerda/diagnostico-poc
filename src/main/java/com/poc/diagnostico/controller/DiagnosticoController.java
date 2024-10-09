package com.poc.diagnostico.controller;

import com.poc.diagnostico.dto.DiagnosticoFilterDTO;
import com.poc.diagnostico.dto.DiagnosticoFilterRequestDTO;
import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.service.DiagnosticoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService service;

    @GetMapping()
    public ResponseEntity<List<DiagnosticoFilterDTO>> findDiagnosticos(DiagnosticoFilterRequestDTO filter) {
        List<DiagnosticoFilterDTO> diagnosticos = service.findDiagnosticos(filter);
        return ResponseEntity.ok().body(diagnosticos);
    }

}
