package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.OrderItem;
import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.OrderItemDto;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import org.aspectj.weaver.ast.Or;

/**
 * Classe com regras de negócios de OrderItem
 */
public class OrderItemBusinessRule {

    /**
     * Função que conver OrderItem em OrderItemDro
     * @param orderItem - Recebe um objeto do tipo OrderItem
     * @return - Retorna um OrderItemDto
     */
    public static OrderItemDto convertOrderItemInOrderItemDto(OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setDiscount(orderItem.getDiscount());
        orderItemDto.setTotalPrice(orderItem.getTotalPrice());
        orderItemDto.setUnityPrice(orderItem.getUnityPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        ProductDto productDto = ProductBusinessRule.convertProductInProductDto(orderItem.getProduct());
        orderItemDto.setProductDto(productDto);

        return orderItemDto;
    }
}
