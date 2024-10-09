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
@Table(name = "tb_municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO")
    private Long id;

    @Column(name = "CD_MUNICIPIO")
    private Long codigo;

    @Column(name = "NM_MUNICIPIO")
    @Size(max = 100)
    private String nome;

    @Column(name = "SG_UF")
    @Size(min = 2, max = 2)
    private String uf;

    @Column(name = "CD_COMPLETO")
    private Integer codigoCompleto;

    @Column(name = "CD_CEP_INICIAL")
    @Size(min = 9, max = 9)
    private String cepInicial;

    @Column(name = "CD_CEP_FINAL")
    @Size(min = 9, max = 9)
    private String cepFinal;

    @Column(name = "FL_ATIVO")
    private Boolean flagAtivo;
}
