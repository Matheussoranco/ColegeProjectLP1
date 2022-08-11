package pessoa;

public class TestaCliente {
	public static void main(String[] args) {
		Tratamento tratamentoFisico = new TratamentoFisico(false);
		ClienteFisico cliente1 = new ClienteFisico("Linus", "Torvalds", "linustorvalds@linux.com", "C", 0, tratamentoFisico, "222222", 50);
		cliente1.IndivFisico();
		System.out.println("Cliente: " + cliente1.IndivFisico() + " Este é um: " + IdentificadorCliente.getCliente(cliente1));
		
		Tratamento tratamentoJuridico = new TratamentoJuridico(false);
		ClienteJuridico cliente2 = new ClienteJuridico("Tove", "Torvalds", "tovetorvalds@linux.com", "C", 0, tratamentoJuridico, "333333", "Tove", "Linux Foundation");
		System.out.println("Cliente: " + cliente2.IndivJuridico() + " Este é um: " + IdentificadorCliente.getCliente(cliente2));
		
	}

}
