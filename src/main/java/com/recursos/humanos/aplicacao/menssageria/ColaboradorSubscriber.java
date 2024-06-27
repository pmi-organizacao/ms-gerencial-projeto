package com.recursos.humanos.aplicacao.menssageria;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recursos.humanos.aplicacao.Enum.EStatusProjeto;
import com.recursos.humanos.aplicacao.dominio.DadosTransfer;
import com.recursos.humanos.aplicacao.service.interfaces.DadosDeProjetoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ColaboradorSubscriber {

//    @Autowired
//    private AtualizarCadastroDoColaborador atualizarCadastroDoColaborador;
//
    @Autowired
    private DadosDeProjetoService dadosDeProjetoService;

    @RabbitListener(queues = "${mq.queues.atualizar-colaborador}")
    public void recebendoMensagens(@Payload String payload) {


        var mapper = new ObjectMapper();
        try {
            DadosTransfer dadosTransfer = mapper.readValue(payload, DadosTransfer.class);
            System.out.println(dadosTransfer.toString());
            if (dadosTransfer.getProcessoExecutar().equals("ATUALIZAR")) {
                dadosDeProjetoService.atualizarInformacoesDoDadosDeProjeto(dadosTransfer.getIdColaborador(),
                        EStatusProjeto.ALOCADO,
                        dadosTransfer.getIdProjeto());
                System.out.println("Mensagem foi processada.");

            };
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao consumir");
            throw new RuntimeException(e);
        }
    }


}
