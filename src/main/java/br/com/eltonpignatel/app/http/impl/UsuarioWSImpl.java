package br.com.eltonpignatel.app.http.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import br.com.eltonpignatel.app.http.UsuarioWS;
import br.com.eltonpignatel.app.http.domain.response.UsuarioResponse;
import br.com.eltonpignatel.app.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/users")
public class UsuarioWSImpl implements UsuarioWS {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@GetMapping("listUsers")  
	public List<UsuarioResponse> listaUsuarios() {
		
		List<UsuarioResponse> usuariosResponse = new ArrayList<UsuarioResponse>();
		List<Usuario> usuarios = usuarioService.findAll();
		
		usuarios.stream().forEach( usuario -> {
			usuariosResponse.add(new UsuarioResponse(usuario));
		});
		
		return usuariosResponse;
	}
	
}
