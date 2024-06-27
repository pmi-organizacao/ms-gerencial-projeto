package com.recursos.humanos.aplicacao.exceptions.excessoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CargoExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String message;

}
