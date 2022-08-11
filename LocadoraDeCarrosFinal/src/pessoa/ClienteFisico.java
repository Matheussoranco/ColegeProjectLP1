package pessoa;

public class ClienteFisico extends Cliente {
	private String cpf;
	private int idade;
	
	public ClienteFisico(String nome, String sobreNome, String email, String identificador, int milhagem,
			Tratamento tratador, String cpf, int idade) {
		super(nome, sobreNome, email, identificador, milhagem, tratador);
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public int getMilhagem() {
		return getMilhagem();
	}

	public String IndivFisico() {
		return this.getTratador().CriaTratamento(getNome(),getSobreNome(), getEmail()) + getIdade() + " anos de idade";
		
	}

}
