package br.com.eltonpignatel.app.gateway.amqp.entity;

import lombok.*;

import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LancamentoAmqp {
    Long usuario;
    Double valor;
    String descricao;
    Integer numeroParcelas;
    Calendar dataVencimento;
}
