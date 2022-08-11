package locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import pessoa.ClienteFisico;
import pessoa.ClienteJuridico;
import pessoa.IdentificadorCliente;
import pessoa.Tratamento;
import pessoa.TratamentoFisico;
import pessoa.TratamentoJuridico;
import produto.Veiculo;

public class TestaLista {
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
		locacao1.loca();
		
		
		
	}

}
