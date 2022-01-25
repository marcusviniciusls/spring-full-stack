package br.com.udemy.Spring.FullStack.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe principal que possui campo em comum para todas as tabelas do banco de dados
 */
@MappedSuperclass
public class SuperEntity {

    // Atributos
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private boolean status;

    // Construtores
    public SuperEntity() {
        uuid = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        dateCreation = now;
        status = true;
    }

    // Métodos Gets e Sets
    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
