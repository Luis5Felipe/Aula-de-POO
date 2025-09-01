package controller;

import javax.swing.JOptionPane;

import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;
import viewer.JanelaCurso;

public class CtrlIncluirCurso {
	final private CtrlPrograma ctrlPai;
	private JanelaCurso janela;

	public CtrlIncluirCurso(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaCurso(this);
		this.janela.setVisible(true);
	}
	
	public void incluirNovoCurso(int codigo, String nome) {
		try {
			Curso novo = new Curso(codigo, nome);
			DaoCurso dao = new DaoCurso();
			dao.adicionar(novo);
			JOptionPane.showMessageDialog(null, "Curso Criado!");
			this.janela.setVisible(false);
			this.ctrlPai.incluirCursoFinalizado();
		} catch (ModelException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
	public void cancelarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.incluirCursoFinalizado();		
	}
}
