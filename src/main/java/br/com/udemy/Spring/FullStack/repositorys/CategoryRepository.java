package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    
}