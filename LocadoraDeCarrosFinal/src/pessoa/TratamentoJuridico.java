package pessoa;

public class TratamentoJuridico implements Tratamento {
	private boolean sexoCont;

	public TratamentoJuridico(boolean genero) {
		this.sexoCont = genero;
	}

	@Override
	public String CriaTratamento(String nome, String sobrenome, String email) {
		if(sexoCont == true) {
			return "Colaborador" + " " + nome + sobrenome + email;
		} else {
			return "Colaboradora" + " " + nome + sobrenome + email;
		}
	}

}
