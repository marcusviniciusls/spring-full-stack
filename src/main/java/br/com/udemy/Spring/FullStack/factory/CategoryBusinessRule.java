package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Category;
import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import br.com.udemy.Spring.FullStack.form.atualizar.CategoryRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.CategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que contém regras de negócios para a entidade Category
 */
@Service
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
        CategoryDto categoryDto = new CategoryDto(category.getNome());
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
        categoryBank.setNome(categoryNew.getNameCategory());
        return categoryBank;
    }

    /**
     * Função que recebe uma String de categorias unificadas e demembra em uma única lista
     * @param listCategory - Recebe uma String com todas as Categorias unificadas
     * @return - retorna uma lista de cateogrias em lista
     */
    public static List<String> decodeCategoryString(String listCategory){
        List<String> listCategoryName = new ArrayList<>();
        String[] vetor = listCategory.split(",");
        for(int i = 0; i <vetor.length; i++){
            listCategoryName.add(vetor[i]);
        }
        return listCategoryName;
    }
}
