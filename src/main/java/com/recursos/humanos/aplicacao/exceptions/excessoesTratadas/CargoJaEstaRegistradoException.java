package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.CargoExceptions;

public class CargoJaEstaRegistradoException extends CargoExceptions {

    private static final long serialVersionUID = 1L;

    public CargoJaEstaRegistradoException(String message) {
        super(message);
    }
}
