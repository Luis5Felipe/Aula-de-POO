package controller;

import javax.swing.JOptionPane;

import viewer.JanelaPrincipal;

public class CtrlPrograma {
	private JanelaPrincipal janelaPrincipal;
	private CtrlIncluirAluno ctrlIncluirAluno;
	private CtrlIncluirCurso ctrlIncluirCurso;
	
	public CtrlPrograma() {
		this.janelaPrincipal = new JanelaPrincipal(this);
		this.janelaPrincipal.setVisible(true);
	}
	
	
	public void iniciarIncluirCurso() {
		if(this.ctrlIncluirCurso == null)
			this.ctrlIncluirCurso = new CtrlIncluirCurso(this);
		else
			JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
	}
	
	public void incluirCursoFinalizado() {
		this.ctrlIncluirCurso = null;		
	}
	
	public void iniciarIncluirAluno() {
		if(this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
		else
			JOptionPane.showMessageDialog(null, "Este Caso de Uso já está em execução!");
	}
	
	public void incluirAlunoFinalizado() {
		this.ctrlIncluirAluno = null;		
	}
	
	public void fecharPrograma() {
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		new CtrlPrograma();
	}
}
