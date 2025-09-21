package controller.cursos;

import controller.CtrlAbstrato;
import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class CtrlIncluirCurso extends CtrlAbstratoCursos {
	
	public CtrlIncluirCurso(CtrlAbstrato c) {
		super(c);
	}
	
	public void efetuar(int id, String nome) {
		try {
			this.curso = new Curso(id,nome);
			DaoCurso dao = new DaoCurso();
			dao.adicionar(this.curso);
			this.janela.notificar("Curso Criado Criado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
}
