package com.recursos.humanos.aplicacao.dominio;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosProjetos {

    private EStatusProjeto status;
    private String idProjeto;

    public static DadosProjetos construirDadosDeProjetoBasico() {
        return startDadosProjetos();
    }
    public static DadosProjetos resetDadosDeProjetoBasuci() {
        return startDadosProjetos();
    }
    private static DadosProjetos startDadosProjetos() {
        return DadosProjetos.builder()
                .status(EStatusProjeto.DISPONIVEL)
                .idProjeto(null)
                .build();
    }
}
