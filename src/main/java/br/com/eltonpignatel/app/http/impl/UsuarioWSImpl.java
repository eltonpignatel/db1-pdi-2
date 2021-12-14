package br.com.eltonpignatel.app.http.impl;

import java.util.ArrayList;
import java.util.List;
import br.com.eltonpignatel.app.exceptions.UsuarioNotFound;
import br.com.eltonpignatel.app.http.domain.response.UsuarioDadosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import br.com.eltonpignatel.app.http.UsuarioWS;
import br.com.eltonpignatel.app.http.domain.response.UsuarioResponse;
import br.com.eltonpignatel.app.service.impl.UsuarioServiceImpl;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UsuarioWSImpl implements UsuarioWS {
	
	@Autowired
	UsuarioServiceImpl usuarioService;

	@Override
	@GetMapping("listUsers")  
	public List<UsuarioResponse> listaUsuarios() {
		
		List<UsuarioResponse> usuariosResponse = new ArrayList<>();
		List<Usuario> usuarios = usuarioService.findAll();
		
		usuarios.forEach( usuario -> usuariosResponse.add(new UsuarioResponse(usuario)) );

		return usuariosResponse;
	}

	@Override
	@GetMapping("{id}/userData")
	public UsuarioDadosResponse usuarioDados(@PathVariable(value="id")  Long id) {
		try {
			return usuarioService.buscarDadosUsuario(id);
		} catch (UsuarioNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
		}
	}

	@Override
	@GetMapping("inactiveUsersPerMonth/{months}")
	public List<UsuarioResponse> usuariosInativosPorMes(@PathVariable(value="months") int meses) {
		List<Usuario> usuarios = usuarioService.usuariosInativosPorMes(meses);

		List<UsuarioResponse> usuariosResponse = new ArrayList<>();
		usuarios.forEach( usuario -> usuariosResponse.add(new UsuarioResponse(usuario)) );

		return usuariosResponse;
	}

}
