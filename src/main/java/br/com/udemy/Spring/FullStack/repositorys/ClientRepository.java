package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    /**
     * Busca Cliente pelo o e-mail
     * @param email - Parametro do cliente que foi passado por e-mail
     * @return - retorna o cliente encontrado pelo o e-mail
     */
    Client findByEmail(String email);

    @Query("SELECT c FROM Client c WHERE c.status = true")
    Page<Client> findByAllClientAtivo(Pageable pageable);

}
