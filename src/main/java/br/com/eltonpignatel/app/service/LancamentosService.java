package br.com.eltonpignatel.app.service;

import java.util.Calendar;
import java.util.List;

import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;

public interface LancamentosService {

	List<Lancamento> findAll();
	List<Lancamento> findByUsuario(Usuario usuario);
	String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas, Calendar vencimento);
	String processaLancamentosAsync(LancamentoAmqp lancamento);
}
