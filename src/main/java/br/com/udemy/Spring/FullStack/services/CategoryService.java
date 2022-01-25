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

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryDto findById(UUID id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()){
            throw new ResourceNotFoundException("Category Not Found");
        }
        Category category = categoryOptional.get();
        CategoryDto categoryDto = CategoryBusinessRule.convertCategoriaInCategoriaDto(category);

        return categoryDto;
    }

    public CategoryDto saveCategory(CategoryForm categoriaForm){
        Category category = CategoryBusinessRule.convertCategoriaFormInCategoria(categoriaForm);
        categoryRepository.save(category);
        return CategoryBusinessRule.convertCategoriaInCategoriaDto(category);
    }

    public void updateCategory(UUID id, CategoryRefresh categoryRefresh){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()){
            throw new ResourceNotFoundException("Category Not Found");
        }
        Category category = optionalCategory.get();
        Category categorySave = CategoryBusinessRule.atualizarCategoria(category, categoryRefresh);
        categoryRepository.save(categorySave);
    }

    public void deteleById(UUID id){
        categoryRepository.deleteById(id);
    }

    public Page<CategoryDto> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        Page<CategoryDto> listCategoryDto = listCategory.map(CategoryBusinessRule::convertCategoriaInCategoriaDto);
        return listCategoryDto;
    }
}
