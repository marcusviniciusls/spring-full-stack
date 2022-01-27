package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.ProductFindSalesDto;
import br.com.udemy.Spring.FullStack.factory.CategoryBusinessRule;
import br.com.udemy.Spring.FullStack.factory.ProductBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Função na camada de serviço para buscar todos os produtos por nome e lista de categorias
     * @param nameProduct - Recebe o nome do produto
     * @param listCategory - Recebe uma lista de categorias para ser pesquisada no banco de dados
     * @param page - Qual a página que quero mostrar
     * @param linesPerPage - Quantidade de registro por página
     * @param orderBy - Ordenação qual campo
     * @param direction - Ascendente e Descendente
     * @return - retorna uma lista de ProductFindSalesDto
     */
    public Page<ProductFindSalesDto> findProductByNameAndCategory(String nameProduct, String listCategory,
    Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        List<String> listNameCategory = CategoryBusinessRule.decodeCategoryString(listCategory);
        String nameProductTratado = ProductBusinessRule.decodeParam(nameProduct);
        Page<Product> pageListProduct = productRepository.findProductNamePerCategory(nameProductTratado,listNameCategory,pageable);
        Page<ProductFindSalesDto> pageListProductFindSalesDto = pageListProduct.map(ProductBusinessRule::convertProductInProductFindSalesDto);
        return pageListProductFindSalesDto;
    }
}
