package model.dao;

import java.util.ArrayList;

import model.Aluno;

public class DaoAluno {
	private static ArrayList<Aluno> ListaDeAluno;

	static {
		DaoAluno.ListaDeAluno = new ArrayList<Aluno>();
	}

	public boolean adicionar(Aluno novo) {
		return DaoAluno.ListaDeAluno.add(novo);
	}

	public ArrayList<Aluno> obterTodos() {
		return new ArrayList(DaoAluno.ListaDeAluno);
	}
}
