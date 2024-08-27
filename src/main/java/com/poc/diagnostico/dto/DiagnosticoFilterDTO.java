package com.poc.diagnostico.dto;

import com.poc.diagnostico.entity.Diagnostico;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.poc.diagnostico.specification.DiagnosticoSpecification.anoContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.municipioContains;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.regionalContains;

@Setter
@Getter
public class DiagnosticoFilterDTO {
    private Integer ano;
    private String regional;
    private List<String> municipios;


    public Specification<Diagnostico> toSpecification() {
        return anoContains(ano)
                .and(regionalContains(regional)
                        .and(municipioContains(municipios)));
    }
}
