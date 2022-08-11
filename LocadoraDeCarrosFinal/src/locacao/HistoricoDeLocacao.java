package locacao;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import produto.Veiculo;

public class HistoricoDeLocacao<H> {
	private List<H> locacoes = new ArrayList<H>();
	
	public void adiciona(H obj) {
		this.checkException(obj == null  ,"Locação inexistente!");
		this.locacoes.add(obj);

	}
	public void remove(H obj) {

		if (verlista(obj))
			this.locacoes.remove(obj);

	}

	public boolean verlista(H obj) {
		return this.locacoes.contains(obj);
	}

	public H getObjCopy(H obj) {
		return (H) new ArrayList<H>(locacoes).stream().filter(x->x.equals(obj)).findFirst();

	}
	
	public H getI(int i) {
		return locacoes.get(i);
	}

	public ArrayList<H> getAll() {
		return new ArrayList<H>(locacoes);
	}
		
	private void checkException(Boolean cond,String msg) {
		if (cond) throw new IllegalArgumentException(msg);
	}
	
	
	public double FaturamentoTotal() {
	      double totalapagar = 0;
	      for(double i = 0; i < locacoes.size(); i++)
	    	    totalapagar = locacoes.size() * Locacao.getPrecoaPagar();
	      return totalapagar;
	}
	
	public double FaturamentoMensal(Month mesreferencia) {
	      double faturamentomensal = 0;
	      mesreferencia = Locacao.getDataretirada();
	      for(double i = 0; i < locacoes.size(); i++) {
	    	  if(mesreferencia != Locacao.getDataretirada() ) {
	    		  mesreferencia = Locacao.getDataretirada();
	    	  }
	    	  faturamentomensal = locacoes.size() * Veiculo.getPreco();
	      }
		return faturamentomensal;
	}
}