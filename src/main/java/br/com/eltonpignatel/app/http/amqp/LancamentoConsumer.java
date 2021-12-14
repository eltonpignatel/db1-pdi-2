package br.com.eltonpignatel.app.http.amqp;

import br.com.eltonpignatel.app.config.RabbitConfig;
import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.service.impl.LancamentoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@Slf4j
public class LancamentoConsumer {

    @Autowired
    LancamentoServiceImpl lancamentoService;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void consumeMessageFromQueue(LancamentoAmqp lancamentoAmqp) throws InterruptedException {
        log.info("Mensagem recebida da fila: {}",lancamentoAmqp);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.debug(e.getMessage());
            throw new InterruptedException();
        }

        String resultado = lancamentoService.processaLancamentos(lancamentoAmqp.getDescricao(), lancamentoAmqp.getUsuario(), lancamentoAmqp.getValor(), lancamentoAmqp.getNumeroParcelas(), Calendar.getInstance());

        log.info("Resultado do processamento do LancamentoConsumer {}",resultado);
    }
}
