package controller.cursos;

import controller.CtrlAbstrato;
import controller.CtrlIncluirAluno;
import model.Curso;
import viewer.JanelaCurso;

abstract public class CtrlAbstratoCursos extends CtrlAbstrato {
	protected JanelaCurso janela;
	protected Curso curso;

	public CtrlAbstratoCursos(CtrlAbstrato ctrlPai, Curso curso) {
		super(ctrlPai);
		this.curso = curso;
		this.janela = new JanelaCurso(this, curso);
		this.janela.apresentar();
	}

	public CtrlAbstratoCursos(CtrlAbstrato ctrlPai) {
		this(ctrlPai, null);
	}
	
	
	abstract public void efetuar(int id, String nome);
	
	public void encerrar() {
		this.janela.fechar();
		
		if (this.getCtrlpai() instanceof CtrlManterCursos) {
			CtrlManterCursos c = (CtrlManterCursos) this.getCtrlpai();
			c.fimEditarDepartamento();
		} else if (this.getCtrlpai() instanceof CtrlIncluirAluno) {
			CtrlIncluirAluno c = (CtrlIncluirAluno) this.getCtrlpai();
			c.incluirCursoFinalizado();
		}
	}
	
	public Object getBemTangivel() {
		return this.curso;
	}
}
