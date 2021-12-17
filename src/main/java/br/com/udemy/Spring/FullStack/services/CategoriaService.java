package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import br.com.udemy.Spring.FullStack.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria buscarCategoria(UUID id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
    }
}
