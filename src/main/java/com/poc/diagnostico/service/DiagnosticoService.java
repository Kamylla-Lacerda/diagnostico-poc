package com.poc.diagnostico.service;

import com.poc.diagnostico.dto.DiagnosticoFilterDTO;
import com.poc.diagnostico.dto.DiagnosticoFilterRequestDTO;
import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.entity.PredioEscola;
import com.poc.diagnostico.mapper.DiagnosticoFilterMapper;
import com.poc.diagnostico.repository.DiagnosticoRepository;
import com.poc.diagnostico.repository.PredioEscolaRepository;
import com.poc.diagnostico.specification.PredioEscolaSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repository;

    @Autowired
    private PredioEscolaRepository predioEscolaRepository;

    @Autowired
    private DiagnosticoFilterMapper mapper;

    public List<DiagnosticoFilterDTO> findDiagnosticos(DiagnosticoFilterRequestDTO filter) {
        List<Diagnostico> diagnosticos;

        // Verifica se o ano é o atual
        if (filter.getAno() != null && filter.getAno().equals(Year.now().getValue())) {
            // Se for o ano atual, busca os Diagnosticos e os PredioEscolas sem Diagnostico
            diagnosticos = repository.findAll(filter.toSpecification());

            List<PredioEscola> predioEscolasSemDiagnostico = predioEscolaRepository
                    .findAll(PredioEscolaSpecification.semDiagnostico().and(PredioEscolaSpecification.filtrarPorSre(filter.getRegional())));

            // Combine os resultados
            List<DiagnosticoFilterDTO> resultados = new ArrayList<>();

            // Adiciona Diagnosticos ao DTO
            for (Diagnostico diagnostico : diagnosticos) {
                resultados.add(mapper.toDiagnosticoFilterDTO(diagnostico));
            }

            // Adiciona PredioEscolas ao DTO
            for (PredioEscola predioEscola : predioEscolasSemDiagnostico) {
                resultados.add(mapper.toDiagnosticoFilterDTO(predioEscola));
            }

            return resultados;

        } else {
            // Se o ano for diferente do atual, busca apenas os Diagnosticos
            diagnosticos = repository.findAll(filter.toSpecification());

            // Mapeia os Diagnosticos para o DTO
            List<DiagnosticoFilterDTO> resultados = new ArrayList<>();
            for (Diagnostico diagnostico : diagnosticos) {
                resultados.add(mapper.toDiagnosticoFilterDTO(diagnostico));
            }

            return resultados;
        }
    }

}
