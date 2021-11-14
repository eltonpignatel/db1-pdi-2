package br.com.eltonpignatel.app.http.domain.response;

import java.util.Calendar;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
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
public class UsuarioResponse {
	Long id;
	String nome;
	Calendar dataCadastro;
	
	public UsuarioResponse(Usuario usuario)  {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.dataCadastro = usuario.getDataCadastro();
	}
}
