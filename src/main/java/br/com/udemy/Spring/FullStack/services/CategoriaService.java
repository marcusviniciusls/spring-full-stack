package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria buscarCategoria(Integer id){
        Categoria categoria = categoriaRepository.findById(id).get();
        return categoria;
    }
}
