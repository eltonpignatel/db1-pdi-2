package br.com.eltonpignatel.app.service;

import java.util.List;
import br.com.eltonpignatel.app.exceptions.UsuarioNotFound;
import br.com.eltonpignatel.app.http.domain.response.UsuarioDadosResponse;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public UsuarioDadosResponse buscarDadosUsuario(Long id) throws UsuarioNotFound;
	public List<Usuario> usuariosInativosPorMes(int meses);
}
