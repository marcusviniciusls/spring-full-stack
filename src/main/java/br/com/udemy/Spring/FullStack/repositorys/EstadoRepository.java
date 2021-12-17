package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstadoRepository extends JpaRepository<Estado, UUID> {
}
