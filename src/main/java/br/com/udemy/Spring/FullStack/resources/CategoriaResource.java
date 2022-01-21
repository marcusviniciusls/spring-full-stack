package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.dto.CategoriaDto;
import br.com.udemy.Spring.FullStack.form.CategoriaForm;
import br.com.udemy.Spring.FullStack.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value="categoria")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarCategoriPorId(@PathVariable UUID id){
        CategoriaDto categoriaDto = categoriaService.buscarCategoria(id);
        return ResponseEntity.ok().body(categoriaDto);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> salvarCategoria(@RequestBody CategoriaForm categoriaForm, UriComponentsBuilder uriComponentsBuilder){
        CategoriaDto categoriaDto = categoriaService.salvarCategoria(categoriaForm);
        URI uri = uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(categoriaDto.getCategoria()).toUri();
        return ResponseEntity.created(uri).body(categoriaDto);
    }
}
                                                                                                     