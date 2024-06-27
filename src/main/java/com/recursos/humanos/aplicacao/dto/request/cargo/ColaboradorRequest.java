package com.recursos.humanos.aplicacao.dto.request.cargo;

import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dominio.DadosFinanceiro;
import com.recursos.humanos.aplicacao.dominio.DadosPessoais;
import com.recursos.humanos.aplicacao.dominio.Endereco;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorRequest {

    private DadosPessoais dadosPessoais;
    private Endereco endereco;
    private Long idCargo;
    private DadosFinanceiro dadosFinanceiro;

}
