package bombas;

public class EstacaoServico {
	
	
	private int[] _bombasCombustivel;
	private int _combustivel;
	
	public EstacaoServico(){
		_combustivel = 1000;
		_bombasCombustivel = new int[10];
		int i;
		for(i = 0; i < 10; i++)
		_bombasCombustivel[i] = 0;
	}
	
	public int retiraCombustivel(int quantidade, int id) {
		int quantidadeReal;
		if(quantidade>0 && _combustivel- quantidade >= 0) {
		_bombasCombustivel[id] = _bombasCombustivel[id] + quantidade;
		_combustivel = _combustivel - quantidade;
		quantidadeReal = quantidade;
		}
		else {
			quantidadeReal = quantidade + (_combustivel-quantidade);	
				}
		return quantidadeReal;
		}
		
	public int obtemQuantidadeCombustivel() {
		return _combustivel;
		}
	public int obtemConsumo(int id) {
		return _bombasCombustivel[id];
		}

	public static void main (String args[]) {

	    Veiculo[] vetorVeiculo = new Veiculo[10];
	    
		int i;
		int n;
		String marca;
		EstacaoServico estacao = new EstacaoServico();
		for(i = 0; i < 10 ;i++ ) {
			n = i + 1; 
			marca = "XPTO" + n;
			if(i>5)
				vetorVeiculo[i] = new VeiculoPesado(marca, estacao);
			else
				vetorVeiculo[i] = new Veiculo(marca, estacao);
		}
		
		
		for(i = 0; i < 10 ;i++ ) {
			vetorVeiculo[i].acelera();
			vetorVeiculo[i].buzina();
			vetorVeiculo[i].abastece(150, i);
			vetorVeiculo[i].trava();
		}
		
		
	}
}

