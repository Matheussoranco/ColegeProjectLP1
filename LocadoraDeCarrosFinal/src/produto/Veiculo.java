package produto;

public class Veiculo {
	private String marca;
	private String modelo;
	private String placa;
	private int quantidade;
	private static double preco;
	private static int disponibilidade;
	
	public Veiculo(String marca, String modelo, String placa, int quantidade, int disponibilidade, double preco) {
		this.disponibilidade = disponibilidade;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public static int getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public String Produto() {
		return getMarca() + getModelo() + getPlaca() + getQuantidade() + getDisponibilidade() + getPreco();
	}
	
	

}
