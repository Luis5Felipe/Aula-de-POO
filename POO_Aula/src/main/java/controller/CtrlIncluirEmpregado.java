package controller;

import javax.swing.JOptionPane;

import controller.departamento.CtrlIncluirDepartamento;
import model.Departamento;
import model.Empregado;
import model.ModelException;
import model.dao.DaoDepartamento;
import model.dao.DaoEmpregado;
import viewer.JanelaEmpregado;

public class CtrlIncluirEmpregado extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	private Empregado               emp;
	private JanelaEmpregado         janela;
	// Referência para o Caso de Uso IncluirDepartamento que o Caso de Uso
	// IncluirEmpregado pode demandar sua execução.
	private CtrlIncluirDepartamento ctrlIncluirDepartamento;

	public CtrlIncluirEmpregado(CtrlAbstrato c) {
		super(c);
		this.janela = new JanelaEmpregado(this);
		DaoDepartamento dao = new DaoDepartamento();				
		this.janela.atualizarDepartamentos(dao.obterTodos());
		this.janela.apresentar();
	}
	
	public void incluirNovoEmpregado(String cpf, String nome, Departamento depto) {
		try {
			this.emp = new Empregado(cpf,nome,depto);
			DaoEmpregado dao = new DaoEmpregado();
			dao.adicionar(this.emp);
			this.janela.notificar("Empregado Criado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
	
	public Object getBemTangivel() {
		return this.emp;
	}
	
	/**
	 * Iniciando o caso de uso Incluir Departamento
	 */
	public void iniciarIncluirDepartamento() {
		if(this.ctrlIncluirDepartamento == null)
			this.ctrlIncluirDepartamento = new CtrlIncluirDepartamento(this);
		else
			this.janela.notificar("Este Caso de Uso já está em execução!");
	}

	/**
	 * Encerrando o caso de uso Incluir Departamento
	 */
	public void incluirDepartamentoFinalizado() {
		this.ctrlIncluirDepartamento = null;		
		DaoDepartamento dao = new DaoDepartamento();				
		this.janela.atualizarDepartamentos(dao.obterTodos());	
	}

	public void encerrar() {
		this.janela.fechar();
		CtrlPrograma c = (CtrlPrograma)this.getCtrlPai();
		c.incluirEmpregadoFinalizado();		
	}

}
