package model;

public class Empregado {
	private String cpf;
	private String nome;

	private Departamento depto;

	static final int TAMANHO_SIGLA = 2;
	static final int TAMANHO_MAX_NOME = 20;

	public Empregado(String cpf, String nome, Departamento depto) throws ModelException {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setDepto(depto);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ModelException {
		Empregado.validarCpf(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException {
		Empregado.validarNome(nome);
		this.nome = nome;
	}

	public Departamento getDepto() throws ModelException {
		return depto;
	}

	public void setDepto(Departamento depto) throws ModelException {
		Empregado.validarDepto(depto);
		this.depto = depto;
	}

	public static void validarCpf(String cpf) throws ModelException {
		String expressaoRegular = "[0-9].[0-9]{3}.[0-9]{3}-[0-9]{2}";
		if (cpf == null || cpf.length() == 0) {
			throw new ModelException("O empregado não pode sser nulo!");
		}
		if (!cpf.matches(expressaoRegular)) {
			throw new ModelException("Cpf inválido");
		}
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0) {
			throw new ModelException("O nome do Empregado não pode ser nula!");
		}
		if (nome.length() > TAMANHO_MAX_NOME) {
			throw new ModelException("A sigla deve ter " + TAMANHO_MAX_NOME + " carascteres maiúsculos");
		}
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isUpperCase(c) && !Character.isSpaceChar(c)) {
				throw new ModelException("O caracter na posição" + i + "não é válido");
			}
		}
	}

	public static void validarDepto(Departamento depto) throws ModelException {
		if (depto == null) {
			throw new ModelException("O departamento do empregado não pode ser nulo! ");
		}
	}

}
