package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.OrderDto;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.form.salvar.PedidoFormFull;
import br.com.udemy.Spring.FullStack.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Rest Controller de Order
 */
@RestController
@RequestMapping("order")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    /**
     * Busca uma Order por id
     * @param id - Recebe o id de quem deve ser pesquisado
     * @return - Retorna um OrderDto
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable UUID id){
        OrderDto orderDto = orderService.findById(id);
        return ResponseEntity.ok(orderDto);
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@Valid @RequestBody PedidoFormFull pedidoFormFull){
        orderService.saveOrder(pedidoFormFull);
        return ResponseEntity.ok().build();
    }
}
