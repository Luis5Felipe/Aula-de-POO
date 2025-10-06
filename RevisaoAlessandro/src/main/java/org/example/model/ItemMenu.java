package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemMenu {
    @Id @GeneratedValue
    private int id;
    @Column(length = 40)
    private String nome;
    @Column
    private Double precoAtual;
    @Column(length = 100)
    private String descricao;

    @OneToMany(mappedBy = "itemMenu")
    private List<ItemPedido> itensPedido;
}
