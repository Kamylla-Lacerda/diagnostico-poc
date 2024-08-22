package com.poc.diagnostico.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tb_regional")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGIONAL")
    private Long id;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "COD_MUNUCIPIO")
    private Integer codigo;

    @Column(name = "UF")
    private String uf;
}
