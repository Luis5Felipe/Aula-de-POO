//Luis Felipe Dos Santos

package org.example.model;

import org.example.model.utils.Tipo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Imovel {
    @Id
    @GeneratedValue()
    private int id;
    @Column(nullable = false, length = 200)
    private String endereco;
    @Column(columnDefinition = "TEXT", length = 250)
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Tipo tipoDeImovel;
    private Double area;


    @OneToMany(mappedBy = "imovel")
    private List<OfertaImovel> ofertas = new ArrayList<>();

    public Imovel() {
        super();
    }

    public Imovel(Double area, String descricao, String endereco, Tipo tipoDeImovel) {
        this.area = area;
        this.descricao = descricao;
        this.endereco = endereco;
        this.tipoDeImovel = tipoDeImovel;
    }

    public int getId() {
        return id;
    }

    public Tipo getTipo() {
        return tipoDeImovel;
    }

    public void setTipo(Tipo tipoDeImovel) {
        this.tipoDeImovel = tipoDeImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<OfertaImovel> getOfertas() {
        return ofertas;
    }
}
