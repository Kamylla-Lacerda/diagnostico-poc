package com.poc.diagnostico.dto;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.enums.StatusDiagnostico;
import com.poc.diagnostico.enums.TipoPredio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.poc.diagnostico.specification.DiagnosticoSpecification.*;


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
        return
                filtrarPorAno(ano)
                .and(filtrarPorNomeRegional(regional)
                .and(filtrarPorMunicipio(municipios)
                .and(filtrarPorEscola(escola)
                .and(filtrarPorTipoPredio(tipoPredio)
                .and(filtrarPorStatus(statusDiagnostico))
                ))));
    }
}
