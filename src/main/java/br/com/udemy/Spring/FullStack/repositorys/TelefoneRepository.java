package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
