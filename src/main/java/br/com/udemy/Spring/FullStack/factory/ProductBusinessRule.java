package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.ProductDto;

public class ProductBusinessRule {

    public static ProductDto convertProdutoInProdutoDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());

        return productDto;
    }
}
