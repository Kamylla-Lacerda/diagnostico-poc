package com.poc.diagnostico.entity;

import com.poc.diagnostico.enums.StatusDiagnostico;
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

    @Column(name = "ANO_DIAGNOSTICO")
    private Integer ano;

    @Column(name = "DS_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusDiagnostico status;

    @ManyToOne
    @JoinColumn(name = "ID_PREDIO_ESCOLA")
    private PredioEscola predioEscola;
}
