package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Endereco;
import br.com.udemy.Spring.FullStack.domain.Pedido;
import br.com.udemy.Spring.FullStack.dto.EnderecoDto;
import br.com.udemy.Spring.FullStack.dto.PedidoDao;

public class PedidoBusinessRule {

    public static PedidoDao convertPedidoDao(Pedido pedido){
        PedidoDao pedidoDao = new PedidoDao();

        pedidoDao.setData(pedido.getData());
        EnderecoDto enderecoDto = convertEnderecoDto(pedido.getEndereco());
        pedidoDao.setEndereco(enderecoDto);

        return pedidoDao;
    }

    private static EnderecoDto convertEnderecoDto(Endereco endereco){
        EnderecoDto enderecoDto = new EnderecoDto();

        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setLogadouro(endereco.getLogadouro());
        enderecoDto.setNumero(endereco.getNumero());

        return enderecoDto;
    }
}
