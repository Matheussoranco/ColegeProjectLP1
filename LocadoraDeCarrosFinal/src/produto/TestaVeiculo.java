package produto;

public class TestaVeiculo {
	public static void main(String[] args) {
		Veiculo veiculo1 = new Veiculo ("BMW", "BMW X5", "TSL 2020", 4, 2, 300);
		
		veiculo1.Produto();
		System.out.println("Veículo: " + veiculo1.getMarca() +" "+ veiculo1.getModelo() +" "+ veiculo1.getPlaca()+" "+ veiculo1.getQuantidade() +" "+ "Disponível: " + veiculo1.getDisponibilidade() +" "+ veiculo1.getPreco());
	}

}
