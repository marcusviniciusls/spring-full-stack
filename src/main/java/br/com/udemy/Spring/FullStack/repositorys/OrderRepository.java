package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Pedido, UUID> {

    Page<Pedido> findByClient(Client client, Pageable pageable);
}
