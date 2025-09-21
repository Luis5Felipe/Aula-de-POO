package controller.projeto;

import model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class CtrlManterProjetos {
    private final List<Projeto> projetos = new ArrayList<>();

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void incluirProjeto(String nome, String descricao) {
        projetos.add(new Projeto(nome, descricao));
    }

    public void alterarProjeto(Projeto p, String novoNome, String novaDescricao) {
        p.setNome(novoNome);
        p.setDescricao(novaDescricao);
    }

    public void excluirProjeto(Projeto p) {
        projetos.remove(p);
    }
}
