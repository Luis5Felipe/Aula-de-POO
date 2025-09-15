package controller;

import controller.cursos.CtrlManterCursos;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {

	private JanelaPrincipal janelaPrincipal;
	private CtrlManterCursos ctrlManterCursos;
	private CtrlIncluirAluno ctrlIncluirEAluno;

	public CtrlPrograma() {
		super(null);
		this.janelaPrincipal = new JanelaPrincipal(this);
		this.janelaPrincipal.apresentar();
	}

	public void iniciarManterCursos() {
		if (this.ctrlManterCursos == null)
			this.ctrlManterCursos = new CtrlManterCursos(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}

	public void manterCursosFinalizado() {
		this.ctrlManterCursos = null;
	}

	public void iniciarIncluirAluno() {
		if (this.ctrlIncluirEAluno == null)
			this.ctrlIncluirEAluno = new CtrlIncluirAluno(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}

	public void incluirAlunoFinalizado() {
		this.ctrlIncluirEAluno = null;
	}

	public void encerrar() {
		System.exit(0);
	}

	public Object getBemTangivel() {
		return null;
	}

	public static void main(String[] args) throws Exception {
		new CtrlPrograma();
	}
}
