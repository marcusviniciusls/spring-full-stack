package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;
import br.com.udemy.Spring.FullStack.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value="category")
public class CategoryResource {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDto>>
    findByAll(@RequestParam(value="page", defaultValue = "0") Integer page,
              @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
              @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
                      @RequestParam(value="direction", defaultValue = "DESC") String direction){
        Page<CategoryDto> listCategoryDto = categoryService.findAll(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listCategoryDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        CategoryDto categoryDto = categoryService.findById(id);
        return ResponseEntity.ok().body(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryForm categoryForm, UriComponentsBuilder uriComponentsBuilder){
        CategoryDto categoryDto = categoryService.saveCategory(categoryForm);
        URI uri = uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(categoryDto.getName()).toUri();
        return ResponseEntity.created(uri).body(categoryDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable UUID id, @Valid @RequestBody CategoryRefresh categoryRefresh){
        categoryService.updateCategory(id,categoryRefresh);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        categoryService.deteleById(id);
        return ResponseEntity.ok().build();
    }

}
                                                                                                     