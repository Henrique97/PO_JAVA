package bombas;

public class VeiculoPesado extends Veiculo {
	
	private int _aceleracoes;
	private int _travagens;
	
	
	public VeiculoPesado(String marca, EstacaoServico p) {
		super(marca, p);
		_aceleracoes = 0;
		_travagens = 0;
		_estacao = p;
	}
	
	
	public void acelera() {
		System.out.println("VRUM VRUM");
		_aceleracoes++;
	}
	public void trava() {
		System.out.println("GRRR GRRR");
		_travagens++;
	}
	
	public void buzina() {
		System.out.println("POO POO");
	}
	
	public int obtemNumeroAceleracoes() {
		return _aceleracoes;
	}
		
	public int obtemNumeroTravagens() {
		return _travagens;
	}
	

}

