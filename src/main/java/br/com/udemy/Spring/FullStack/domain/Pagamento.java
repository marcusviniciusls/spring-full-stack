package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;

@Table
@Entity(name = "pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
}
