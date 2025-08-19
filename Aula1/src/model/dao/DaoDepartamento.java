package model.dao;

import java.util.ArrayList;

import model.Departamento;

public class DaoDepartamento {
	private static ArrayList<Departamento> ListaDepartamento;
	
	static{
		DaoDepartamento.ListaDepartamento = new ArrayList<Departamento>();
	}
	
	public boolean adicionar(Departamento novo) {
		return DaoDepartamento.ListaDepartamento.add(novo);
	}
	
	public ArrayList<Departamento> obterTodos(){
		return new ArrayList(DaoDepartamento.ListaDepartamento);
	}
}
