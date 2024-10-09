package com.poc.diagnostico.mapper;

import com.poc.diagnostico.dto.DiagnosticoFilterDTO;
import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.entity.PredioEscola;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface DiagnosticoFilterMapper {

    @Mapping(source = "diagnostico.predioEscola.predio.municipioRegional.regional.nome", target = "sre")
    @Mapping(source = "diagnostico.predioEscola.predio.municipioRegional.municipio.nome", target = "municipio")
    @Mapping(source = "diagnostico.id", target = "codigoEscola")
    @Mapping(source = "diagnostico.nomeEscola", target = "escola")
    @Mapping(source = "diagnostico.quantidadeAluno", target = "quantidadeAluno")
    DiagnosticoFilterDTO toDiagnosticoFilterDTO(Diagnostico diagnostico);

    @Mapping(source = "predio.municipioRegional.regional.nome", target = "sre")
    @Mapping(source = "predio.municipioRegional.municipio.nome", target = "municipio")
    @Mapping(source = "predioEscola.id", target = "codigoEscola") // Ajuste conforme necessário
    @Mapping(source = "predioEscola.escola.nome", target = "escola")
    DiagnosticoFilterDTO toDiagnosticoFilterDTO(PredioEscola predioEscola);


}
