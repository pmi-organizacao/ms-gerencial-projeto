package com.recursos.humanos.aplicacao.dto.request.colaborador;

import com.recursos.humanos.aplicacao.dominio.DadosFinanceiro;
import com.recursos.humanos.aplicacao.dominio.DadosPessoais;
import com.recursos.humanos.aplicacao.dominio.DadosProjetos;
import com.recursos.humanos.aplicacao.dominio.Endereco;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorReuqestDadosProjetoRequest {

    private DadosPessoais dadosPessoais;
    private Endereco endereco;
    private Long idCargo;
    private DadosFinanceiro dadosFinanceiro;
    private DadosProjetos dadosProjetos;
}
