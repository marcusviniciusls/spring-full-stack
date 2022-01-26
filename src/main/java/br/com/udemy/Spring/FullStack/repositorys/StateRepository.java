package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<State, UUID> {

    @Query("SELECT s FROM State s WHERE s.uf = :uf")
    Optional<State> findByUf(String uf);
}
