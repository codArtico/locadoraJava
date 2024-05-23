package locadoraJava;

import java.util.Scanner;

public class Menus {
	
	public static void menuInicial(int opcao, Cliente[] vetorClientes, Scanner sc, int contClientes, Garagem garagem) {
	do {
		System.out.println("Seja bem vindo a nossa Locadora de Carros");
		System.out.println("[1] - Cadastrar novo usuário \n[2] - Fazer Login");
		System.out.println("Selecione uma opcao: ");
		opcao = sc.nextInt();
		
	
		switch (opcao) {
		case 1:
			vetorClientes = cadastrarUsuario(vetorClientes, sc, contClientes);
			contClientes++;
			break;
		case 2:
			Cliente clienteLogado = Cliente.logar(vetorClientes,contClientes);
			if(clienteLogado != null) {
				while(clienteLogado.isLogado()) {
			menuPrincipal(clienteLogado,garagem,sc);
				}
			}
			break;
		default:
			break;
		}
		} while (opcao>0 && opcao<3);
	}
	
	public static void menuPrincipal(Cliente clienteLogado, Garagem garagem, Scanner sc) {
		
		int escolha;
		
		do {
		System.out.println("Seja bem vindo a Locadora de Carros!");
		System.out.println("Digite a opção que deseja: \n \n[1] - Ver carros disponiveis \n[2] - Alugar Carro \n[3] - Devolver Carro \n[4] - Alterar senha");
		escolha = sc.nextInt();
		
		switch(escolha) {
		case 1:
			garagem.mostrarCarros();
			break;
		case 2:
			garagem.alugarCarro(clienteLogado, sc);
			break;
		case 3:
			garagem.devolverCarro(clienteLogado);
			break;
		case 4:
			clienteLogado.alterarSenha();
			break;
		default:
			break;
		}
		
		} while(escolha>0 && escolha<4);
		clienteLogado.deslogar();
	}
	
	private static Cliente[] cadastrarUsuario(Cliente[] vetorClientes, Scanner sc, int contClientes) {
			sc.nextLine();
			if(contClientes<vetorClientes.length) {
				System.out.println("Digite seu Nome: ");
				String nome = sc.nextLine();
				System.out.println("Digite seu CPF: ");
				String cpf = sc.nextLine();
				System.out.println("Digite seu Endereço: ");
				String end = sc.nextLine();
				System.out.println("Digite seu Telefone: ");
				String tel = sc.nextLine();
				System.out.println("Digite seu Email: ");
				String email = sc.nextLine();
				System.out.println("Digite seu Senha: ");
				String senha = sc.nextLine();
				vetorClientes [contClientes] = new Cliente (nome,cpf,end,tel,email,senha);
			}
			else {
				System.out.println("Nosso sistema de clientes está lotado!");
			}
			
			return vetorClientes;
		}
}
