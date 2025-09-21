package model;

import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "projetos")
    private Set<Empregado> empregados = new HashSet<>();

    public Projeto() {
        super();
    }

    public Projeto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Empregado> getEmpregados() {
        return empregados;
    }

    // Métodos auxiliares para manter consistência
    public void adicionarEmpregado(Empregado e) {
        empregados.add(e);
        e.getProjetos().add(this);
    }

    public void removerEmpregado(Empregado e) {
        empregados.remove(e);
        e.getProjetos().remove(this);
    }

    @Override
    public String toString() {
        return nome;
    }
}
