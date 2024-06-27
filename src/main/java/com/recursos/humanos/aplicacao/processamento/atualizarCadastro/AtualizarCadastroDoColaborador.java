package com.recursos.humanos.aplicacao.processamento.atualizarCadastro;

import com.recursos.humanos.aplicacao.dominio.DadosTransfer;
import org.springframework.stereotype.Service;

@Service
public class AtualizarCadastroDoColaborador {

    public Boolean executar (DadosTransfer dadosTransfer) {
        ProcessarColaborador processarColaborador = new AtualizarDadosProjeto();


        return processarColaborador.executarProcesso(dadosTransfer);
    }
}
