package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CategoriaDto {
    
    @Autowired
    private CategoriaService categoriaService;

    private UUID id;
    private String categoria;

    public CategoriaDto(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
