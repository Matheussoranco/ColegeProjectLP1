package pessoa;

public abstract class Cliente {
	private String nome;
	private String sobreNome;
	private String email;
	private String identificador;
	private int milhagem;
	private Tratamento tratador;
	private static long contador = 1;
	
	public Cliente(String nome, String sobreNome, String email, String identificador, int milhagem,
			Tratamento tratador) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.identificador = identificador;
		this.milhagem = milhagem;
		this.tratador = tratador;
	}

	public String getIdentificador(String i1) {
		identificador = i1;
		return identificador;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getContador() {
		return contador;
	}

	public static void setContador(long contador) {
		Cliente.contador = contador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public Tratamento getTratador() {
		return tratador;
	}

	public void setTratador(Tratamento tratador) {
		this.tratador = tratador;
	}
	
	public int getMilhagem() {
		return milhagem;
	}
	public int setMilhagem(int milhagem) {
		return milhagem;
	}
		
	public String Indiv() {
		return getNome() + getSobreNome() + getEmail() + getIdentificador();
	}

}
