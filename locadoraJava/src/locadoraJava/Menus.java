package locadoraJava;

import java.util.Scanner;

public class Menus {
	
	public static Scanner sc = new Scanner (System.in);
	
	public static void telaInicial() {
		
		System.out.println(".-----------------. .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  ");
		System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
		System.out.println("| | ____  _____  | || |     ____     | || | _____  _____ | || |     ______   | || |      __      | || |  _______     | |");
		System.out.println("| ||_   \\|_   _| | || |   .'    `.   | || ||_   _||_   _|| || |   .' ___  |  | || |     /  \\     | || | |_   __ \\    | |");
		System.out.println("| |  |   \\ | |   | || |  /  .--.  \\  | || |  | | /\\ | |  | || |  / .'   \\_|  | || |    / /\\ \\    | || |   | |__) |   | |");
		System.out.println("| |  | |\\ \\| |   | || |  | |    | |  | || |  | |/  \\| |  | || |  | |         | || |   / ____ \\   | || |   |  __ /    | |");
		System.out.println("| | _| |_\\   |_  | || |  \\  `--'  /  | || |  |   /\\   |  | || |  \\ `.___.'\\  | || | _/ /    \\ \\_ | || |  _| |  \\ \\_  | |");
		System.out.println("| ||_____|\\____| | || |   `.____.'   | || |  |__/  \\__|  | || |   `._____.'  | || ||____|  |____|| || | |____| |___| | |");
		System.out.println("| |              | || |              | || |              | || |              | || |              | || |              | |");
		System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
		System.out.println(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
		System.out.println("");
	}
	
	public static void menuInicial(int opcao, Cliente[] vetorClientes, int contClientes, Garagem garagem) {
	do {
		System.out.println("Seja bem vindo a nossa Locadora de Carros");
		System.out.println("[1] - Cadastrar novo usuário \n[2] - Fazer Login");
		System.out.println("Selecione uma opcao: ");
		opcao = sc.nextInt();
		
	
		switch (opcao) {
		case 1:
			vetorClientes = cadastrarUsuario(vetorClientes, contClientes);
			contClientes++;
			break;
		case 2:
			Cliente clienteLogado = Cliente.logar(vetorClientes,contClientes);
			if(clienteLogado != null) {
				while(clienteLogado.isLogado()) {
			menuPrincipal(clienteLogado,garagem);
				}
			}
			break;
		default:
			break;
		}
		} while (opcao>0 && opcao<3);
	}
	
	public static void menuPrincipal(Cliente clienteLogado, Garagem garagem) {
		
		int escolha;
		
		do {
		System.out.println("Seja bem vindo " + clienteLogado.getNome() +", a nossa Locadora de Carros!");
		System.out.println("\n \n[1] - Ver carros disponiveis \n[2] - Alugar Carro \n[3] - Devolver Carro \n[4] - Alterar senha \n[5] - Mostrar dados do usuário");
		System.out.print("Digite a opção que deseja: ");
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
		case 5:
			clienteLogado.mostrarDados();
		default:
			break;
		}
		
		} while(escolha>0 && escolha<6);
		clienteLogado.deslogar();
	}
	
	private static Cliente[] cadastrarUsuario(Cliente[] vetorClientes, int contClientes) {
			System.out.println("");
			if(contClientes<vetorClientes.length) {
				System.out.print("Digite seu Nome: ");
				String nome = sc.nextLine();
				
				System.out.print("Digite seu CPF: ");
				String cpf = sc.nextLine();
				
				System.out.print("Digite seu Endereço: ");
				String end = sc.nextLine();
				
				System.out.print("Digite seu Telefone: ");
				String tel = sc.nextLine();
				
				System.out.print("Digite seu Email: ");
				String email = sc.nextLine();
				
				System.out.print("Digite seu Senha: ");
				String senha = sc.nextLine();
				
				vetorClientes [contClientes] = new Cliente (nome,cpf,end,tel,email,senha);
			}
			else {
				System.out.println("Nosso sistema de clientes está lotado!");
			}
			
			return vetorClientes;
		}
}
