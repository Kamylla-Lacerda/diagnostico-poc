package com.poc.diagnostico.entity;

import com.poc.diagnostico.enums.StatusDiagnosticoEnum;
import com.poc.diagnostico.enums.TipoContrucaoEnum;
import com.poc.diagnostico.enums.TipoEnsinoEnum;
import com.poc.diagnostico.enums.TipoEscolaEnum;
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
@Table(name = "tb_diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIAGNOSTICO")
    private Long id;

    @Column(name = "QT_ALUNO")
    private Integer quantidadeAluno;

    @Column(name = "NM_ESCOLA")
    @Size(max = 255)
    private String nomeEscola;

    @Column(name = "TP_ESCOLA")
    @Enumerated(EnumType.STRING)
    private TipoEscolaEnum tipoEscola;

    @Column(name = "TP_ENSINO_ESCOLA")
    @Enumerated(EnumType.STRING)
    private TipoEnsinoEnum tipoEnsinoEscola;

    @Column(name = "TP_PREDIO")
    @Enumerated(EnumType.STRING)
    private TipoPredioEnum tipoPredio;

    //TODO: AQUI INDICARIA O ID DO ENDEREÇO PRINCIPAL?
    @Column(name = "FL_ENDERECO_PRINCIPAL")
    private Boolean flagEnderecoPrincipal;

    @Column(name = "FL_TOMBAMENTO")
    private Integer flagTombamento;

    @Column(name = "NR_PAVIMENTOS")
    private Integer numeroPavimentos;

    @Column(name = "NR_BLOCOS")
    private Integer numeroBlocos;

    @Column(name = "TP_CONSTRUCAO")
    @Enumerated(EnumType.STRING)
    private TipoContrucaoEnum tipoContrucao;

    @Column(name = "QT_AREA_TOTAL")
    private Float areaTotal;

    @Column(name = "QT_AREA_CONSTRUIDA")
    private Float areaContruida;

    //TODO: TELEFONE SERIA UMA LISTA?
    @Column(name = "DS_TELEFONE")
    @Size(max = 11)
    private String telefoneEscola;

    @Column(name = "DS_EMAIL")
    @Size(max = 100)
    private String emailEscola;

    @Column(name = "OB_PREDIO")
    @Size(max = 255)
    private String observacaoPredio;

    @Column(name = "AA_DIAGNOSTICO")
    private Integer anoDiagnostico;

    @Column(name = "ST_DIAGNOSTICO")
    @Enumerated(EnumType.STRING)
    private StatusDiagnosticoEnum statusDiagnostico;

    @Column(name = "DS_JUSTIFICATIVA_DIAGNOSTICO")
    private String justificativa;

    @ManyToOne
    @JoinColumn(name = "ID_PREDIO_ESCOLA")
    @Size(max = 255)
    private PredioEscola predioEscola;
}
