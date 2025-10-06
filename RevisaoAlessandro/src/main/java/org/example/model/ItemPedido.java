package org.example.model;

import javax.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "item_menu_id")
    private ItemMenu itemMenu;

    @Column
    private int quantidade;

    @Column
    private Double precoUnitario;
}
