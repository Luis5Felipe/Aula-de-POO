package model.dao;

import java.util.ArrayList;
import java.util.List;

import controller.CtrlPrograma;
import model.Curso;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class DaoCurso {
	private static EntityManager entityManager = CtrlPrograma.entityManager;

	public boolean adicionar(Curso novo) {
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

	public boolean alterar(Curso depto) {
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

	public boolean excluir(Curso ex) {
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

	public Curso[] obterTodos() {
		Query query = entityManager.createQuery("SELECT d FROM Curso d");
		List<Curso> resultado  = query.getResultList();
		Curso[] retorno = new Curso[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
