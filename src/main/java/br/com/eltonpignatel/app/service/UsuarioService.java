package br.com.eltonpignatel.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
}
