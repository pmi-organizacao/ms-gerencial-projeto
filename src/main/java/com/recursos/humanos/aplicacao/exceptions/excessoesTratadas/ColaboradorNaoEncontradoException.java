package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.ColaboradorExceptions;

public class ColaboradorNaoEncontradoException extends ColaboradorExceptions {

    private static final long serialVersionUID = 1L;

    public ColaboradorNaoEncontradoException(String message) {
        super(message);
    }
}
