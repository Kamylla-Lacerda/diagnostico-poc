package com.poc.diagnostico.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_escola")
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESCOLA")
    private Long id;

    @Column(name = "CD_CENSO")
    private Integer codigoCenso;

    @Column(name = "NM_ESCOLA")
    @Size(max = 100)
    private String nome;

    //TODO: O que seria este numeroAluno?
    @Column(name = "NR_ALUNO")
    private Integer numeroAluno;
}

