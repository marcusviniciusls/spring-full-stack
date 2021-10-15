package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="categories")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCategoriPorId(@PathVariable Integer id){
        Categoria categoria = categoriaService.buscarCategoria(id);
        return ResponseEntity.ok().body(categoria);
    }
}
