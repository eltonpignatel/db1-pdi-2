package br.com.eltonpignatel.app.service;

import java.util.Calendar;
import java.util.List;

import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;

public interface LancamentosService {
	List<Lancamento> findAll();
	String processaLancamentos(String descricao, Long Usuario, Double valor, Integer numeroParcelas, Calendar vencimento);
	String processaLancamentosAsync(LancamentoAmqp lancamento);
}
