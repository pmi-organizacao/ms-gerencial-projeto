package com.recursos.humanos.aplicacao.dto.request.cargo;

import com.recursos.humanos.aplicacao.dominio.Cargo;
import com.recursos.humanos.aplicacao.dominio.DadosFinanceiro;
import com.recursos.humanos.aplicacao.dominio.DadosPessoais;
import com.recursos.humanos.aplicacao.dominio.Endereco;
import com.recursos.humanos.aplicacao.dto.request.colaborador.DadosParaContatoRquest;
import com.recursos.humanos.aplicacao.dto.request.colaborador.DadosPessoaisRequest;
import com.recursos.humanos.aplicacao.dto.request.colaborador.TelefoneRequest;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorRequest {

    private DadosPessoaisRequest dadosPessoais;
    private Endereco endereco;
    private Long idCargo;
    private DadosFinanceiro dadosFinanceiro;
    private DadosParaContatoRquest dadosContato;

}
