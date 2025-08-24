package model.dao;

import java.util.ArrayList;

import model.Curso;

public class DaoCurso {
	private static ArrayList<Curso> ListaDeCurso;

	static {
		DaoCurso.ListaDeCurso = new ArrayList<Curso>();
	}

	public boolean adicionar(Curso novo) {
		return DaoCurso.ListaDeCurso.add(novo);
	}

	public ArrayList<Curso> obterTodos() {
		return new ArrayList(DaoCurso.ListaDeCurso);
	}
}
