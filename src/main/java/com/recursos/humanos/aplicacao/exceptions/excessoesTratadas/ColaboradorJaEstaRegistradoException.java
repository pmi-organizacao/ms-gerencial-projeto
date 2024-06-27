package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.CargoExceptions;
import com.recursos.humanos.aplicacao.exceptions.excessoes.ColaboradorExceptions;

public class ColaboradorJaEstaRegistradoException extends ColaboradorExceptions {

    private static final long serialVersionUID = 1L;

    public ColaboradorJaEstaRegistradoException(String message) {
        super(message);
    }
}
