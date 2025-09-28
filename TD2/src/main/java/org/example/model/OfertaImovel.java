//Luis Felipe Dos Santos

package org.example.model;

import org.example.model.utils.Situacao;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OfertaImovel {

    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false)
    private Double precoProposto;

    @Column(nullable = false)
    private Double percentualCorretagem;


    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private Double precoFinal;

    @ManyToOne
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;


    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Cliente vendedor;

    @ManyToOne
    @JoinColumn(name = "comprador_id", nullable = true)
    private Cliente comprador;


    @ManyToMany(mappedBy = "interesses")
    private List<Cliente> interessados = new ArrayList<>();

    public OfertaImovel() {
        super();
    }

    public OfertaImovel(Double precoProposto, Double percentualCorretagem,
                        Imovel imovel, Cliente vendedor, Situacao situacao) {
        this.precoProposto = precoProposto;
        this.percentualCorretagem = percentualCorretagem;
        this.imovel = imovel;
        this.vendedor = vendedor;
        this.situacao = situacao;
    }


    public int getId() {
        return id;
    }

    public Double getPrecoProposto() {
        return precoProposto;
    }

    public void setPrecoProposto(Double precoProposto) {
        this.precoProposto = precoProposto;
    }

    public Double getPercentualCorretagem() {
        return percentualCorretagem;
    }

    public void setPercentualCorretagem(Double percentualCorretagem) {
        this.percentualCorretagem = percentualCorretagem;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Cliente getVendedor() {
        return vendedor;
    }

    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<Cliente> getInteressados() {
        return interessados;
    }
}