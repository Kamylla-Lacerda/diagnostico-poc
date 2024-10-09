package com.poc.diagnostico.specification;

import com.poc.diagnostico.entity.Diagnostico;
import com.poc.diagnostico.entity.PredioEscola;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.time.Year;

public class PredioEscolaSpecification {

    public static Specification<PredioEscola> semDiagnostico() {
        return (root, query, criteriaBuilder) -> {
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<Diagnostico> subRoot = subquery.from(Diagnostico.class);
            subquery.select(subRoot.get("predioEscola").get("id"));

            return criteriaBuilder.not(root.get("id").in(subquery));
        };
    }

    public static Specification<PredioEscola> filtrarPorSre(String sre) {
        return (root, query, criteriaBuilder) -> {
            if (sre == null || sre.isEmpty()) {
                return criteriaBuilder.conjunction(); // Se SRE não for fornecido, não filtra por ele
            }
            return criteriaBuilder.equal(root.get("predio").get("municipioRegional").get("regional").get("nome"), sre);
        };
    }

}
