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
	
	public boolean alterar(Curso curso) {
		if(DaoCurso.ListaDeCurso.contains(curso))
			return true;
		return false;
	}
	
	public boolean excluir(Curso novo) {
		return DaoCurso.ListaDeCurso.remove(novo);
	}

	public Curso[] obterTodos() {
		int qtde = DaoCurso.ListaDeCurso.size();
		Curso[] copia = new Curso[qtde];
		int i = 0;
		for(Curso d : DaoCurso.ListaDeCurso)
			copia[i++] = d;
		return copia;
	}
}
