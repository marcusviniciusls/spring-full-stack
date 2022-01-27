package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import br.com.udemy.Spring.FullStack.dto.ProductFindSalesDto;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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

        productDto.setName(product.getNome());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    /**
     * Convert um Product em ProductFindSalesDto
     * @param product - recebe um produto do Banco de Dados
     * @return - retorna um ProductFindSalesDto
     */
    public static ProductFindSalesDto convertProductInProductFindSalesDto(Product product){
        ProductFindSalesDto productFindSalesDto = new ProductFindSalesDto();

        productFindSalesDto.setName(product.getNome());
        productFindSalesDto.setPrice(product.getPrice());

        return productFindSalesDto;
    }

    /**
     * Faz o tratamento do decode de uma String
     * @param param - recebe uma string para decodificar
     * @return - retorna a String decodificada
     */
    public static String decodeParam(String param){
        try{
           return URLDecoder.decode(param,"UTF-8");
        } catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
