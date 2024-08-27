package com.poc.diagnostico.mapper;

import com.poc.diagnostico.dto.DiagnosticoDTO;
import com.poc.diagnostico.entity.Diagnostico;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface DiagnosticoMapper {

    DiagnosticoDTO diagnosticoToDiagnosticoDTO(Diagnostico diagnostico);

    List<DiagnosticoDTO> diagnosticosToDiagnosticoDTOs(List<Diagnostico> diagnosticos);
}
