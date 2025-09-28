//Luis Felipe Dos Santos

package org.example.model;

import org.example.model.exception.ModelException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    public final static int TAMANHO_MAX_NOME = 40;
    public final static int TAMANHO_MAX_TELEFONE = 20;
    public final  static int TAMANHO_CPF = 14;

    @Id
    @GeneratedValue
    private int id;
    @Column(length = TAMANHO_CPF)
    private String cpf;

    @Column(length = TAMANHO_MAX_NOME)
    private String nome;

    @Column(length = TAMANHO_MAX_TELEFONE)
    private String telefone;

    @OneToMany(mappedBy = "vendedor")
    private List<OfertaImovel> ofertasComoVendedor = new ArrayList<>();


    @OneToMany(mappedBy = "comprador")
    private List<OfertaImovel> compras = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "interesse",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "oferta_id"))
    private List<OfertaImovel> interesses = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(String cpf, String nome, String telefone) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setTelefone(telefone);
    }


    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        validarTelefone(telefone);
        this.telefone = telefone;
    }

    public List<OfertaImovel> getOfertasComoVendedor() {
        return ofertasComoVendedor;
    }

    public List<OfertaImovel> getCompras() {
        return compras;
    }

    public List<OfertaImovel> getInteresses() {
        return interesses;
    }

    public static void validarCpf(String cpf) throws ModelException {
        if (cpf == null || cpf.isEmpty())
            throw new ModelException("O cpf do empregado não pode ser nulo!");
        String expRegular = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
        if(!cpf.matches(expRegular))
            throw new ModelException("O cpf passado é inválido!");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isEmpty())
            throw new ModelException("O nome do empregado não pode ser nulo!");
        String expRegular = "[A-Za-zÀ-ÿ ]{5," + TAMANHO_MAX_NOME + "}";
        if(!nome.matches(expRegular))
            throw new ModelException("O nome passado é inválido!");
    }

    public static void validarTelefone(String telefone) throws ModelException {
        if (telefone == null || telefone.isEmpty())
            throw new ModelException("O número de telefone do Cliente não pode ser nulo!");
        String expRegular = "\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}-[0-9]{4}$";
        if(!telefone.matches(expRegular))
            throw new ModelException("O número de telefone passado é inválido!");
    }

}