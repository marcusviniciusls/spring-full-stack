package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;

@Table
@Entity(name = "telephones")
public class Telephone extends SuperEntity {

    private String ddd;
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Telephone(String ddd, String telephone) {
        this.ddd = ddd;
        this.telephone = telephone;
    }
    
    public Telephone(){}

    public String getDdd() {
        return ddd;
    }

    public String getTelephone() {
        return telephone;
    }

    public Client getClient() {
       return client;
    }

   public void setClient(Client client) {
       this.client = client;
   }

}
