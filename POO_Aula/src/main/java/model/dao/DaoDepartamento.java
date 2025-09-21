package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Departamento;

public class DaoDepartamento {
	//
	// ATRIBUTO DE ACESSO AO JPA
	//
	private static EntityManager entityManager = CtrlPrograma.entityManager;
	
	//
	// MÉTODOS
	//	
	public boolean adicionar(Departamento novo) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(novo);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Departamento depto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(depto);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean excluir(Departamento ex) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(ex);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public Departamento[] obterTodos() {
		Query query = entityManager.createQuery("SELECT d FROM Departamento d");
		List<Departamento> resultado  = query.getResultList();
		Departamento[] retorno = new Departamento[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
