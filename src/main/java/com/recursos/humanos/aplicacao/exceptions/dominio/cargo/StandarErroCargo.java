package com.recursos.humanos.aplicacao.exceptions.dominio.cargo;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandarErroCargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
