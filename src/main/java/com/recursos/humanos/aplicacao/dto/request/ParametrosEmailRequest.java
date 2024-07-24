package com.recursos.humanos.aplicacao.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrosEmailRequest {

    private String nomeParticipante;
    private String login;
    private String senha;

}
