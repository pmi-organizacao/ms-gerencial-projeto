package com.recursos.humanos.aplicacao.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarStatusResponse {

    private String statusRequisicao;
    private Boolean statusAnteriorCargo;
    private Boolean statusAtualCargo;

    public static AlterarStatusResponse alterarStatusDePara(Boolean statusAnterior, Boolean statusAtual) {
        return AlterarStatusResponse.builder()
                .statusRequisicao("Status foi alterado com sucesso")
                .statusAnteriorCargo(statusAnterior)
                .statusAtualCargo(statusAtual)
                .build();
    }

    public static AlterarStatusResponse statusNaoAtualizadoPorqueEIgualAoAnterior(Boolean status) {
        return AlterarStatusResponse.builder()
                .statusRequisicao("Status não foi alterado pois é o mesmo do anterior.")
                .statusAnteriorCargo(status)
                .statusAtualCargo(status)
                .build();
    }
}
