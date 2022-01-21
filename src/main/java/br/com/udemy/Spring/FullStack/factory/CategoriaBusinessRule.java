package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Categoria;
import br.com.udemy.Spring.FullStack.domain.Produto;
import br.com.udemy.Spring.FullStack.dto.CategoriaDto;
import br.com.udemy.Spring.FullStack.dto.ProdutoDto;
import br.com.udemy.Spring.FullStack.form.CategoriaForm;

import java.util.List;

public class CategoriaBusinessRule {

    public static Categoria convertCategoriaFormInCategoria(CategoriaForm categoriaForm){
        String nomeCategoria = categoriaForm.getNome();
        Categoria categoria = new Categoria(nomeCategoria);

        return categoria;
    }

    public static CategoriaDto convertCategoriaInCategoriaDto(Categoria categoria){
        CategoriaDto categoriaDto = new CategoriaDto(categoria.getNome());
        categoriaDto.setId(categoria.getUuid());
        List<Produto> listProduto = categoria.getListaProdutos();
        for(Produto produto : listProduto){
            ProdutoDto produtoDto = ProdutoBusinessRule.convertProdutoInProdutoDto(produto);
            categoriaDto.addListProdutoDto(produtoDto);
        }

        return categoriaDto;
    }
}