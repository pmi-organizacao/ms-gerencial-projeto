package com.recursos.humanos.aplicacao.processamento.atualizarCadastro;

import com.recursos.humanos.aplicacao.dominio.DadosTransfer;
import com.recursos.humanos.aplicacao.dto.response.AlterarStatusResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public abstract class ProcessarColaborador {


    public Boolean executarProcesso(DadosTransfer dadosTransfer) {
        if (isDeveProcessar(dadosTransfer)) {
            System.out.println("Entrou para processar a mensagem");
            return processarMensagem(dadosTransfer);
        }
        return false;
    }

    public abstract Boolean processarMensagem(DadosTransfer dadosTransfer);
    public abstract boolean isDeveProcessar(DadosTransfer dadosTransfer);

}
