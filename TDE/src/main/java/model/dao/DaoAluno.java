package model.dao;

import controller.CtrlPrograma;
import model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

public class DaoAluno {
	private static EntityManager entityManager = CtrlPrograma.entityManager;

	public boolean adicionar(Aluno novo) {
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

	public boolean alterar(Aluno aluno) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(aluno);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean excluir(Aluno ex) {
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

	public Aluno[] obterTodos() {
		Query query = entityManager.createQuery("SELECT e FROM Aluno e");
		List<Aluno> resultado  = query.getResultList();
		Aluno[] retorno = new Aluno[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
