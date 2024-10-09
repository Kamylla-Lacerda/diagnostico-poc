package com.poc.diagnostico.entity;

import com.poc.diagnostico.enums.TipoPredioEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_predio")
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PREDIO")
    private Long id;

    @Column(name = "CD_PREDIO")
    private Long codigo;

    @Column(name = "AA_CONSTRUCAO")
    private Integer ano;

    @Column(name = "DS_LOGRADOURO")
    @Size(max = 100)
    private String logradouro;

    @Column(name = "NR_LOGRADOURO")
    private Integer numero;

    @Column(name = "DS_COMPLEMENTO")
    @Size(max = 100)
    private String complemento;

    @Column(name = "DS_BAIRRO")
    @Size(max = 100)
    private String bairro;

    @Column(name = "DS_DISTRITO")
    @Size(max = 100)
    private String distrito;

    @Column(name = "DS_CEP")
    @Size(max = 100)
    private String cep;

    @Column(name = "TP_PREDIO")
    @Enumerated(EnumType.STRING)
    private TipoPredioEnum tipoPredio;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO_REGIONAL")
    private MunicipioRegional municipioRegional;
}
