package pessoa;

import java.util.HashMap;
import java.util.Locale.Category;

import locacao.HistoricoDeLocacao;
import locacao.Locacao;
import pessoa.Cliente;
import pessoa.ClienteFisico;
import produto.Veiculo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class RankingDeCliente {
public HashMap<String, ValorGastoeCategoria> getClientesEValorTotalDeServicos(HistoricoDeLocacao historico) {
		
		checkConditions(historico == null, "O hisotrico inexistente!");
		
		HashMap<String, ValorGastoeCategoria> ranking = new HashMap<String, ValorGastoeCategoria>();
		
		for(int i = 0; i < historico.getAll().size() ; i++) {
		
if ( ranking.get( ((Locacao) historico.getI(i)).getCliente().Indiv())  == null) {
				
				ranking.put(((Locacao) historico.getI(i)).getCliente().Indiv(), new ValorGastoeCategoria(Double.valueOf( ((Locacao) historico.getI(i)).loca()), this.checkCategory(Double.valueOf(((Locacao) historico.getI(i)).loca())) ));
			}else {
				ValorGastoeCategoria vgpc = ranking.get(((Locacao) historico.getI(i)).getCliente().Indiv());
				ranking.put(((Locacao) historico.getI(i)).getCliente().Indiv(), new ValorGastoeCategoria( Double.valueOf(((Locacao) historico.getI(i)).loca())+vgpc.getValorGasto(), checkCategory(Double.valueOf(((Locacao) historico.getI(i)).loca()) +vgpc.getValorGasto())) );
			}		
		}
		
			
		return ranking;
	}
	
	public Double getGastoPorCliente(String nome, String sobreNome,HistoricoDeLocacao historico) {
		
		checkConditions(historico == null, "Histórico inexitente");
		checkConditions(nome == null || nome.trim().isEmpty(), "Nome Invalido");
		checkConditions(sobreNome == null || sobreNome.trim().isEmpty(), "Sobrenome Invalido");
		
		HashMap<String, ValorGastoeCategoria> ranking = this.getClientesEValorTotalDeServicos(historico);
		
		return ranking.get(nome.trim()+" "+sobreNome.trim()).getValorGasto();
		
	}
	
	public Category getCategoriaDoCliente(String nome, String sobreNome,HistoricoDeLocacao historico) {
		
		checkConditions(historico == null, "Histórico inexistente");
		checkConditions(nome == null || nome.trim().isEmpty(), "Nome Invalido");
		checkConditions(sobreNome == null || sobreNome.trim().isEmpty(), "Sobrenome Invalido");
		
		HashMap<String, ValorGastoeCategoria> ranking = this.getClientesEValorTotalDeServicos(historico);
		
		return ranking.get(nome.trim()+" "+sobreNome.trim()).getCategoria();
		
	}
	

	private Category checkCategory(Double gc) {
		
		if( gc >= 3000.0) return Category.valueOf("A");
				
		if( gc< 3000.0 && gc >=1000.0) return Category.valueOf("B");
		
		return Category.valueOf("C");
		
	}
	
	private class ValorGastoeCategoria{
		
		private Double valorGasto;
		private Category categoria;
		
		public ValorGastoeCategoria(Double valorGasto,Category categoria) {
			
			this.checkConditions(valorGasto == null || valorGasto <= 0.0,"Valor Ilegal");
			this.checkConditions(categoria == null,"Categoria Ilegal");
			
			this.valorGasto = valorGasto;
			this.categoria = categoria;
		}
		
		public Category getCategoria() {
			return this.categoria;
		}
		
		public Double getValorGasto() {
			return this.valorGasto;
		}
		
		private void checkConditions(Boolean cond,String msg) {
			if (cond) throw new IllegalArgumentException(msg);
		}
	}
	
	private static void checkConditions(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}


}
