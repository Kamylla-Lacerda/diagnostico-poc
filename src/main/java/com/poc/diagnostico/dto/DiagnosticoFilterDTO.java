package com.poc.diagnostico.dto;

import com.poc.diagnostico.enums.StatusDiagnosticoEnum;
import com.poc.diagnostico.enums.TipoEscolaEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticoFilterDTO {
    private String sre;
    private String municipio;
    private String codigoEscola;
    private String escola;
    private TipoEscolaEnum tipoEscola;
    private Integer quantidadeAluno;
    private StatusDiagnosticoEnum statusDiagnostico;
}
