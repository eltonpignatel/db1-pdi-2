package br.com.eltonpignatel.app.gateway.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);

	@Query("SELECT u FROM Usuario u" +
			" WHERE not exists(SELECT 'x' " +
			"                    FROM Lancamento l" +
			"                   where u.id = l.usuario.id" +
			"                     and l.dataCadastro >= add_months(sysdate,:meses*-1))")
	List<Usuario> usuariosInativosPorMes(@Param("meses") int meses);
}