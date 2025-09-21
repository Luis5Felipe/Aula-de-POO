package model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {

	private final static int TAMANHO_MAXIMO = 20;

	@Id
	@GeneratedValue
	private int matricula;
	@Column(length = TAMANHO_MAXIMO)
	private String nome;
	@OneToOne
	private Curso idcurso;

	public Aluno(){
		super();
	}

	public Aluno(int matricula, String nome, Curso idcurso) throws ModelException {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setIdcurso(idcurso);
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) throws ModelException {
		Aluno.validarMatricula(matricula);
		this.matricula = matricula;
	}

	public String getNome() throws ModelException {

		return nome;
	}

	public void setNome(String nome) throws ModelException {
		Aluno.validarNome(nome);
		this.nome = nome;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) throws ModelException{
		if (idcurso == null) {
			throw new ModelException("O aluno deve estar matriculado em um curso.");
		}

		if (this.idcurso != null) {
			this.idcurso.removerAluno(this);
			
		}

		this.idcurso = idcurso;
		this.idcurso.adicionarAluno(this);
	}

	private static void validarNome(String nome) throws ModelException {
		if (nome.isEmpty() || nome.trim().isEmpty()) {
			throw new ModelException("O nome do aluno não pode ser nulo ou vazio.");
		}
		if (nome.length() > TAMANHO_MAXIMO) {
			throw new ModelException("O maximo de caracteres que o nome pode ter é" + TAMANHO_MAXIMO);
		}
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c)) {
				throw new ModelException("O caracter na posição " + i + " não é válido!");
			}
		}

	}

	private static void validarMatricula(int matriculado) throws ModelException {
		if (matriculado <= 0) {
			throw new ModelException("A matrícula de ser maior do que zero");
		}
	}
}
