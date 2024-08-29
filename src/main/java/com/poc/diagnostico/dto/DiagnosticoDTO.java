package com.poc.diagnostico.dto;

import com.poc.diagnostico.enums.StatusDiagnostico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DiagnosticoDTO {

    private Long id;
    private Integer ano;
    private StatusDiagnostico status;
    private PredioEscolaDTO predioEscola;
}
