package locacao;
import pessoa.Cliente;
import pessoa.ClienteFisico;
import pessoa.ClienteJuridico;
import pessoa.IdentificadorCliente;
import pessoa.Tratamento;
import pessoa.TratamentoFisico;
import pessoa.TratamentoJuridico;
import produto.Veiculo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class ExecutaLocacao {
	public static void main(String[] args) {
		Tratamento tratamentoFisico = new TratamentoFisico(false);
		ClienteFisico cliente1 = new ClienteFisico("Linus", "Torvalds", "linustorvalds@linux.com", "C", 0, tratamentoFisico, "222222", 50);
		cliente1.IndivFisico();
		System.out.println("Cliente: " + cliente1.IndivFisico() + " Este é um: " + IdentificadorCliente.getCliente(cliente1));
		
		Tratamento tratamentoJuridico = new TratamentoJuridico(true);
		ClienteJuridico cliente2 = new ClienteJuridico("Tove", "Torvalds", "tovetorvalds@linux.com", "C", 0, tratamentoJuridico, "333333", "Tove", "Linux Foundation");
		cliente2.IndivJuridico();
		System.out.println("Cliente: " + cliente2.IndivJuridico() + " Este é um: " + IdentificadorCliente.getCliente(cliente2));

		Veiculo veiculo1 = new Veiculo ("BMW", "BMW X5", "TSL 2020", 4, 1, 150);
		veiculo1.Produto();
		try {
			if(Veiculo.getDisponibilidade() == 0) {
				throw new Exception();
			}else {
				System.out.println("Veículo: " + veiculo1.getMarca() +" "+ veiculo1.getModelo() +" "+ veiculo1.getPlaca()+" "+ veiculo1.getQuantidade() +" Disponivel: "+ veiculo1.getDisponibilidade() +" "+ veiculo1.getPreco());
			}
		} catch (Exception e) {
			System.out.println("Veiculo: " + veiculo1.getMarca()+ " " + veiculo1.getModelo() +" " + "Está indisponível no momento");
		}
		Locacao locacao1 = new Locacao(cliente1, veiculo1, 0, 400, LocalDate.of(2021, 05, 22), LocalTime.of(12, 0), LocalDate.of(2021, 05, 29), LocalTime.of(18, 30), 400 );
		try {
			if(Locacao.diaDevolucao() > Locacao.PrazoEntrega()) {
				throw new MultaException();
			}
		} catch (MultaException e) {
			System.out.println("O cliente: " + locacao1.getCliente().Indiv() + " atrasou a entrega do veiculo!");
		}finally{
		}
		if(Veiculo.getDisponibilidade() != 0) {
			System.out.println("O cliente " + cliente1.getNome() +" "+ cliente1.getSobreNome()+" "+"alugou o carro "+veiculo1.getModelo());
		}else {
			System.out.println("Selecione outro veiculo, por favor");
		}
		
	}
	
	static int CompareLocacoes(Locacao a, Locacao b, int tipoComparacao) {
		int resultadoComparacao;

		switch(tipoComparacao) {
			case 0:
				resultadoComparacao = a.getVeiculo().getPreco() < b.getVeiculo().getPreco();
				break;
			case 1:
				resultadoComparacao = a.getCliente().getNome().compareTo(b.getCliente().getNome());
				break;
			default:
				resultadoComparacao = 0;
				break;
		}

		return resultadoComparacao;
	}

	void Partition(ArrayList<Locacao> locacoes, int start, int end, int markedI, int markedJ, int tipoComparacao)	{
		int i = start;
		int j = end - 1;
		int p = (int)((start + end) / 2);
		Locacao[] arr;
		Locacao pivot = arr[p];

		while (true) {
			while (CompareLocacoes(arr[i], pivot, tipoComparacao) && i < end - 1) {
				i++;
			}

			while (CompareLocacoes(pivot, arr[j], tipoComparacao) && j > start) {
				j--;
			}

			if (i >= j) {
           		markedI = i;
           		markedJ = j;
				return;
			}

			Locacao aux = arr[i];
			arr[i] = arr[j];
			arr[j] = aux;

			i++;
			j--;
		}
	}

	void QuickSortAlgorithm(ArrayList<Locacao> arr, int start, int end, int tipoComparacao) {
		if (start >= end) {
			return;
		}

		int markedI = 0;
		int markedJ = 0;

		Partition(arr, start, end, markedI, markedJ, tipoComparacao);

		int leftEnd = markedI;
		int rightStart = markedJ <= markedI ? markedJ + 1 : markedJ;

		QuickSortAlgorithm(arr, start, leftEnd, tipoComparacao);
		QuickSortAlgorithm(arr, rightStart, end, tipoComparacao);
	}

	void QuickSort(ArrayList<Locacao> array, int size, int tipoComparacao) {
		QuickSortAlgorithm(array, 0, size, tipoComparacao);
	}

	public ExecutaLocacao(ArrayList<Locacao> locacoes, int tipoListagem) {
		switch(tipoListagem) {
			case 0:
				QuickSort(locacoes, locacoes.size(), 0);
				break;
			case 1:
				QuickSort(locacoes, locacoes.size(), 1);
				break;
			default:
				QuickSort(locacoes, locacoes.size(), 0);
				break;
		}
	}
}
