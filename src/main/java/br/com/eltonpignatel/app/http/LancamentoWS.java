package br.com.eltonpignatel.app.http;

import java.util.List;
import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.http.domain.request.LancamentoRequest;
import br.com.eltonpignatel.app.http.domain.response.LancamentoResponse;
import br.com.eltonpignatel.app.http.domain.response.ProcessaParcelasResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;

@Api(tags="Lancamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public interface LancamentoWS {

	@ApiOperation(value="Lista todos os lancamentos")
	List<LancamentoResponse> listaLancamentos();

	@ApiOperation(value="Processa os lancamentos de maneira sincrona")
	ProcessaParcelasResponse processaParcelas(LancamentoRequest lancamento);

	@ApiOperation(value="Processa os lancamentos de maneira assincrona")
	ProcessaParcelasResponse processaParcelasAsync(LancamentoAmqp lancamentoAmqp);
}