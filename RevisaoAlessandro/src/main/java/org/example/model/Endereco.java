package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Endereco {
    @Id @GeneratedValue
    private int id;

    @Column(length = 40)
    private String logradouro;

    @ManyToMany(mappedBy ="enderecos")
    private List <Cliente> clientes;

    @OneToMany(mappedBy = "endereco")
    private List <Pedido> pedidos;

    public Endereco() {
        super();
    }

    public Endereco(String logradora) {
        this.logradora = logradora;
    }
}
