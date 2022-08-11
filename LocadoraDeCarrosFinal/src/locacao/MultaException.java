package locacao;
import java.time.LocalDate;

import pessoa.Cliente;
import pessoa.ClienteFisico;
import pessoa.ClienteJuridico;
import pessoa.IdentificadorCliente;
import pessoa.Tratamento;
import pessoa.TratamentoFisico;
import pessoa.TratamentoJuridico;
import produto.Veiculo;

public class MultaException extends Exception {
	static LocalDate prazo = LocalDate.now();
	
	public static LocalDate PrazoEntrega() {
		prazo = prazo.plusWeeks(1);
		return prazo ;
		
	}
	public void Multa(Locacao l) {
		int dayGap = ((l.getDatadevolucao().getMonthValue() - l.getDataretirada().getValue()) / 1000 / 60 / 60 / 24) - 7;

		if (dayGap > 0) {
			String identificadorCliente;
			identificadorCliente = l.getCliente().getClass().getName();

			double multa;
			String tratamento;
			tratamento = l.getCliente().getTratador().CriaTratamento(l.getCliente().getNome(), l.getCliente().getSobreNome(), l.getCliente().getEmail());

			if (identificadorCliente.equals("ClienteFisico")) {
				multa = (l.getVeiculo().getPreco() * 0.5) * dayGap;
			} else {
				multa = (l.getVeiculo().getPreco() * 0.1) * dayGap;
			}

			System.out.println("Prezado " + tratamento + " " + l.getCliente().getNome() + " " + l.getCliente().getSobreNome() + ",\n Dias em atraso: " + dayGap + "\n Multa a ser paga: " + multa);
		}
	}
}