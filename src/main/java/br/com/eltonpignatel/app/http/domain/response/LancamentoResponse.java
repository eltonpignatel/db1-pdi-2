package br.com.eltonpignatel.app.http.domain.response;

import java.util.Calendar;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class LancamentoResponse {

	Long id;
	String descricao;
	Double valor;
	Long usuario;
	Calendar dataVencimeto;
	Calendar dataCadastro;

	public LancamentoResponse(Lancamento lancamento) {
		super();
		this.id = lancamento.getId();
		this.descricao = lancamento.getDescricao();
		this.valor = lancamento.getValor();
		this.usuario = lancamento.getUsuario().getId();
		this.dataVencimeto = lancamento.getDataVencimeto();
		this.dataCadastro = lancamento.getDataCadastro();
	}
}

