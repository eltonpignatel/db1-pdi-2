package br.com.eltonpignatel.app.http.domain.response;

import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import lombok.*;

import java.util.Calendar;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UsuarioDadosResponse {
	Long id;
	String nome;
	Calendar dataCadastro;
	List<Lancamento> lancamentos;

	public UsuarioDadosResponse(Usuario usuario, List<Lancamento> lancamentos)  {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.dataCadastro = usuario.getDataCadastro();
		this.lancamentos = lancamentos;


	}
}
