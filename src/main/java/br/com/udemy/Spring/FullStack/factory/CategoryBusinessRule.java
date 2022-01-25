package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Category;
import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;

import java.util.List;

public class CategoryBusinessRule {

    public static Category convertCategoriaFormInCategoria(CategoryForm categoriaForm){
        String nameCategory = categoriaForm.getName();
        Category categoria = new Category(nameCategory);

        return categoria;
    }

    public static CategoryDto convertCategoriaInCategoriaDto(Category category){
        CategoryDto categoryDto = new CategoryDto(category.getName());
        categoryDto.setId(category.getUuid());
        List<Product> listProduct = category.getListProduct();
        for(Product product : listProduct){
            ProductDto productDto = ProductBusinessRule.convertProdutoInProdutoDto(product);
            categoryDto.addListProdutoDto(productDto);
        }
        return categoryDto;
    }

    public static Category atualizarCategoria(Category categoryBank, CategoryRefresh categoryNew){
        categoryBank.setName(categoryNew.getNameCategory());
        return categoryBank;
    }
}
