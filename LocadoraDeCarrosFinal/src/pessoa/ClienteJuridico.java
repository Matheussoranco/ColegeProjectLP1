package pessoa;

public class ClienteJuridico extends Cliente {
	private String cnpj;
	private String contato;
	private String empresa;
	
	public ClienteJuridico(String nome, String sobreNome, String email, String identificador, int milhagem,
			Tratamento tratador, String cnpj, String contato, String empresa) {
		super(nome, sobreNome, email, identificador, milhagem, tratador);
		this.cnpj = cnpj;
		this.contato = contato;
		this.empresa = empresa;
	}
	public String getCnpj() {
		return cnpj;
	}

	public String getContato() {
		return contato;
	}

	public String getEmpresa() {
		return empresa;
	}
	
	public int getMilhagem() {
		return getMilhagem();
	}

	public String IndivJuridico() {
		return this.getTratador().CriaTratamento(getNome(), getSobreNome(), getEmail()) + getEmpresa() + "CNPJ: " + getCnpj();
		
	}
	
}
