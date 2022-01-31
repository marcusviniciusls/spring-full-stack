package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Consulta para trazer todos os produtos com base em um nome e em uma lista de categorias
     * @param nameProduct - Recebe o nome do produto
     * @param listNameCategory - recebe uma lista de categorias
     * @param pageable - recebe a paginação e ordenação dos dados
     * @return - retorna a lista de produtos pesquisado no banco de dados
     */
    @Query("SELECT p FROM Product p INNER JOIN Category c " +
            "ON p.category = c.uuid " +
            "WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%',:nome,'%')) AND c.nome in :listNameCategory AND p.status = true" +
            " AND c.status = true")
    Page<Product> findProductNamePerCategory(@Param("nome") String nameProduct,
                                             @Param("listNameCategory") List<String> listNameCategory, Pageable pageable);
}
