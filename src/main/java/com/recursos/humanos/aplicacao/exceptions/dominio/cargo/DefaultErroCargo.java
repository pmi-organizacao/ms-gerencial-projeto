package com.recursos.humanos.aplicacao.exceptions.dominio.cargo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DefaultErroCargo {
    private int code;
    private String menssage;
}
