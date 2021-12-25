package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class SuperEntidade {
    
    @Id
    private UUID uuid;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private boolean ativo;

    public SuperEntidade() {
        uuid = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        dataCriacao = now;
        ativo = true;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "SuperEntidade{" +
                "uuid=" + uuid +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", ativo=" + ativo +
                '}';
    }
}
