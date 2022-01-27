package br.com.udemy.Spring.FullStack.resources;


import br.com.udemy.Spring.FullStack.dto.ProductFindSalesDto;
import br.com.udemy.Spring.FullStack.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * RestController para Product
 */
@RestController
@RequestMapping(value = "product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    /**
     * Controller para buscar informações no banco de dados
     * @param nameProduct - Recebe o nome do produto
     * @param listCategory - Recebe uma lista de categorias para ser pesquisada no banco de dados
     * @param page - Qual a página que quero mostrar
     * @param linesPerPage - Quantidade de registro por página
     * @param orderBy - Ordenação qual campo
     * @param direction - Ascendente e Descendente
     * @return - retorna uma lista de ProductFindSalesDto
     */
    @GetMapping
    public ResponseEntity<Page<ProductFindSalesDto>> findProductPerNameAndCategory(
            @RequestParam(value="nameProduct", defaultValue = "") String nameProduct,
            @RequestParam(value="listCategory", defaultValue = "") String listCategory,
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<ProductFindSalesDto> pageListProductFindSalesDtos = productService.findProductByNameAndCategory(nameProduct,
                listCategory,page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok(pageListProductFindSalesDtos);
    }
}
