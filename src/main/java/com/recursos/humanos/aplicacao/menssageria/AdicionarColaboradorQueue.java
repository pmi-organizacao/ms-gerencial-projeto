package com.recursos.humanos.aplicacao.menssageria;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recursos.humanos.aplicacao.exceptions.excessoesTratadas.MensageriaNovoColaboradorException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarColaboradorQueue {


    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCanalColaborador;

    public void novoColaboradorAdicionado (DadosTransferenciaAddColaboradorQueue queue)  {
        String json = null;
        try {
            json = convertToJson(queue);
            rabbitTemplate.convertAndSend(queueCanalColaborador.getName(), json);
        } catch (JsonProcessingException e) {
            throw new MensageriaNovoColaboradorException("Não foi possivel adicionar colaborador na fila  "+ e.getMessage());
        }
    }

    private String convertToJson(DadosTransferenciaAddColaboradorQueue queue) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(queue);
        return json;
    }
}
