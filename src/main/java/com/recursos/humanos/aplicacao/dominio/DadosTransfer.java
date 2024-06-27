package com.recursos.humanos.aplicacao.dominio;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosTransfer {

    private Long idColaborador;
    private String idProjeto;
    private String processoExecutar;

}
