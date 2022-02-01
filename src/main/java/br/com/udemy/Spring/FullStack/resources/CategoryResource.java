package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;
import br.com.udemy.Spring.FullStack.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

/**
 * Controller Category
 */
@RestController
@RequestMapping(value="category")
public class CategoryResource {

    // Atributos
    @Autowired
    private CategoryService categoryService;

    /**
     * Método para buscar todas as categorias do Banco de Dados
     * @param page - Qual a página que quero mostrar
     * @param linesPerPage - Quantidade de registro por página
     * @param orderBy - Ordenação qual campo
     * @param direction - Ascendente e Descendente
     * @return - retorna uma lista de CategoryDto
     */
    @GetMapping
    public ResponseEntity<Page<CategoryDto>>
    findByAll(@RequestParam(value="page", defaultValue = "0") Integer page,
              @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
              @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
                      @RequestParam(value="direction", defaultValue = "DESC") String direction){
        Page<CategoryDto> listCategoryDto = categoryService.findAll(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listCategoryDto);
    }

    /**
     * Metódo que busca Category por ID
     * @param id - Id para ser buscado
     * @return - Retorna a Category encontrada
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        CategoryDto categoryDto = categoryService.findById(id);
        return ResponseEntity.ok().body(categoryDto);
    }

    /**
     * Método Post para salvar uma Category
     * @param categoryForm - Traz as informações da nova Category do Banco de Dados
     * @param uriComponentsBuilder - Monta o caminho para resposta
     * @return - retorna a categoryDto criada
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryForm categoryForm, UriComponentsBuilder uriComponentsBuilder){
        CategoryDto categoryDto = categoryService.saveCategory(categoryForm);
        URI uri = uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(categoryDto.getName()).toUri();
        return ResponseEntity.created(uri).body(categoryDto);
    }

    /**
     * Método que atualiza uma Category por id
     * @param id - Recebe o id para identificar qual o método que tem que atualizar
     * @param categoryRefresh - Recebe quais informações deve ser atualizado
     * @return - retorna positivo caso seja completo
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable UUID id, @Valid @RequestBody CategoryRefresh categoryRefresh){
        categoryService.updateCategory(id,categoryRefresh);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deleta uma Category por id
     * @param id - Recebe o id da Category que tem que atualizar
     * @return - retorna um ok caso de certo
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        categoryService.deteleById(id);
        return ResponseEntity.ok().build();
    }

}
                                                                                                     