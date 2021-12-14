package br.com.eltonpignatel.app.service;

import br.com.eltonpignatel.app.exceptions.UsuarioNotFound;
import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import br.com.eltonpignatel.app.gateway.database.repository.LancamentoRepository;
import br.com.eltonpignatel.app.gateway.database.repository.UsuarioRepository;
import br.com.eltonpignatel.app.service.impl.UsuarioServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    LancamentoRepository lancamentoRepository;

    @Spy
    @InjectMocks
    UsuarioServiceImpl service;

    @Test
    public void shouldSearchForUserData() throws UsuarioNotFound {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Exemplo");

        Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(usuario));
        service.buscarDadosUsuario(1L);

        Assertions.assertNotNull(usuario);
        Assertions.assertEquals("Exemplo", usuario.getNome());
    }

    @Test
    public void shouldThrowUserNotFoundWhenSearchForUserData() throws UsuarioNotFound {
        Usuario usuario = new Usuario();
        usuario.setId(10L);
        usuario.setNome("Exemplo");

        Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(UsuarioNotFound.class, ()  -> service.buscarDadosUsuario(1L));
    }
}
