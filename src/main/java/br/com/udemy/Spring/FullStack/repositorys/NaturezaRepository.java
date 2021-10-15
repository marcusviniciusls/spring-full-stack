package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Natureza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturezaRepository extends JpaRepository<Natureza, Integer> {
}
