package br.com.udemy.Spring.FullStack.repositorys;

import br.com.udemy.Spring.FullStack.domain.City;
import br.com.udemy.Spring.FullStack.domain.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    @Query("SELECT c FROM City c WHERE c.status = true ORDER BY c.name")
    Page<City> findByAllCityOrderByName(Pageable pageable);

    @Query("SELECT c FROM City c INNER JOIN State s ON c.state = s.uuid WHERE c.status = true AND s.uf = :state ORDER BY c.name")
    Page<City> findByAllCityPerStateOrderByName(@Param("state") String nameState, Pageable pageable);
}
