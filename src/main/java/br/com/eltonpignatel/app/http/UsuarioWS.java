package br.com.eltonpignatel.app.http;

import java.util.List;

import br.com.eltonpignatel.app.http.domain.response.UsuarioDadosResponse;
import br.com.eltonpignatel.app.http.domain.response.UsuarioResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;

@Api(tags="Usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UsuarioWS {

	@ApiOperation(value="Lista os usuários")
	List<UsuarioResponse> listaUsuarios();

	@ApiOperation(value="Lista os usuários com os dados de lançamento vinculados")
	UsuarioDadosResponse usuarioDados(Long id);

	@ApiOperation(value="Exibe os usuários que não tiveram lançamentos nos ultimos x meses")
	List<UsuarioResponse> usuariosInativosPorMes(int meses);
}