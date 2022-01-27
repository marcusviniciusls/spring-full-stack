package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Category;
import br.com.udemy.Spring.FullStack.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    //@Query("SELECT p FROM Product p INNER JOIN Category c ON p.category = c.uuid " +
            //"WHERE p.name LIKE '%:nameProduct%' AND IN (:listCategory)")
    //List<Product> findByProductPerNameAndPerCategory(String nameProduct, List<Category> listCategory);
}
