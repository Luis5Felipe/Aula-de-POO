package controller;

import javax.swing.JOptionPane;

import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
	
	private JanelaPrincipal janelaPrincipal;
	private CtrlIncluirAluno ctrlIncluirAluno;
	private CtrlIncluirCurso ctrlIncluirCurso;
	
	public CtrlPrograma() {
		super(null);
		this.janelaPrincipal = new JanelaPrincipal(this);
		this.janelaPrincipal.apresentar();
	}
	
	
	public void iniciarIncluirCurso() {
		if(this.ctrlIncluirCurso == null)
			this.ctrlIncluirCurso = new CtrlIncluirCurso(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}
	
	public void incluirCursoFinalizado() {
		this.ctrlIncluirCurso = null;		
	}
	
	public void iniciarIncluirAluno() {
		if(this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}
	
	public void incluirAlunoFinalizado() {
		this.ctrlIncluirAluno = null;		
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
