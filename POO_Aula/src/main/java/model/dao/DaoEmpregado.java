package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Empregado;

public class DaoEmpregado {
	//
	// ATRIBUTO DE ACESSO AO JPA
	//
	private static EntityManager entityManager = CtrlPrograma.entityManager;
	
	//
	// MÉTODOS
	//	
	public boolean adicionar(Empregado novo) {
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

	public boolean alterar(Empregado emp) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(emp);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean excluir(Empregado ex) {
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

	public Empregado[] obterTodos() {
		Query query = entityManager.createQuery("SELECT e FROM Empregado e");
		List<Empregado> resultado  = query.getResultList();
		Empregado[] retorno = new Empregado[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
