package br.com.eltonpignatel.app.service.impl;

import java.util.Calendar;
import java.util.List;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.eltonpignatel.app.gateway.amqp.LancamentoPublisher;
import br.com.eltonpignatel.app.gateway.amqp.entity.LancamentoAmqp;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.app.gateway.database.repository.LancamentoRepository;
import br.com.eltonpignatel.app.gateway.database.repository.ProcessaLancamentoRepository;
import br.com.eltonpignatel.app.service.LancamentosService;

@Service
public class LancamentoServiceImpl implements LancamentosService{

	@Autowired
	private ProcessaLancamentoRepository processaLancamentoRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private LancamentoPublisher lancamentoPublisher;

	@Override
	public List<Lancamento> findAll() {
		return lancamentoRepository.findAll();
	}

	@Override
	public List<Lancamento> findByUsuario(Usuario usuario) {
		return lancamentoRepository.findByUsuario(usuario);
	}

	@Override
	public String processaLancamentos(String descricao, Long usuario, Double valor, Integer numeroParcelas, Calendar vencimento) {
		if (vencimento != null ) {
			return processaLancamentoRepository.processaLancamentos(descricao, usuario, valor, numeroParcelas,  vencimento);
		} else {
			return processaLancamentoRepository.processaLancamentos(descricao, usuario, valor, numeroParcelas);
		}
	}

	@Override
	public String processaLancamentosAsync(LancamentoAmqp lancamentoAmqp) {
		lancamentoPublisher.send(rabbitTemplate,lancamentoAmqp);
		return "Incluído na fila";
	}
}