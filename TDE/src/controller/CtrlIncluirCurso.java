package controller;

import javax.swing.JOptionPane;

import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;
import viewer.JanelaCurso;

public class CtrlIncluirCurso  extends CtrlAbstrato{

	private JanelaCurso janela;
	private Curso novo;

	public CtrlIncluirCurso(CtrlAbstrato c) {
		super(c);
		this.janela = new JanelaCurso(this);
		this.janela.apresentar();
	}
	
	public void incluirNovoCurso(int codigo, String nome) {
		try {
			this.novo = new Curso(codigo, nome);
			DaoCurso dao = new DaoCurso();
			dao.adicionar(this.novo);
			this.janela.notificar("Curso Criado!");
			this.janela.setVisible(false);
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
	public Object getBemTangivel() {
		return this.novo;
	}
	
	
	public void encerrar() {
		this.janela.setVisible(false);
		if(this.getCtrlpai() instanceof CtrlPrograma) {
			CtrlPrograma c = (CtrlPrograma)this.getCtrlpai();
			c.incluirCursoFinalizado();	
		} else if(this.getCtrlpai() instanceof CtrlIncluirAluno) {
			CtrlIncluirAluno c = (CtrlIncluirAluno)this.getCtrlpai();
			c.incluirCursoFinalizado();	
		}
	}
}
