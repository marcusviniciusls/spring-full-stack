package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.dto.EnderecoDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "pedidos")
public class Pedido extends SuperEntidade{

    private LocalDate data = LocalDate.now();
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> listaItemPedidos = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    public Pedido(){}

    public Pedido(Endereco endereco) {
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "data=" + data +
                ", listaItemPedidos=" + listaItemPedidos +
                ", endereco=" + endereco +
                '}';
    }
}
