package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Category;
import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;

import java.util.List;

/**
 * Classe que contém regras de negócios para a entidade Category
 */
public class CategoryBusinessRule {

    /**
     * Converte o objeto do tipo de CategoryForm em Category
     * @param categoryForm - recebe um objeto de categoryForm que vem de fora da API
     * @return - retorna um objeto do tipo Category
     */
    public static Category convertCategoryFormInCategory(CategoryForm categoryForm){
        String nameCategory = categoryForm.getName();
        Category category = new Category(nameCategory);

        return category;
    }

    /**
     * Converte um objeto do tipo Category em CategoryDto
     * @param category - Recebe um objeto do tipo Category
     * @return - Retorna um objeto do tipo CategoryDto
     */
    public static CategoryDto convertCategoryInCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto(category.getName());
        categoryDto.setId(category.getUuid());
        List<Product> listProduct = category.getListProduct();
        for(Product product : listProduct){
            ProductDto productDto = ProductBusinessRule.convertProductInProductDto(product);
            categoryDto.addListProdutoDto(productDto);
        }
        return categoryDto;
    }

    /**
     * Atualiza o nome da Categoria
     * @param categoryBank - Recebe um objeto do tipo Category que venho do Banco
     * @param categoryNew - Recebe um objeto do tipo CategoryRefresh que venho de fora da API
     * @return - Retorna o objeto atualizado
     */
    public static Category updateCategory(Category categoryBank, CategoryRefresh categoryNew){
        categoryBank.setName(categoryNew.getNameCategory());
        return categoryBank;
    }
}
