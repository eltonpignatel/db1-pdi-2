package br.com.eltonpignatel.app.http.amqp;

import br.com.eltonpignatel.app.config.RabbitConfig;
import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LancamentoConsumer {
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void consumeMessageFromQueue(LancamentoAmqp lancamentoAmqp) {
        System.out.println("Message recieved from queue : " + lancamentoAmqp);
    }
}
