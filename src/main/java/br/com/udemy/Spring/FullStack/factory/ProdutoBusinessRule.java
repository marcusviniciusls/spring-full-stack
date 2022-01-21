package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Produto;
import br.com.udemy.Spring.FullStack.dto.ProdutoDto;

public class ProdutoBusinessRule {

    public static ProdutoDto convertProdutoInProdutoDto(Produto produto){
        ProdutoDto produtoDto = new ProdutoDto();

        produtoDto.setNome(produto.getNome());
        produtoDto.setPreco(produto.getPreco());

        return produtoDto;
    }
}
