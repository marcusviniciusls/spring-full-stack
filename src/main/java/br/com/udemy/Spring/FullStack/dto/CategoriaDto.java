package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaDto {
    
    @Autowired
    private CategoriaService categoriaService;
    
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
    
    public String converteCategoriaToCategoriaDto(Integer id){
        this.categoria = categoriaService.buscarCategoria(id).getNome();
        return this.categoria;
    }
}
