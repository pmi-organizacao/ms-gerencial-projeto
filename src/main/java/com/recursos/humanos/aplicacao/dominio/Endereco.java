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
public class Endereco {

    private String cep;
    private String rua;
    private String numero;
    private String uf;
    private String municipio;
    private String estado;
    private String complemento;

}
