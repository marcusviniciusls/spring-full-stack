package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.PedidoDao;
import br.com.udemy.Spring.FullStack.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("pedido")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDao> findById(@PathVariable UUID id){
        //UUID id = UUID.fromString(idString);
        PedidoDao pedidoDao = pedidoService.findById(id);
        return ResponseEntity.ok(pedidoDao);
    }
}
