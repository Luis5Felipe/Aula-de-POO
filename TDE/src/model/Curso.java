package model;

import java.util.ArrayList;

public class Curso {
	private int codigo;
	private String nome;
	private ArrayList<Aluno> listaDeAlunos;
	private final static int TAMANHO_MAXIMO = 20;
	
	public Curso(int codigo, String nome) throws ModelException{
		this.setCodigo(codigo);
		this.setNome(nome);
		this.listaDeAlunos = new ArrayList<Aluno>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws ModelException {
		Curso.validarCodigo(codigo);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException  {
		Curso.validarNome(nome);
		this.nome = nome;
	}
	

	public String toString() {
		return this.nome;
	}
	
	public ArrayList<Aluno> getListaDeAlunos() {
		return new ArrayList<>(this.listaDeAlunos);
	}
	

	public void setListaDeAlunos(ArrayList<Aluno> listaDeAlunos)  throws ModelException{
		Curso.validarListaDeAluno(listaDeAlunos);
		this.listaDeAlunos = listaDeAlunos;
	}

	public boolean adicionarAluno(Aluno matriculado) throws ModelException{
		Curso.validarMatricula(matriculado);
		return this.listaDeAlunos.add(matriculado);
	}
	
	public boolean removerAluno(Aluno aluno)  throws ModelException{
		Curso.validarMatricula(aluno);;
		return this.listaDeAlunos.remove(aluno);
	}
	
	private static void validarCodigo(int codigo) throws ModelException {
		if(codigo <= 0) {
			throw new ModelException("O codigo tem que ser Maior do que zero");
		}
	}
	
	private static void validarNome(String nome) throws ModelException {
		if(nome.isEmpty() || nome.trim().isEmpty()) {
			throw new ModelException("O nome do aluno não pode ser nulo ou vazio.");
		}
		if(nome.length() > TAMANHO_MAXIMO) {
			throw new ModelException("O maximo de caracteres que o nome pode ter é" + TAMANHO_MAXIMO);
		}
		for(int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if(!Character.isAlphabetic(c) && !Character.isSpaceChar(c)) {
				throw new ModelException("O caracter na posição " + i + " não é válido!");
			}
		}
	
	}
	
	private static void validarListaDeAluno(ArrayList<Aluno> listaDeAlunos) throws ModelException{
		if(listaDeAlunos == null) {
			throw new ModelException("A lista de alunos não pode ser nula!");
		}
	}
	
	private static void validarMatricula(Aluno matriculado) throws ModelException {
		if(matriculado == null) {
			throw new ModelException("O aluno deve Estar Matriculado para isso!");
		}
	}
	
	
}
