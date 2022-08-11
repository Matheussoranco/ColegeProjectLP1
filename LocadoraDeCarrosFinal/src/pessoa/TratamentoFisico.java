package pessoa;

public class TratamentoFisico implements Tratamento {
	private boolean sexo;
	
	public TratamentoFisico(boolean genero) {
		this.sexo = genero;
	}

	@Override
	public String CriaTratamento(String nome, String sobrenome, String email) {
		if(sexo == false) {
			return "Senhor" + " " + nome + sobrenome + email;
		}else {
			return "Senhora" + " " + nome + sobrenome + email;
		}
	}
}
