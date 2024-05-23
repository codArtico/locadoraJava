package locadoraJava;

import java.util.Scanner;

public class Aplicacao extends Menus{
	
	public static final int quantCarros = 10;
			
	public static final Cliente[] vetorClientes = new Cliente[20];
	
	public static void main(String[] args) {
		int contClientes = 0;
		Carro [] vetorCarros = new Carro[quantCarros];
		Garagem garagem = new Garagem(vetorCarros);
		garagem.criarVetorCarros();
		Scanner sc = new Scanner (System.in);
		int opcao = 0;
		
		telaInicial();
		menuInicial(opcao,vetorClientes,sc,contClientes,garagem);
	}
}
