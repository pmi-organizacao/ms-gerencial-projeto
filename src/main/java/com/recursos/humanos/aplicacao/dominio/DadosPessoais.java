package com.recursos.humanos.aplicacao.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais {

    private String nomeCompleto;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String email;

}
