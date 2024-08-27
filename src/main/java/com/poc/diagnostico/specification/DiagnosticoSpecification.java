package com.poc.diagnostico.specification;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.entity.Municipio;
import com.poc.diagnostico.entity.Predio;
import com.poc.diagnostico.entity.PredioEscola;
import com.poc.diagnostico.entity.Regional;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class DiagnosticoSpecification {
    public static Specification<Diagnostico> anoContains(Integer ano){
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(ano)){
                return null;
            }
            return builder.equal(root.get("ano"), ano);
        };
    }

    //TODO: VERIFICAR SE OS FILTROS VIRÃO POR UMA LISTA PRÉ DEFINIDA OU SE VIRÃO POR CAMPO LIVRE E A PESSOAL SELECIONA APENAS UM
    public static Specification<Diagnostico> regionalContains(String regional){
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(regional)){
                return null;
            }
            Join<Diagnostico, PredioEscola> predioEscolaJoin = root.join("predioEscola");
            Join<PredioEscola, Predio> predioJoin = predioEscolaJoin.join("predio");
            Join<PredioEscola, Predio> regionalJoin= predioJoin.join("regional");
            return builder.like(regionalJoin.get("nome"), "%" + regional + "%");
        };
    }

    public static Specification<Diagnostico> municipioContains(List<String> municipios){
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(municipios)){
                return null;
            }
            Join<Diagnostico, PredioEscola> predioEscolaJoin = root.join("predioEscola");
            Join<PredioEscola, Predio> predioJoin = predioEscolaJoin.join("predio");
            Join<Predio, Regional> regionalJoin= predioJoin.join("regional");
            Join<Regional, Municipio> municipiolJoin= regionalJoin.join("municipio");

            return municipiolJoin.get("nome").in(municipios);
        };
    }

    public static Specification<Diagnostico> escolaContains(String escola){
        return (root, query, builder) -> {
            if(ObjectUtils.isEmpty(escola)){
                return null;
            }
            Join<Diagnostico, PredioEscola> predioEscolaJoin = root.join("predioEscola");
            Join<PredioEscola, Predio> predioJoin = predioEscolaJoin.join("escola");
            return builder.like(predioJoin.get("nome"), "%" + escola + "%");
        };
    }
}
