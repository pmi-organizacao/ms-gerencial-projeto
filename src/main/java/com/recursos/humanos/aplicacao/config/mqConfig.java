package com.recursos.humanos.aplicacao.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mqConfig {

    @Value("${mq.queues.adicionar-colaborador}")
    private String novoCliente;

    @Bean
    public Queue queueAddColaborador() {
        return new Queue(novoCliente, true);
    }

}
