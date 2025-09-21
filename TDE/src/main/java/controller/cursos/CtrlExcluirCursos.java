package controller.cursos;

import controller.CtrlAbstrato;
import model.Curso;
import model.dao.DaoCurso;

public class CtrlExcluirCursos extends CtrlAbstratoCursos {
	public CtrlExcluirCursos(CtrlAbstrato c, Curso curso) {
		super(c, curso);
	}

	public void efetuar(int id, String nome) {
		DaoCurso dao = new DaoCurso();
		dao.excluir(this.curso);
		this.janela.notificar("Departamento Excluído!");
		this.encerrar();
	}
}

