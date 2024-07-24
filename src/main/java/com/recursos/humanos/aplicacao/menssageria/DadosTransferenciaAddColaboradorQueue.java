package com.recursos.humanos.aplicacao.menssageria;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosTransferenciaAddColaboradorQueue {

    private Long id;
    private String nomeCompleto;
    private String nomeCargo;
    private String email;


}
