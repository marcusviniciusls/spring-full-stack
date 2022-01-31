package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    /**
     * Busca Cliente pelo o e-mail
     * @param email - Parametro do cliente que foi passado por e-mail
     * @return - retorna o cliente encontrado pelo o e-mail
     */
    Client findByEmail(String email);

    /**
     * Busca todos os cliente que não estejam marcado como excluídos
     * @param pageable - Objeto de ordernação e paginação
     * @return - retorna um Page de Client
     */
    @Query("SELECT c FROM Client c WHERE c.status = true")
    Page<Client> findByAllClientAtivo(Pageable pageable);

    /**
     * Consulta que busca um cliente por cpf
     * @param cpf - recebe o cpf por parametro
     * @return - retorna um cliente
     */
    @Query("SELECT c FROM Client c WHERE c.cpf = :cpf AND c.status = true")
    Optional<Client> findByClientPerCpf(@Param("cpf") String cpf);

    /**
     * Cpnsulta e busca um cliente por cnpj
     * @param cnpj - recebe o cnpj por parametro
     * @return - retorna um cliente
     */
    @Query("SELECT c FROM Client c WHERE c.cnpj = :cnpj AND c.status = true")
    Optional<Client> findByClientPerCnpj(@Param("cnpj") String cnpj);

}
