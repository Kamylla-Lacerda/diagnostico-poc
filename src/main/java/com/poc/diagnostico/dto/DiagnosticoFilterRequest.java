package com.poc.diagnostico.dto;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.enums.StatusDiagnostico;
import com.poc.diagnostico.enums.TipoPredio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.poc.diagnostico.specification.DiagnosticoSpecification.anoContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.escolaContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.municipioContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.regionalContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.statusContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.tipoPredioContains;

@Setter
@Getter
public class DiagnosticoFilterRequest {
    private Integer ano;
    private String regional;
    private List<String> municipios;
    private String escola;
    private TipoPredio tipoPredio;
    private StatusDiagnostico statusDiagnostico;


    public Specification<Diagnostico> toSpecification() {
        return anoContains(ano)
                    .and(regionalContains(regional)
                    .and(municipioContains(municipios)
                    .and(escolaContains(escola)
                    .and(tipoPredioContains(tipoPredio)
                    .and(statusContains(statusDiagnostico))
                ))));
    }
}
