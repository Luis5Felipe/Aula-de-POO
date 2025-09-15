package controller;

import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoCurso;
import viewer.JanelaAluno;

public class CtrlIncluirAluno extends CtrlAbstrato {

	private JanelaAluno janela;
	private Aluno novo;
	private CtrlIncluirCurso ctrlIncluirCurso;

	public CtrlIncluirAluno(CtrlAbstrato c) {
		super(c);
		this.janela = new JanelaAluno(this);
		this.janela.setVisible(true);
		DaoCurso dao = new DaoCurso();
		this.janela.atualizarCursos(dao.obterTodos().toArray());
		this.janela.apresentar();
	}

	public void CtrlIncluirNovoAluno(int matricula, String nome, Curso idcurso) {
		try {
			this.novo = new Aluno(matricula, nome, idcurso);
			DaoAluno dao = new DaoAluno();
			dao.adicionar(this.novo);
			this.janela.notificar("Aluno Matrículado!");
			this.janela.setVisible(false);
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}

	public Object getBemTangivel() {
		return this.novo;
	}

	public void iniciarIncluirCurso() {
		if (this.ctrlIncluirCurso == null) {
			this.ctrlIncluirCurso = new CtrlIncluirCurso(this);
		} else {
			this.janela.notificar("Este caso de uso já está em uso");
		}
	}

	public void incluirCursoFinalizado() {
		this.ctrlIncluirCurso = null;
		DaoAluno dao = new DaoAluno();
		this.janela.atualizarCursos(dao.obterTodos().toArray());
	}

	public void encerrar() {
		this.janela.setVisible(false);
		CtrlPrograma c = (CtrlPrograma) this.getCtrlpai();
		c.incluirAlunoFinalizado();
	}
}
