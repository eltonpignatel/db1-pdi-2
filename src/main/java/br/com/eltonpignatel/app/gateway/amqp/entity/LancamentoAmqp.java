package br.com.eltonpignatel.app.gateway.amqp.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LancamentoAmqp {
    Integer usuario;
    Double valor;
    String descricao;
    Integer numeroParcelas;
}
