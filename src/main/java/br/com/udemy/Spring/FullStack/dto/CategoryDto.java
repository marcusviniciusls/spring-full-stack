package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Classe Data Transfer Object (Dto) para a entidade Category
 */
public class CategoryDto {

    // Atributos
    private UUID id;
    private String name;

    private List<ProductDto> listProductDto = new ArrayList<>();

    // Construtores
    public CategoryDto(String category) {
        this.name = category;
    }

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ProductDto> getListProductDto() {
        return listProductDto;
    }

    public void addListProdutoDto(ProductDto productDto){
        this.listProductDto.add(productDto);
    }


}
