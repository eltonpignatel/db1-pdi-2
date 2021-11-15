package br.com.eltonpignatel.app.gateway.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface RabbitSender {
    public void send(RabbitTemplate rabbitTemplate, Object obj);
}
