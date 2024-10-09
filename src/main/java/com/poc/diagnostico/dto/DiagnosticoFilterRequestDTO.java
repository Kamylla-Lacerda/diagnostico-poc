package com.poc.diagnostico.dto;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.enums.StatusDiagnosticoEnum;
import com.poc.diagnostico.enums.TipoEscolaEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.poc.diagnostico.specification.DiagnosticoSpecification.filtrarPorAno;
import static com.poc.diagnostico.specification.DiagnosticoSpecification.filtrarPorSre;


@Setter
@Getter
public class DiagnosticoFilterRequestDTO {

    private String regional;
    private List<String> municipios;
    private String escola;
    private TipoEscolaEnum tipoPredio;
    private StatusDiagnosticoEnum statusDiagnostico;
    private Integer ano;


    public Specification<Diagnostico> toSpecification() {
        return Specification.where(filtrarPorAno(ano))
                .and(filtrarPorSre(regional));
    }
}
