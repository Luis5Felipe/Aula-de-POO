package org.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id @GeneratedValue
    private int id;
    @Column
    private Date dataDahora;
    @Column
    private Double valorTotal;

    @ManyToOne(fetch=FetchType.LAZY)
    private Cliente clientes;

    @ManyToOne(fetch=FetchType.LAZY)
    private Endereco enderecos;

    @OneToMany(fetch=FetchType.LAZY)
    private List<ItemPedido> itemPedidos;

    public Pedido() {
        super();
    }

    public Pedido(Double valorTotal, Date dataDahora) {
        this.valorTotal = valorTotal;
        this.dataDahora = dataDahora;
    }
}
