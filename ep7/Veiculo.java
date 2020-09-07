package bombas;


public class Veiculo {
	
	private String _marca;
	EstacaoServico _estacao = null;
	
	
	public Veiculo(String marca, EstacaoServico p) {
		_marca = marca;
		_estacao = p;
	}
	
	public void acelera() {
		System.out.println("VRUM VRUM");
	}
	public void trava() {
		System.out.println("GRRR GRRR");
	}
	public void buzina() {
		System.out.println("PII PII");
	}
	
	public void abastece(int quantidade, int id) {
		_estacao.retiraCombustivel(quantidade, id);	
	}
	
	public String obtemMarca() {
		return _marca;
	}
	
	public static void main (String args[]) {
		
	}
}

