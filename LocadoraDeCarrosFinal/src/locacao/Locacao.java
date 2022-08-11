package locacao;
import pessoa.Cliente;
import pessoa.ClienteFisico;
import produto.Veiculo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Locacao {
	private Cliente cliente;
	private Veiculo veiculo;
	private int prazoDia;
	private static double precoaPagar;
	private int odometroinicial;
	private int odometrofinal;
	private LocalDate dataretirada;
	private LocalTime horaretirada;
	private static LocalDate datadevolucao;
	private int diaDevolucao;
	private LocalTime horadevolucao;
	private String identificador;
	private static long contador = 1;
	private static int anoatual = 0;
	private int contadias = 0;
	
	public Locacao(Cliente cliente, Veiculo veiculo, int odometroinicial, int odometrofinal, LocalDate dataretirada,
			LocalTime horaretirada, LocalDate datadevolucao, LocalTime horadevolucao, double precoaPagar) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.precoaPagar = precoaPagar;
		this.odometroinicial = odometroinicial;
		this.odometrofinal = odometrofinal;
		this.dataretirada = dataretirada;
		this.horaretirada = horaretirada;
		this.datadevolucao = datadevolucao;
		this.horadevolucao = horadevolucao;
		
		LocalDate data = LocalDate.now();
		int ano = data.getYear();
		if(ano != anoatual) {
			anoatual = ano;
			contador = 1;
		}
		this.identificador = anoatual + "-" + contador;
		contador++;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public static double getPrecoaPagar() {
		return precoaPagar;
	}

	public int getOdometroinicial() {
		return odometroinicial;
	}

	public int getOdometrofinal() {
		return odometrofinal;
	}

	public LocalTime getHoraretirada() {
		return horaretirada;
	}


	public static LocalDate getDatadevolucao() {
		return datadevolucao;
	}

	public LocalTime getHoradevolucao() {
		return horadevolucao;
	}

	public String getIdentificador() {
		return identificador;
	}

	public long diarias(){
		return contador;
	}
	
	public int quilometragem() {
		int kmtotal;
		kmtotal = odometrofinal - odometroinicial;
		if(kmtotal < 0) {
			return 0;
		}else {
			return kmtotal;
		}
	}
	
	public int trocakm() {
		odometroinicial = odometrofinal;
		return odometroinicial;
	}
	
	
	public static Month getDataretirada() {
		LocalDate data = LocalDate.now();
		Month mes = data.getMonth();
		return mes;

	}
	
	public static int diaDevolucao() {
		LocalDate devolveu = LocalDate.now();
		int diaDevolucao = devolveu.getDayOfMonth();
		return diaDevolucao;
	}
	
	public static int PrazoEntrega() {
		LocalDate prazo = LocalDate.now();
		prazo = prazo.plusWeeks(1);
		int prazoDia = prazo.getDayOfMonth();
		return prazoDia ;
	}
	
	public double pagamento(double precoaPagar) {
		this.precoaPagar = precoaPagar;
		LocalDate data = LocalDate.now();
		int dia = data.getDayOfMonth();
		contadias++;
		precoaPagar = prazoDia * Veiculo.getPreco();
		
		return precoaPagar;
	}
	
	public int milhas() {
		if(ClienteFisico.class.equals(getCliente())) {
			return odometroinicial;
		}else {
			odometroinicial = (int) (odometroinicial + odometroinicial*0.10);
		}
		return odometroinicial;
	}
	
	public String loca() {
		return this.loca() + getDataretirada() + PrazoEntrega() + getOdometroinicial() + getIdentificador() + getCliente() + getVeiculo() + milhas()  + pagamento(precoaPagar);
	}

}

