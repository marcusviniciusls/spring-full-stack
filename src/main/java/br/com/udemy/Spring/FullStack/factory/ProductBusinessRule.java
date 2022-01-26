package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import org.springframework.stereotype.Service;

/**
 * Classe que contém regras de negócios para a entidade Product
 */
@Service
public class ProductBusinessRule {

    /**
     * Método que converte o objeto do tipo Product em ProductDto
     * @param product - Recebe um objeto do tipo Product
     * @return - Retorna um objeto do tipo ProductDto
     */
    public static ProductDto convertProductInProductDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());

        return productDto;
    }
}
