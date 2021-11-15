package br.com.eltonpignatel.app.gateway.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import br.com.eltonpignatel.app.config.RabbitConfig;

@Component
public class LancamentoPublisher implements RabbitSender{

    @Override
    public void send(RabbitTemplate rabbitTemplate, Object lancamentoAmqp) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, lancamentoAmqp);
    }
}
