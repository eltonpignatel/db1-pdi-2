package br.com.eltonpignatel.app.http.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.http.domain.request.LancamentoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.app.http.LancamentoWS;
import br.com.eltonpignatel.app.http.domain.response.LancamentoResponse;
import br.com.eltonpignatel.app.http.domain.response.ProcessaParcelasResponse;
import br.com.eltonpignatel.app.service.impl.LancamentoServiceImpl;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class LancamentoWSImpl implements LancamentoWS {

	@Autowired
	LancamentoServiceImpl lancamentoService;
	
	@GetMapping("listTransactions")  
	public List<LancamentoResponse> listaLancamentos() {

		List<LancamentoResponse> lancamentosResponse = new ArrayList<>();
		List<Lancamento> lancamentos = lancamentoService.findAll();
		
		lancamentos.forEach( lancamento -> lancamentosResponse.add(new LancamentoResponse(lancamento)));

		return lancamentosResponse
				.stream()
				.sorted((lancamentoResponse1, lancamentoResponse2) -> lancamentoResponse2.getId()
						.compareTo(lancamentoResponse1.getId())).
				collect(Collectors.toList());
	}

	@PostMapping("processTransactions")
	public ProcessaParcelasResponse processaParcelas( @RequestBody LancamentoRequest lancamento) {
		String retorno = lancamentoService.processaLancamentos(lancamento.getDescricao(), lancamento.getUsuario(), lancamento.getValor(), lancamento.getNroParcelas(), lancamento.getDataVencimento());
		ProcessaParcelasResponse processaParcelasResponse = new ProcessaParcelasResponse();
		processaParcelasResponse.setMensagem(retorno);
		return processaParcelasResponse;
	}

	@PostMapping("processTransactionsAsync")
	public ProcessaParcelasResponse processaParcelasAsync(@RequestBody LancamentoAmqp lancamentoAmqp) {

		String retorno = lancamentoService.processaLancamentosAsync(lancamentoAmqp);
		ProcessaParcelasResponse processaParcelasResponse = new ProcessaParcelasResponse();
		processaParcelasResponse.setMensagem(retorno);
		return processaParcelasResponse;
	}
	
}