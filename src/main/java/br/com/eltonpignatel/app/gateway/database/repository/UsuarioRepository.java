package br.com.eltonpignatel.app.gateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findAll();
}
