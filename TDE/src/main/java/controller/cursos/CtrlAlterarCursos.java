package controller.cursos;

import controller.CtrlAbstrato;
import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class CtrlAlterarCursos  extends CtrlAbstratoCursos{

	public CtrlAlterarCursos(CtrlAbstrato c, Curso curso) {
		super(c, curso);
	}
	
	public void efetuar(int id, String nome) {
		try {
			this.curso.setCodigo(id);
			this.curso.setNome(nome);
			DaoCurso dao = new DaoCurso();
			dao.alterar(this.curso);
			this.janela.notificar("Curso Alterado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
}
