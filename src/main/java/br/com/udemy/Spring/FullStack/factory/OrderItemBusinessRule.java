package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.OrderItem;
import br.com.udemy.Spring.FullStack.domain.Product;
import br.com.udemy.Spring.FullStack.dto.OrderItemDto;
import br.com.udemy.Spring.FullStack.dto.ProductDto;
import br.com.udemy.Spring.FullStack.form.salvar.OrderItemForm;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;

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

        orderItemDto.setTotalPrice(orderItem.getTotalPrice());
        orderItemDto.setUnityPrice(orderItem.getUnityPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        ProductDto productDto = ProductBusinessRule.convertProductInProductDto(orderItem.getProduct());
        orderItemDto.setProductDto(productDto);

        return orderItemDto;
    }

    public static BigDecimal getSubTotalOrderItem(Integer quantity, BigDecimal priceUnit){
        return priceUnit.multiply(BigDecimal.valueOf(quantity));
    }

    public static OrderItem convertPedidoFormFullInOrderItem(OrderItemForm orderItemForm, Product product){
        OrderItem orderItem = new OrderItem();

        orderItem.setQuantity(orderItemForm.getQuantity());
        orderItem.setProduct(product);
        orderItem.setUnityPrice(product.getPrice());
        BigDecimal valueTotal = product.getPrice().multiply(BigDecimal.valueOf(orderItemForm.getQuantity()));
        orderItem.setTotalPrice(valueTotal);
        product.addItemPedido(orderItem);

        return orderItem;
    }
}
