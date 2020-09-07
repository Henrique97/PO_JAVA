public class Livro {
	private String _titulo;
	private String _texto;
	
	public Livro (String titulo, String texto) {
		_titulo=titulo;
		_texto=texto;
		};
		
	public String getTitulo() {
		return _titulo;
		}
	
	public void alteraTitulo(String titulo) {
		_titulo=titulo;
	}
	
	public String getTexto() {
		return _texto;
	}
	
	public int getTamanho() {
		 int tamanho;
		tamanho = (_titulo.length() + _texto.length());
		return tamanho;
		}
	
	public boolean compararLivro(Livro l1) {
		return _titulo.equals(l1._titulo) && _texto.equals(l1._texto);
		}
			
		
	public static void main (String args[]) {
		
		Livro l1 = new Livro("Oi","odifomafpoaisiofaifaoifais");
		Livro l2 = new Livro("Oi", "odifomafpoaisiofaigfaoifais");
		System.out.println(l1.getTitulo());
		System.out.println("O tamanho do livro eh " + l1.getTamanho());
		System.out.println(l1.compararLivro(l2));
		
	}
}

