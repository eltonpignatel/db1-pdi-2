package br.com.eltonpignatel.app.http.domain.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class LancamentoRequest {

	Long id;

	@NotNull(message = "Descricao do lancamento nao pode ser nula")
	String descricao;
	Double valor;
	Long usuario;
	Calendar dataVencimento;
	Integer nroParcelas;
}

