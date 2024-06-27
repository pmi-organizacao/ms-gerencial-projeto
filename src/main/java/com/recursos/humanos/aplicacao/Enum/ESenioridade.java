package com.recursos.humanos.aplicacao.Enum;

import lombok.Getter;

@Getter
public enum ESenioridade {

    SENIOR_3(1L, "Senior nivel 3"),
    SENIOR_2(2L, "Senior nivel 2"),
    SENIOR_1(3L, "Senior nivel 1"),
    PLENO_3(4L, "Pleno nivel 3"),
    PLENO_2(5L, "Pleno nivel 2"),
    PLENO_1(6L, "Pleno nivel 1"),
    JUNIOR_3(7L, "JUNIOR nivel 3"),
    JUNIOR_2(8L, "JUNIOR nivel 2"),
    JUNIOR_1(9L, "JUNIOR nivel 1"),
    GERENTE(10L, "Gerente"),
    ARQUITETO(11L, "Arquiteto"),
    DIRETOR(12L, "Direto"),
    ESTAGIARIO(13L, "Estagiario");

    private Long numerador;
    private String descricao;

    ESenioridade(Long numerador, String descricao) {
        this.numerador = numerador;
        this.descricao = descricao;
    }
}
