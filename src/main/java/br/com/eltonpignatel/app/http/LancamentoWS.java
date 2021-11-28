package br.com.eltonpignatel.app.http;

import java.util.List;
import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.http.domain.request.LancamentoRequest;
import br.com.eltonpignatel.app.http.domain.response.LancamentoResponse;
import br.com.eltonpignatel.app.http.domain.response.ProcessaParcelasResponse;

public interface LancamentoWS {
	List<LancamentoResponse> listaLancamentos();
	ProcessaParcelasResponse processaParcelas(LancamentoRequest lancamento);
	ProcessaParcelasResponse processaParcelasAsync(LancamentoAmqp lancamentoAmqp);
}