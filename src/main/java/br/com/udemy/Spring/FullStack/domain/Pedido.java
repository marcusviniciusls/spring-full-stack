package br.com.udemy.Spring.FullStack.domain;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data = LocalDate.now();
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> listaItemPedidos = new ArrayList<>();
    
    public Pedido(){}

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public List<ItemPedido> getListaItemPedidos() {
        return listaItemPedidos;
    }
    
    public void addListaItemPedidos(ItemPedido itemPedido){
        this.listaItemPedidos.add(itemPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
