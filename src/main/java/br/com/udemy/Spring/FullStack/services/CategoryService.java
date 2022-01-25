package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Category;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.CategoryBusinessRule;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;
import br.com.udemy.Spring.FullStack.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Regra de Negócio Centralizado: Category
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Busca Category por ID
     * @param id - Recebe o id para o Category pesquisado
     * @return - Retorna um CategoryDto
     */
    public CategoryDto findById(UUID id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()){
            throw new ResourceNotFoundException("Category Not Found");
        }
        Category category = categoryOptional.get();
        CategoryDto categoryDto = CategoryBusinessRule.convertCategoryInCategoryDto(category);

        return categoryDto;
    }

    /**
     * Salvar uma Category no Banco de Dados
     * @param categoriaForm - Recebe as informações para salvar
     * @return - Retorna um CategoryDto caso de certo
     */
    public CategoryDto saveCategory(CategoryForm categoriaForm){
        Category category = CategoryBusinessRule.convertCategoryFormInCategory(categoriaForm);
        categoryRepository.save(category);
        return CategoryBusinessRule.convertCategoryInCategoryDto(category);
    }

    /**
     * Atualizar um Category por id
     * @param id - Id do Category a ser atualizado
     * @param categoryRefresh - Informações para atualizar
     */
    public void updateCategory(UUID id, CategoryRefresh categoryRefresh){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()){
            throw new ResourceNotFoundException("Category Not Found");
        }
        Category category = optionalCategory.get();
        Category categorySave = CategoryBusinessRule.updateCategory(category, categoryRefresh);
        categoryRepository.save(categorySave);
    }

    /**
     * Deleta uma Category por id
     * @param id - Recebe o id do Category a ser excluído
     */
    public void deteleById(UUID id){
        categoryRepository.deleteById(id);
    }

    /**
     * Busca todos os Category do Banco de Dados
     * @param page - Qual a página motrar
     * @param linesPerPage Quantas linhas por página
     * @param orderBy - Qual campo será ordenado
     * @param direction - Qual direção ASC ou DESC
     * @return - Retorna uma Lista de CategoryDTO
     */
    public Page<CategoryDto> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        Page<CategoryDto> listCategoryDto = listCategory.map(CategoryBusinessRule::convertCategoryInCategoryDto);
        return listCategoryDto;
    }
}
