package com.recursos.humanos.aplicacao.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosFinanceiro {

    private Double valSalHoraLiquido;
    private Double valSalHoraBruto;
}
