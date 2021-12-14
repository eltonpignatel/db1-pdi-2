package br.com.eltonpignatel.app.service.impl;

import java.util.List;
import br.com.eltonpignatel.app.exceptions.UsuarioNotFound;
import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;
import br.com.eltonpignatel.app.gateway.database.repository.LancamentoRepository;
import br.com.eltonpignatel.app.http.domain.response.UsuarioDadosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import br.com.eltonpignatel.app.gateway.database.repository.UsuarioRepository;
import br.com.eltonpignatel.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	LancamentoRepository lancamentoRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioDadosResponse buscarDadosUsuario(Long id) throws UsuarioNotFound {

		UsuarioDadosResponse usuarioResponse = new UsuarioDadosResponse();
		Usuario usuarioDados = usuarioRepository.findById(id).stream().findFirst().orElseThrow( () -> new UsuarioNotFound(id));

		usuarioResponse.setId(usuarioDados.getId());
		usuarioResponse.setNome(usuarioDados.getNome());
		usuarioResponse.setDataCadastro(usuarioDados.getDataCadastro());

		List <Lancamento> lancamentos;
		lancamentos = lancamentoRepository.findByUsuario(usuarioDados);
		lancamentos.forEach(lancamento -> lancamento.setUsuario(null));

		usuarioResponse.setLancamentos(lancamentos);

		return usuarioResponse;
	}

	@Override
	public List<Usuario> usuariosInativosPorMes(int meses) {
		return usuarioRepository.usuariosInativosPorMes(meses);
	}

}
