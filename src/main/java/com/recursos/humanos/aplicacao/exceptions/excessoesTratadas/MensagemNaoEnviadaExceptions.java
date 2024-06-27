package com.recursos.humanos.aplicacao.exceptions.excessoesTratadas;

import com.recursos.humanos.aplicacao.exceptions.excessoes.ColaboradorExceptions;

public class MensagemNaoEnviadaExceptions extends ColaboradorExceptions {

    private static final long serialVersionUID = 1L;

    public MensagemNaoEnviadaExceptions(String message) {
        super(message);
    }
}
