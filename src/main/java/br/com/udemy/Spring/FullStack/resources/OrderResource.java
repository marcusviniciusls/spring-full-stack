package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.domain.Pedido;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.dto.OrderDto;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.form.salvar.PedidoFormFull;
import br.com.udemy.Spring.FullStack.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public ResponseEntity<Page<OrderDto>>
    findByAll(@RequestParam(value="page", defaultValue = "0") Integer page,
              @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
              @RequestParam(value="orderBy", defaultValue = "dataCriacao") String orderBy,
              @RequestParam(value="direction", defaultValue = "DESC") String direction){
        Page<OrderDto> listOrderDto = orderService.findByClient(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listOrderDto);
    }
}
