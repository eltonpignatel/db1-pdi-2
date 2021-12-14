package br.com.eltonpignatel.app.gateway.database.repository;

import java.util.List;

import br.com.eltonpignatel.app.gateway.database.entity.Usuario;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eltonpignatel.app.gateway.database.entity.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	@NotNull List<Lancamento> findAll();
	List<Lancamento> findByUsuario(Usuario usuario);
}