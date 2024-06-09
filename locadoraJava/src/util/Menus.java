package util;

import java.util.Scanner;

import entities.Cliente;
import entities.Garagem;

public class Menus{
		
	public static Scanner sc = new Scanner (System.in);
	
	public static void info() {
		System.out.println("\n\n\n");
		telaInicial();
		
		System.out.println("• NowCar - Solução imediata para um passeio sem complicações • \n");
		System.out.println("Como funciona nossos contratos?");
		System.out.println("Prezamos sempre pela transparência de nossos serviços, e por isso, disponibilizamos abertamente o nosso contrato: ");
		System.out.println("Taxa 1 - Taxa Fixa: Essa taxa é referente ao dia que você contratou o aluguel do seu carro. Corresponde ao valor de uma diaria");
		System.out.println("Taxa 2 - Taxa Variável(Diaria): Essa taxa é referente ao total de dias após o aluguel do seu carro.");
		System.out.println("Taxa 3 - Taxa de Atraso: Essa taxa é corresponde aos dias passados após a data informada para a devolução. Corresponde ao triplo da diaria/dia");
		System.out.println("\nAo usar os serviços NowCar, você concorda que leu e está ciente deste contrato e das respectivas taxas, além de taxas extras como combustível, danos aos veículos e etc.");
		System.out.println("Pressione Enter para continuar");
		sc.nextLine();
		sc.nextLine();
	}
	
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
		System.out.println("\n \n[1] - Ver carros disponiveis \n[2] - Alugar Carro \n[3] - Devolver Carro \n[4] - Alterar senha \n[5] - Mostrar dados do usuário \n[6] - Mostrar carro Alugado \n[7] - Termos de uso");
		System.out.print("Digite a opção que deseja: ");
		escolha = sc.nextInt();
		
		switch(escolha) {
		case 1:
			garagem.mostrarCarros();
			break;
		case 2: 
			System.out.println("");
			int tipoAluguel;
			do {
				System.out.println("1 - Alugar por Índice / 2 - Alugar por Modelo e Marca");
				tipoAluguel = sc.nextInt();
				if(tipoAluguel == 1) {
					System.out.print("Informe o indice do carro: ");
					int indiceCarro = sc.nextInt();
					System.out.println("");
					garagem.alugarCarro(clienteLogado, indiceCarro);
				}
				else if (tipoAluguel == 2) {
					System.out.println("");
					garagem.alugarCarro(clienteLogado, sc);
				}
			} while(tipoAluguel != 1 && tipoAluguel !=2);
			break;
		case 3:
			garagem.devolverCarro(clienteLogado);
			break;
		case 4:
			clienteLogado.alterarSenha();
			break;
		case 5:
			clienteLogado.mostrarDados();
			break;
		case 6:
			clienteLogado.mostrarCarroAlugado();
			break;
		case 7:
			info();
			break;
		default:
			break;
		}
		
		} while(escolha>0 && escolha<8);
		clienteLogado.deslogar();
	}
	
	private static Cliente[] cadastrarUsuario(Cliente[] vetorClientes, int contClientes) {
			if(contClientes<vetorClientes.length) {
				sc.nextLine();
				System.out.print("Digite seu Nome: ");
				String nome = sc.nextLine();
				
				System.out.print("Digite seu CPF: ");
				String cpf = sc.nextLine();
				
				boolean erro = false;
				
				for (int i = 0; i<=contClientes; i++) {
					if(vetorClientes[i]!=null) {
						if (cpf.equals(vetorClientes[i].getCpf())) {
							erro = true;
						}
					}
				}
					if (erro) {
						System.out.println("CPF já existente!");
					}
					else {
						System.out.print("Digite seu Endereço: ");
						String end = sc.nextLine();
						
						System.out.print("Digite seu Telefone: ");
						String tel = sc.nextLine();
						
						System.out.print("Digite seu Email: ");
						String email = sc.nextLine();
						
						for (int j = 0; j<=contClientes; j++) {
							if(vetorClientes[j]!=null) {
								if (email.equals(vetorClientes[j].getEmail())) {
									erro = true;
								}
							}
						}
							
							if (erro) {
								System.out.println("Email já existente!");
							}
							
							else {
								System.out.print("Digite seu Senha: ");
								String senha = sc.nextLine();
								vetorClientes [contClientes] = new Cliente (nome,cpf,end,tel,email,senha);
								System.out.println("Usuário cadastrado com sucesso!");
							}
						}
					}
			else {
				System.out.println("Nosso sistema de clientes está lotado!");
			}
			
			return vetorClientes;
		}
}
