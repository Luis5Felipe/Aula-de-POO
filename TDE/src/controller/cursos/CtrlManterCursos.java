package controller.cursos;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import model.Curso;
import model.dao.DaoCurso;
import viewer.JanelaConsultarCursos;

public class CtrlManterCursos extends CtrlAbstrato {
	
	private JanelaConsultarCursos janela;
	private CtrlAbstratoCursos    ctrlCurso;

	public CtrlManterCursos(CtrlAbstrato ctrlPai) {
		super(ctrlPai);
		DaoCurso dao = new DaoCurso();
		Curso[] conjCursos = dao.obterTodos();
		this.janela = new JanelaConsultarCursos(this, conjCursos);
		this.janela.setVisible(true);
	}

	public void iniciarIncluirCurso() {
		this.ctrlCurso = new CtrlIncluirCurso(this);
	}

	
	public void iniciarAlterarDepartamento(Curso CursoSelecionado) {
		if (CursoSelecionado == null)
			this.janela.notificar("Selecione um Curso para alteração");
		else
			this.ctrlCurso = new CtrlAlterarCursos(this, CursoSelecionado);
	}

	public void iniciarExcluirDepartamento(Curso CursoSelecionado) {
		if (CursoSelecionado == null)
			this.janela.notificar("Selecione um departamento para exclusão");
		else
			this.ctrlCurso = new CtrlExcluirCursos(this, CursoSelecionado);
	}

	public void fimEditarDepartamento() {
		this.ctrlCurso = null;
		DaoCurso dao = new DaoCurso();
		Curso[] conjCursos = dao.obterTodos();
		this.janela.atualizarDados(conjCursos);
	}

	@Override
	public void encerrar() {
		this.janela.fechar();
		CtrlPrograma ctrl = (CtrlPrograma) getCtrlpai();
		ctrl.manterCursosFinalizado();
	}

	@Override
	public Object getBemTangivel() {
		DaoCurso dao = new DaoCurso();
		return dao.obterTodos();
	}

}
