package com.poc.diagnostico.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "tb_predio_escola")
public class PredioEscola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PREDIO_ESCOLA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PREDIO")
    private Predio predio;

    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA")
    private Escola escola;

    @OneToMany(mappedBy = "predioEscola")
    private List<Diagnostico> diagnosticos;
}
