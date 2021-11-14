package br.com.eltonpignatel.app.service;

import java.util.List;

import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;

public interface LancamentosService {
	List<Lancamento> findAll();
	String processaLancamentos(String descricao, Long Usuario, Long valor, Integer numeroParcelas);
}
