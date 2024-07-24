package com.recursos.humanos.aplicacao.dto.request.colaborador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneRequest {
    private String dd;
    private String numeroContato;
    private String descricaoNumero;
}
