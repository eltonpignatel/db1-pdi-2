package br.com.eltonpignatel.app.http;

import java.util.List;

import br.com.eltonpignatel.app.http.domain.response.LancamentoResponse;
import br.com.eltonpignatel.app.http.domain.response.ProcessaParcelasResponse;

public interface LancamentoWS {
	List<LancamentoResponse> listaLancamentos();
	ProcessaParcelasResponse processaParcelas(String descricao, Long Usuario, Long valor, Integer numeroParcelas);
}