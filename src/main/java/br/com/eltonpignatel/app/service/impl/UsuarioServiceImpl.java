package br.com.eltonpignatel.app.service.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import br.com.eltonpignatel.app.gateway.database.repository.UsuarioRepository;
import br.com.eltonpignatel.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}
	
}
