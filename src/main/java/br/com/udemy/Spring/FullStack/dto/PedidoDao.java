package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class PedidoDao {

    private LocalDate data;
    @JsonIgnore
    private EnderecoDto enderecoDto;

    public PedidoDao(LocalDate data, EnderecoDto enderecoDto) {
        this.data = data;
        this.enderecoDto = enderecoDto;
    }

    public PedidoDao(){}

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public EnderecoDto getEndereco() {
        return enderecoDto;
    }

    public void setEndereco(EnderecoDto enderecoDto) {
        this.enderecoDto = enderecoDto;
    }
}
