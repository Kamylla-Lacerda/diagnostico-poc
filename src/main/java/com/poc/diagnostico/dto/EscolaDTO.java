package com.poc.diagnostico.dto;

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
public class EscolaDTO {
    private Long id;
    private Integer codigoCenso;
    private String nome;
    private Integer quantidadeAluno;
}
