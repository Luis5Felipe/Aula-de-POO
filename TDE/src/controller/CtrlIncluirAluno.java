package controller;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import viewer.JanelaAluno;

public class CtrlIncluirAluno {
	final private CtrlPrograma ctrlPai;
	private JanelaAluno janela;

	public CtrlIncluirAluno(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaAluno(this);
		this.janela.setVisible(true);
	}

	public void CtrlIncluirNovoAluno(int matricula, String nome, Curso idcurso) {
		try {
			Aluno novo = new Aluno(matricula, nome, idcurso);
			DaoAluno dao = new DaoAluno();
			dao.adicionar(novo);
			JOptionPane.showMessageDialog(null, "Aluno Matrículado!");
			this.janela.setVisible(false);
			this.ctrlPai.incluirAlunoFinalizado();
		} catch (ModelException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	public void cancelarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.incluirAlunoFinalizado();
	}
}
