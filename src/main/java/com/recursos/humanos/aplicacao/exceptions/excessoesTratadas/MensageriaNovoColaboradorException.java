package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.ColaboradorExceptions;

public class MensageriaNovoColaboradorException extends ColaboradorExceptions {
    private static final long serialVersionUID = 1L;
    public MensageriaNovoColaboradorException(String message) {
        super(message);
    }
}
