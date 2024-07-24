package com.recursos.humanos.aplicacao.dto.request.colaborador;

import com.recursos.humanos.aplicacao.dominio.DadosPessoais;
import com.recursos.humanos.aplicacao.dominio.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoaisRequest {

    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String email;

    public DadosPessoais construirDadosPessoais(List<TelefoneRequest> telefones) {
        DadosPessoais build = DadosPessoais.builder()
                .nomeCompleto(this.nomeCompleto)
                .cpf(this.cpf)
                .rg(this.rg)
                .dataNascimento(this.dataNascimento)
                .email(this.email)
                .build();
        return build;
    }

}
