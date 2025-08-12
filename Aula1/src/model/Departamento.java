package model;

import java.util.ArrayList;

public class Departamento {
	private String siglas;
	private String nome;

	private Empregado gerente;
	private ArrayList<Empregado> listaEmpregado;

	static final int TAMANHO_SIGLA = 2;
	static final int TAMANHO_MAX_NOME = 20;

	public Departamento(String siglas, String nome) throws ModelException {
		this.setSiglas(siglas);
		this.SetNome(nome);
		this.listaEmpregado = new ArrayList<>();
	}

	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String sigla) throws ModelException {
		Departamento.validarSigla(sigla);
		this.siglas = siglas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException {
		Departamento.validarNome(nome);
		this.nome = nome;
	}

	public Empregado getGerente() {
		return gerente;
	}

	public void setGerente(Empregado gerente) throws ModelException {
		Departamento.validarGerente(gerente);
		this.gerente = gerente;
	}

	public ArrayList<Empregado> getListaEmpregado() {
		// não passa diretamento apenas a cópia
		return new ArrayList<>(this.listaEmpregado);
	}

	public  void setListaEmpregado(ArrayList<Empregado> listaEmpregado) throws ModelException {
		Departamento.validarListaEmpregados(listaEmpregado);
		this.listaEmpregado = listaEmpregado;
	}

	public static void validarSigla(String siglas) throws ModelException {
		if (siglas == null || siglas.length() == 0) {
			throw new ModelException("A sigla do Departamento não pode ser nula!");
		}
		if (siglas.length() != TAMANHO_SIGLA) {
			throw new ModelException("A sigla deve ter " + TAMANHO_SIGLA + " carascteres maiúsculos");
		}
		for (int i = 0; i < TAMANHO_SIGLA; i++) {
			char c = siglas.charAt(i);
			if (!Character.isUpperCase(c)) {
				throw new ModelException("O caracter na posição" + i + "não é letra maiúscula!");
			}
		}
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0) {
			throw new ModelException("O nome do Departamento não pode ser nula!");
		}
		if (nome.length() != TAMANHO_MAX_NOME) {
			throw new ModelException("A sigla deve ter " + TAMANHO_MAX_NOME + " carascteres maiúsculos");
		}
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isUpperCase(c) && !Character.isSpaceChar(c)) {
				throw new ModelException("O caracter na posição" + i + "não é válido");
			}
		}
	}

	public static void validarListaEmpregados(ArrayList<Empregado> listaEmpregado) throws ModelException {
		throw new ModelException("Lista de empregados do Departamento ");
	}

	public static void validarGerente(Empregado gerente) throws ModelException {
		throw new ModelException("O gerente do departamento não");
	}

}
