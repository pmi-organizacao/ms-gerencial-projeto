package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.CargoExceptions;

public class CargoNaoEncontradoExceptions extends CargoExceptions {

    private static final long serialVersionUID = 1L;

    public CargoNaoEncontradoExceptions(String message) {
        super(message);
    }
}
