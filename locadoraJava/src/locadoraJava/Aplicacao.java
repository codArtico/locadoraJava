package locadoraJava;

public class Aplicacao extends Menus{
	
	public static final int quantCarros = 10;
			
	public static final Cliente[] vetorClientes = new Cliente[20];
	
	public static void main(String[] args) {
		int contClientes = 0;
		Carro [] vetorCarros = new Carro[quantCarros];
		Garagem garagem = new Garagem(vetorCarros);
		garagem.criarVetorCarros();
		int opcao = 0;
		
		telaInicial();
		menuInicial(opcao,vetorClientes,contClientes,garagem);
	}
}
