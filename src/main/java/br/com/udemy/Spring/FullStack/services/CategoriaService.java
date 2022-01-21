package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.dto.CategoriaDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.CategoriaBusinessRule;
import br.com.udemy.Spring.FullStack.form.CategoriaForm;
import br.com.udemy.Spring.FullStack.repositorys.CategoriaRepository;
import br.com.udemy.Spring.FullStack.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public CategoriaDto buscarCategoria(UUID id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        Categoria categoria = categoriaOptional.get();
        CategoriaDto categoriaDto = CategoriaBusinessRule.convertCategoriaInCategoriaDto(categoria);

        return categoriaDto;
    }

    public CategoriaDto salvarCategoria(CategoriaForm categoriaForm){
        Categoria categoria = CategoriaBusinessRule.convertCategoriaFormInCategoria(categoriaForm);
        categoriaRepository.save(categoria);
        return CategoriaBusinessRule.convertCategoriaInCategoriaDto(categoria);
    }
}
