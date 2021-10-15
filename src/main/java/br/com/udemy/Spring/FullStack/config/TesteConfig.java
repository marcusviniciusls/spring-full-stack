package br.com.udemy.Spring.FullStack.config;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        Categoria categoria = new Categoria("Informática");
        Categoria categoria1 = new Categoria("Escritório");
        
        categoriaRepository.saveAll(Arrays.asList(categoria,categoria1));      
        
    }
}
