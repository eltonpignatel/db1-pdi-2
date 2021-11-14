package br.com.eltonpignatel.app.http;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.eltonpignatel.app.http.domain.response.UsuarioResponse;

public interface UsuarioWS {
	List<UsuarioResponse> listaUsuarios();
}