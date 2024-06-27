package com.recursos.humanos.aplicacao.processamento.atualizarCadastro;

import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.Colaborador;
import com.recursos.humanos.aplicacao.dominio.DadosTransfer;
import com.recursos.humanos.aplicacao.service.interfaces.DadosDeProjetoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@NoArgsConstructor
public class AtualizarDadosProjeto extends ProcessarColaborador{

    @Autowired
    private DadosDeProjetoService dadosDeProjetoService;



    @Override
    public Boolean processarMensagem(DadosTransfer dadosTransfer) {
        System.out.println("Entrou no processar mensagem: " + dadosTransfer);
        Colaborador colaborador = dadosDeProjetoService.atualizarInformacoesDoDadosDeProjeto(dadosTransfer.getIdColaborador(),
                EStatusProjeto.ALOCADO,
                dadosTransfer.getIdProjeto());
        System.out.println(colaborador);
        return Objects.nonNull(colaborador);
    }

    @Override
    public boolean isDeveProcessar(DadosTransfer dadosTransfer) {
        Boolean atualizar = dadosTransfer.getProcessoExecutar().equals("ATUALIZAR");
        System.out.println("Vai processar o ATUALIZAR PROJETO: "+ atualizar);
        return atualizar;
    }
}
