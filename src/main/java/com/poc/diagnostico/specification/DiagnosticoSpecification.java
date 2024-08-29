package com.poc.diagnostico.specification;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.enums.StatusDiagnostico;
import com.poc.diagnostico.enums.TipoPredio;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class DiagnosticoSpecification {

    public static Specification<Diagnostico> filtrarPorAno(Integer ano) {
        return (root, query, builder) -> {
            return ObjectUtils.isEmpty(ano) ? null : builder.equal(root.get("ano"), ano);
        };
    }

    public static Specification<Diagnostico> filtrarPorNomeRegional(String regional) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(regional)) {
                return null;
            }
            Join<Object, Object> predioEscolaJoin = root.join("predioEscola");
            Join<Object, Object> predioJoin = predioEscolaJoin.join("predio");
            Join<Object, Object> regionalJoin = predioJoin.join("regional");

            return builder.like(builder.lower(regionalJoin.get("nome")), "%" + regional.toLowerCase() + "%");
        };
    }

    public static Specification<Diagnostico> filtrarPorMunicipio(List<String> municipios) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(municipios)) {
                return null;
            }
            Join<Object, Object> predioEscolaJoin = root.join("predioEscola");
            Join<Object, Object> predioJoin = predioEscolaJoin.join("predio");
            Join<Object, Object> regionalJoin = predioJoin.join("regional");
            Join<Object, Object> municipiolJoin = regionalJoin.join("municipio");

            return municipiolJoin.get("nome").in(municipios);
        };
    }

    public static Specification<Diagnostico> filtrarPorEscola(String escola) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(escola)) {
                return null;
            }
            Join<Object, Object> predioEscolaJoin = root.join("predioEscola");
            Join<Object, Object> escolaJoin = predioEscolaJoin.join("escola");

            return builder.like(escolaJoin.get("nome"), "%" + escola + "%");
        };
    }

    public static Specification<Diagnostico> filtrarPorTipoPredio(TipoPredio tipoPredio) {
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(tipoPredio)) {
                return null;
            }

            Join<Object, Object> predioEscolaJoin = root.join("predioEscola");
            Join<Object, Object> predioJoin = predioEscolaJoin.join("predio");
            return builder.equal(predioJoin.get("tipo"), tipoPredio);
        };
    }

    public static Specification<Diagnostico> filtrarPorStatus(StatusDiagnostico statusDiagnostico) {
        return (root, query, builder) -> {
            return ObjectUtils.isEmpty(statusDiagnostico) ? null : builder.equal(root.get("status"), statusDiagnostico);
        };
    }

}
