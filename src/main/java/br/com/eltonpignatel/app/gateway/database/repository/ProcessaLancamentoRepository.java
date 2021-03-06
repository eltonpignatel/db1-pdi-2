package br.com.eltonpignatel.app.gateway.database.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;

public interface ProcessaLancamentoRepository {
	
	public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas, Calendar vencimento);
	public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas);
}