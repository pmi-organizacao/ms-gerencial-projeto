package com.recursos.humanos.aplicacao.Enum.eexceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EDescError {

    MENSSAGEM_ERRO_PADRAO(1L, "Exception de sistema ainda nao especializada."),
    MENSSAGEM_DADO_JA_EXISTENTE(2L, "Dado inserido já existe no banco de dados."),
    MENSSAGEM_DADO_NAO_ENCONTRADO(3L, "Objeto não encontrado."),
    NAO_FOI_POSSIVEL_EXCEUTAR_MQ(4L, "Não foi possivel adicionar tarefa na fila.");

    private Long numerador;
    private String descricao;
}
