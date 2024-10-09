package com.poc.diagnostico.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_regional")
public class Regional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGIONAL")
    private Long id;

    @Column(name = "CD_CENSO")
    private Long codigoCenso;

    @Column(name = "NM_REGIONAL")
    @Size(max = 255)
    private String nome;

    @Column(name = "NM_REGIONAL_REDUZIDO")
    @Size(max = 50)
    private String nomeReduzido;

    @Column(name = "SG_REGIONAL")
    @Size(max = 3)
    private String sigla;

    @Column(name = "DS_EMAIL")
    @Size(max = 150)
    private String email;

    @Column(name = "CD_SSC")
    @Size(max = 20)
    private String codigosSsc;

    @Column(name = "FL_ATIVO")
    private Boolean flagAtivo;
}
