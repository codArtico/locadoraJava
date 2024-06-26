package locadoraJava;

import entities.Carro;
import entities.Cliente;
import entities.Garagem;
import util.Menus;

public class Aplicacao extends Menus{
	
	public static final int quantCarros = 10;
			
	public static final Cliente[] vetorClientes = new Cliente[9];
	
	public static int contClientes = 0;
	
	public static void main(String[] args) {
		Carro [] vetorCarros = new Carro[quantCarros];
		Garagem garagem = new Garagem(vetorCarros);
		garagem.criarVetorCarros();
		int opcao = 0;
		
		telaInicial();
		menuInicial(opcao,vetorClientes,contClientes,garagem);
	}
}
