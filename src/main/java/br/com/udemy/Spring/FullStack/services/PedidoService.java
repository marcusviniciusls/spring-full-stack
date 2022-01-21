package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Pedido;
import br.com.udemy.Spring.FullStack.dto.PedidoDao;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.PedidoBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDao findById(UUID id){
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isEmpty()){
            throw new ResourceNotFoundException("Id Pedido Não Encontrado");
        }
        Pedido pedido = optionalPedido.get();
        return PedidoBusinessRule.convertPedidoDao(pedido);
    }
}
