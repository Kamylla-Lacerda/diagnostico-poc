package com.poc.diagnostico.dto;

import com.poc.diagnostico.enums.TipoPredio;
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
public class PredioDTO {

    private Long id;
    private TipoPredio tipo;
    private RegionalDTO regional;

}
